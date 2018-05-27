package com.testrtc.api.domObjects.testRunId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Martin Keprta on 2/21/2018.
 */
@Getter
@Setter
@ToString
public class TestRunId {
    private String testRunId;

    public TestRunId(@JsonProperty("testRunId") String testRunId) {
        this.testRunId = testRunId;
    }
}
