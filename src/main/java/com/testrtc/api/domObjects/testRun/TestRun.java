
package com.testrtc.api.domObjects.testRun;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.testrtc.api.domObjects.error.TestRTCError;
import com.testrtc.api.exceptions.TestRTCExcepction;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "concurrentUsers",
        "duration",
        "totalSessions",
        "testRunId",
        "runType",
        "totalIncomingData",
        "totalOutgoingData",
        "testId",
        "startTime",
        "status",
        "agents",
        "url"
})
@ToString
public class TestRun {

    @JsonProperty("concurrentUsers")
    public Integer concurrentUsers;
    @JsonProperty("duration")
    public Integer duration;
    @JsonProperty("totalSessions")
    public Integer totalSessions;
    @JsonProperty("testRunId")
    public String testRunId;
    @JsonProperty("runType")
    public String runType;
    @JsonProperty("totalIncomingData")
    public Integer totalIncomingData;
    @JsonProperty("totalOutgoingData")
    public Integer totalOutgoingData;
    @JsonProperty("testId")
    public String testId;
    @JsonProperty("startTime")
    public String startTime;
    @JsonProperty("status")
    public String status;
    @JsonProperty("agents")
    public List<String> agents = null;
    @JsonProperty("url")
    public String url;

    /**
     * No args constructor for use in serialization
     */
    public TestRun() {
    }

    /**
     * @param startTime
     * @param totalSessions
     * @param duration
     * @param testId
     * @param testRunId
     * @param status
     * @param runType
     * @param agents
     * @param totalOutgoingData
     * @param totalIncomingData
     * @param concurrentUsers
     * @param url
     */
    public TestRun(Integer concurrentUsers, Integer duration, Integer totalSessions, String testRunId, String runType, Integer totalIncomingData, Integer totalOutgoingData, String testId, String startTime, String status, List<String> agents, String url) {
        super();
        this.concurrentUsers = concurrentUsers;
        this.duration = duration;
        this.totalSessions = totalSessions;
        this.testRunId = testRunId;
        this.runType = runType;
        this.totalIncomingData = totalIncomingData;
        this.totalOutgoingData = totalOutgoingData;
        this.testId = testId;
        this.startTime = startTime;
        this.status = status;
        this.agents = agents;
        this.url = url;
    }

    public Boolean isPassed(){
        if (status.equals("success")){
            return true;
        }else {
            return false;
        }
    }
}
