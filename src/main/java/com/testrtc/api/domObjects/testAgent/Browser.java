
package com.testrtc.api.domObjects.testAgent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "version"
})
@ToString
public class Browser {

    @JsonProperty("name")
    public String name;
    @JsonProperty("version")
    public String version;

    /**
     * No args constructor for use in serialization
     */
    public Browser() {
    }

    /**
     * @param name
     * @param version
     */
    public Browser(String name, String version) {
        super();
        this.name = name;
        this.version = version;
    }

}
