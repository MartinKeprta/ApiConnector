
package com.testrtc.api.domObjects.testDefinition;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.testrtc.api.WebRtcApiConnector;
import com.testrtc.api.domObjects.error.TestRTCError;
import com.testrtc.api.exceptions.TestRTCExcepction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "concurrentUsers",
        "name",
        "description",
        "runOptions",
        "serviceUrl",
        "testId",
        "iterations",
        "script",
        "testProfiles"
})
@Getter
@Setter
@AllArgsConstructor
public class TestDefinition {

    @JsonProperty("concurrentUsers")
    public Integer concurrentUsers;
    @JsonProperty("description")
    public String description;
    @JsonProperty("name")
    public String name;
    @JsonProperty("runOptions")
    public String runOptions;
    @JsonProperty("serviceUrl")
    public String serviceUrl;
    @JsonProperty("testId")
    public String testId;
    @JsonProperty("iterations")
    public Integer iterations;
    @JsonProperty("script")
    public String script;
    @JsonProperty("testProfiles")
    public List<TestProfile> testProfiles;
}

