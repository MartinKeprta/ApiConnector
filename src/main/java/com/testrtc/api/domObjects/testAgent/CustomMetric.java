
package com.testrtc.api.domObjects.testAgent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "value"
})
@ToString
public class CustomMetric {

    @JsonProperty("name")
    public String name;
    @JsonProperty("value")
    public String value;

    /**
     * No args constructor for use in serialization
     */
    public CustomMetric() {
    }

    /**
     * @param name
     * @param value
     */
    public CustomMetric(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

}
