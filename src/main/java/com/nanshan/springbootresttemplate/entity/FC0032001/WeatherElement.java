package com.nanshan.springbootresttemplate.entity.FC0032001;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "elementName",
        "time"
})
public class WeatherElement {

    @JsonProperty("elementName")
    private String elementName;

    @JsonProperty("time")
    private List<Time> time;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("elementName")
    public String getElementName() {
        return elementName;
    }

    @JsonProperty("elementName")
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @JsonProperty("time")
    public List<Time> getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(List<Time> time) {
        this.time = time;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}