package com.testrtc.api.domObjects.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "message"
})
@AllArgsConstructor
public class TestRTCError {

    @JsonProperty("code")
    public Integer code;
    @JsonProperty("message")
    public String message;

}