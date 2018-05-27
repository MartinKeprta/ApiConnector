
package com.testrtc.api.domObjects.testAgent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "testAgentId",
        "testRunId",
        "testId",
        "status",
        "machine",
        "os",
        "browser",
        "location",
        "networkProfile",
        "firewallProfile",
        "mediaFile",
        "agentIdx",
        "sessionIdx",
        "inSessionIdx",
        "startTime",
        "duration",
        "customMetrics",
        "channels"
})
@ToString
public class TestAgent {

    @JsonProperty("testAgentId")
    public String testAgentId;
    @JsonProperty("testRunId")
    public String testRunId;
    @JsonProperty("testId")
    public String testId;
    @JsonProperty("status")
    public String status;
    @JsonProperty("machine")
    public String machine;
    @JsonProperty("os")
    public String os;
    @JsonProperty("browser")
    public Browser browser;
    @JsonProperty("location")
    public String location;
    @JsonProperty("networkProfile")
    public String networkProfile;
    @JsonProperty("firewallProfile")
    public String firewallProfile;
    @JsonProperty("mediaFile")
    public String mediaFile;
    @JsonProperty("agentIdx")
    public Integer agentIdx;
    @JsonProperty("sessionIdx")
    public Integer sessionIdx;
    @JsonProperty("inSessionIdx")
    public Integer inSessionIdx;
    @JsonProperty("startTime")
    public String startTime;
    @JsonProperty("duration")
    public Integer duration;
    @JsonProperty("customMetrics")
    public List<CustomMetric> customMetrics = null;
    @JsonProperty("channels")
    public List<Channel> channels = null;

    /**
     * No args constructor for use in serialization
     */


    public TestAgent() {
    }

    /**
     * @param os
     * @param testAgentId
     * @param testRunId
     * @param testId
     * @param mediaFile
     * @param status
     * @param location
     * @param channels
     * @param firewallProfile
     * @param machine
     * @param startTime
     * @param sessionIdx
     * @param duration
     * @param customMetrics
     * @param browser
     * @param inSessionIdx
     * @param agentIdx
     * @param networkProfile
     */
    public TestAgent(String testAgentId, String testRunId, String testId, String status, String machine, String os, Browser browser, String location, String networkProfile, String firewallProfile, String mediaFile, Integer agentIdx, Integer sessionIdx, Integer inSessionIdx, String startTime, Integer duration, List<CustomMetric> customMetrics, List<Channel> channels) {
        super();
        this.testAgentId = testAgentId;
        this.testRunId = testRunId;
        this.testId = testId;
        this.status = status;
        this.machine = machine;
        this.os = os;
        this.browser = browser;
        this.location = location;
        this.networkProfile = networkProfile;
        this.firewallProfile = firewallProfile;
        this.mediaFile = mediaFile;
        this.agentIdx = agentIdx;
        this.sessionIdx = sessionIdx;
        this.inSessionIdx = inSessionIdx;
        this.startTime = startTime;
        this.duration = duration;
        this.customMetrics = customMetrics;
        this.channels = channels;
    }

}
