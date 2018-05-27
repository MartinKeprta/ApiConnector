
package com.testrtc.api.domObjects.testAgent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "direction",
        "type",
        "codec"
})
@ToString
public class Channel {

    @JsonProperty("name")
    public String name;
    @JsonProperty("direction")
    public String direction;
    @JsonProperty("type")
    public String type;
    @JsonProperty("codec")
    public String codec;

    /**
     * No args constructor for use in serialization
     */
    public Channel() {
    }

    /**
     * @param direction
     * @param name
     * @param codec
     * @param type
     */
    public Channel(String name, String direction, String type, String codec) {
        super();
        this.name = name;
        this.direction = direction;
        this.type = type;
        this.codec = codec;
    }

}
