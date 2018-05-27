
package com.testrtc.api.domObjects.status;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "web",
        "monitor",
        "batchexec",
        "remoteWorker",
        "api"
})
public class Role {

    @JsonProperty("web")
    public Boolean web;
    @JsonProperty("monitor")
    public Boolean monitor;
    @JsonProperty("batchexec")
    public Boolean batchexec;
    @JsonProperty("remoteWorker")
    public Boolean remoteWorker;
    @JsonProperty("api")
    public Boolean api;

    /**
     * No args constructor for use in serialization
     */
    public Role() {
    }

    /**
     * @param monitor
     * @param batchexec
     * @param api
     * @param web
     * @param remoteWorker
     */
    public Role(Boolean web, Boolean monitor, Boolean batchexec, Boolean remoteWorker, Boolean api) {
        super();
        this.web = web;
        this.monitor = monitor;
        this.batchexec = batchexec;
        this.remoteWorker = remoteWorker;
        this.api = api;
    }

}
