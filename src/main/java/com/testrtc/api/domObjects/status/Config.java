
package com.testrtc.api.domObjects.status;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version",
        "systemName",
        "instanceName"
})
public class Config {

    @JsonProperty("version")
    public String version;
    @JsonProperty("systemName")
    public String systemName;
    @JsonProperty("instanceName")
    public String instanceName;

    /**
     * No args constructor for use in serialization
     */
    public Config() {
    }

    /**
     * @param instanceName
     * @param systemName
     * @param version
     */
    public Config(String version, String systemName, String instanceName) {
        super();
        this.version = version;
        this.systemName = systemName;
        this.instanceName = instanceName;
    }

}
