package com.testrtc.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.testrtc.api.domObjects.error.TestRTCError;
import com.testrtc.api.domObjects.status.Status;
import com.testrtc.api.domObjects.testAgent.TestAgent;
import com.testrtc.api.domObjects.testDefinition.TestDefinition;
import com.testrtc.api.domObjects.testRun.TestRun;
import com.testrtc.api.domObjects.testRunId.TestRunId;
import com.testrtc.api.exceptions.TestRTCExcepction;


import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Martin Keprta on 2/21/2018.
 */
public final class WebRtcApiConnector {
    private static String baseUrl = null;
    private static String apiKey = null;
    private static ObjectMapper mapper = new ObjectMapper();

    public String getBaseUrl(){
        return baseUrl;
    }

    public static String getApiKey() {
        return apiKey;
    }
    //This is unsafe method.Breaks test.Only for negative test usage
    public static void setApiKey(String newApiKey){
        apiKey=newApiKey;
    }

    public static Status checkStatus() throws  TestRTCExcepction {

        Status status=null;


        try {
            HttpResponse<String> response = Unirest.get(baseUrl +"status-page")
                    .header("accept", "application/json")
                  //  .header("apikey", apiKey)
                    .asString();


            if (response.getStatus()==200){
                try {
                    status=mapper.readValue(response.getBody(),Status.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                TestRTCError e = mapper.readValue(response.getBody(),TestRTCError.class);
                throw new TestRTCExcepction(e);
            }

        }
        catch (UnirestException e){
            System.out.println("Error during checking credentials");
            return null;
        }  catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Credentials ok");
        return status;
    }

    //Create API object + sets up constructor
    public static void setCredentials(String key, String url,Boolean validate) {


        System.out.println("Setting credentials");

        baseUrl = url;

        if(validate){
            apiKey=validateApiKey(key);
        }else {
            apiKey=key;
        }



        //apiKey=key;

        if (apiKey!=null) {
            Unirest.setDefaultHeader("apikey", apiKey);
        }else {
            Unirest.clearDefaultHeaders();
            Unirest.setDefaultHeader("Content-Type", "application/json");

        }
        Unirest.setDefaultHeader("Content-Type", "application/json");
        Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {

            private ObjectMapper mapper = new ObjectMapper();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });


    }
    public static TestRun launchTest(String testId) throws TestRTCExcepction, IOException {

        //validateApiKey(apiKey);

        String testRunId = executeTest(testId).getTestRunId();
        Boolean testFinished = false;

        while (testFinished == false) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String status = getTestStatus(testRunId).status;
            System.out.println("TestRTCTest status :" + status);

            switch (status) {
                case "completed":
                    testFinished = true;
                    break;
                case "warnings":
                    testFinished = true;
                    break;
                case "failure":
                    testFinished = true;
                    break;
                case "service-failure":
                    testFinished = true;
                    break;
                default:
                    testFinished = false;
            }
        }
       return getTestStatus(testRunId);
    }

    public static TestRun getTestStatus(String testRunId) {
        HttpResponse<TestRun> response = null;

        try {
            response = Unirest.get(baseUrl + "testruns/{testRunId}")
                    .routeParam("testRunId", testRunId)
                    .asObject(TestRun.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        return response.getBody();
    }

    //Executes test and return JSON with information

    public static TestRunId executeTest(String testId) throws TestRTCExcepction, IOException {
        System.out.println("Executing test" + testId);
        //Execute request
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(baseUrl + "tests/{testId}/run").routeParam("testId", testId).asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response.getStatus()==200){
            try {
                return mapper.readValue(response.getBody(),TestRunId.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {

            throw new TestRTCExcepction(mapper.readValue(response.getBody(),TestRTCError.class));
        }
        return null;
    }

    public static String validateApiKey(String apiKey) {
        try {
            HttpResponse<String> status = Unirest.get(baseUrl + "status-page").header("apikey", apiKey).header("Content-Type", "application/json").asString();

            if (status.getStatus() != HttpURLConnection.HTTP_OK) {
                new RuntimeException("Invalid credentials!");
            } else {
                System.out.println("API key: " + apiKey + " verified");
                return apiKey;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static TestAgent getTestAgentInformation(String agentId) {
        HttpResponse<TestAgent> response = null;

        try {
            response = Unirest.get(baseUrl + "testagents/{agentId}")
                    .routeParam("agentId", agentId)
                    .asObject(TestAgent.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        return response.getBody();
    }

    public static TestDefinition updateTestDefinition(TestDefinition test,String testId){

        try {
            HttpResponse<String> response = Unirest.put(baseUrl+"test_definitions/{testId}")
                    .routeParam(testId,"testId")
                    .body("{\n  \"name\": \""+test.getName()+"\",\n  \"info\": \""+test.getDescription()+"\",\n  \"runOptions\": \""+test.getRunOptions()+"\",\n  \"stared\": true,\n  \"testScript\": \"string\",\n  \"isRemote\": true,\n  \"serviceUrl\": \"string\",\n  \"serviceUrlOpen\": true,\n  \"browserType\": \"string\",\n  \"browserVersion\": \"string\",\n\t\"description\":\"description\"\n}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        return getTestDefinition(testId);
    }

    public static TestDefinition getTestDefinition(String testId){
        HttpResponse<TestDefinition> response = null;

        if (testId==null){
            new RuntimeException("Test id is null!");
        }
        try {
            response = Unirest.get(baseUrl + "tests/{testId}")
                    .routeParam("testId", testId)
                    .asObject(TestDefinition.class);
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }


        return response.getBody();




    }
    public static void dropCredentials() {
      //  baseUrl=null;
        apiKey=null;
    }

}
