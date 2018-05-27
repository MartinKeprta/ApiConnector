
package com.testrtc.api.domObjects.status;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "role",
        "config",
        "queueStatus",
        "queueCount",
        "dbStatus",
        "dbCount",
        "status"
})
public class Status {

    @JsonProperty("role")
    public Role role;
    @JsonProperty("config")
    public Config config;
    @JsonProperty("queueStatus")
    public String queueStatus;
    @JsonProperty("queueCount")
    public Integer queueCount;
    @JsonProperty("dbStatus")
    public String dbStatus;
    @JsonProperty("dbCount")
    public Integer dbCount;
    @JsonProperty("status")
    public String status;

    /**
     * No args constructor for use in serialization
     */
    public Status() {
    }

    /**
     * @param queueStatus
     * @param dbCount
     * @param status
     * @param dbStatus
     * @param queueCount
     * @param config
     * @param role
     */
    public Status(Role role, Config config, String queueStatus, Integer queueCount, String dbStatus, Integer dbCount, String status) {
        super();
        this.role = role;
        this.config = config;
        this.queueStatus = queueStatus;
        this.queueCount = queueCount;
        this.dbStatus = dbStatus;
        this.dbCount = dbCount;
        this.status = status;
    }

}
