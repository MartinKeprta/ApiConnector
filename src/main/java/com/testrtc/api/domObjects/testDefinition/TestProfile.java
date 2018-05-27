
package com.testrtc.api.domObjects.testDefinition;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "media",
    "firewall",
    "network",
    "location",
    "browser"
})
@Getter
@Setter
@ToString
public class TestProfile {

    @JsonProperty("media")
    public String media;
    @JsonProperty("firewall")
    public String firewall;
    @JsonProperty("network")
    public String network;
    @JsonProperty("location")
    public String location;
    @JsonProperty("browser")
    public String browser;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TestProfile() {
    }

    /**
     * 
     * @param firewall
     * @param location
     * @param browser
     * @param media
     * @param network
     */
    public TestProfile(String media, String firewall, String network, String location, String browser) {
        super();
        this.media = media;
        this.firewall = firewall;
        this.network = network;
        this.location = location;
        this.browser = browser;
    }

}
