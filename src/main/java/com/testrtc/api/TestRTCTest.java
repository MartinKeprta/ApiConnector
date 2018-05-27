package com.testrtc.api;

import com.testrtc.api.domObjects.testDefinition.RunOption;
import com.testrtc.api.domObjects.testDefinition.TestDefinition;
import com.testrtc.api.domObjects.testRun.TestRun;
import com.testrtc.api.exceptions.TestRTCExcepction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestRTCTest {
    private int retries=1;
    private String testId;
    private TestDefinition testDefinition;
    private List<RunOption> runOptions=new ArrayList<>();
    //Empty constructor if we are going to build a new test
    public TestRTCTest(){


    }
    //Create test from ID
    public TestRTCTest fromId(String testId){
        this.testId=testId;
        //Set name of test
        //definition.setName(testId);
        testDefinition = WebRtcApiConnector.getTestDefinition(testId);
        return this;
    }
    //Create test from file
    //TODO
    public TestRTCTest fromFile(File file){

        return this;
    }




    public TestRTCTest addRunOption(String option,String value){
        runOptions.add(new RunOption(option,value));
        updateRunOptions();
        return this;
    }

    public TestRTCTest repeatOnFailure(int retries) throws TestRTCExcepction {
        this.retries=retries;
        if (retries>3){
            throw new TestRTCExcepction("Retries on failure cannot be more then 3!");
        }

        return this;
    }

    public TestRTCTest addRunOption(String option){
        runOptions.add(new RunOption(option));
        updateRunOptions();
        return this;
    }
    private String updateRunOptions(){
        String response="";

        for (RunOption o:runOptions){
            response+=o;
        }

        return response;
    }

    public List<RunOption> getRunOptions(){
        return runOptions;
    }

    public TestRTCTest setEnviromentVariable(String variable,String value){

        return this;
    }
    public TestRTCTest setDescription(String description) {
        testDefinition.setDescription(description);
        return this;
    }

    public TestRTCTest update(){

        WebRtcApiConnector.updateTestDefinition(testDefinition,testId);
        return this;

    }
    public TestRun run() {
        retries=retries-1;


        try {

            TestRun testRun =   WebRtcApiConnector.launchTest(testId);

            if (testRun.isPassed()||retries==0){

                return testRun;
            }else return run();
        } catch (TestRTCExcepction testRTCExcepction) {
            testRTCExcepction.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
