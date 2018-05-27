
package com.testrtc.api.domObjects.testDefinition;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iterationMode",
    "loopCount",
    "duration",
    "concurrentUsers"
})
@Getter
@Setter
@ToString
public class Parameters {

    @JsonProperty("iterationMode")
    public String iterationMode;
    @JsonProperty("loopCount")
    public Integer loopCount;
    @JsonProperty("duration")
    public Integer duration;
    @JsonProperty("concurrentUsers")
    public Integer concurrentUsers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parameters() {
    }

    /**
     * 
     * @param loopCount
     * @param duration
     * @param iterationMode
     * @param concurrentUsers
     */
    public Parameters(String iterationMode, Integer loopCount, Integer duration, Integer concurrentUsers) {
        super();
        this.iterationMode = iterationMode;
        this.loopCount = loopCount;
        this.duration = duration;
        this.concurrentUsers = concurrentUsers;
    }

}
