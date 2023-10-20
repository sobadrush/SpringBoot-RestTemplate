package com.nanshan.springbootresttemplate.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "datasetDescription",
        "location"
})
public class Records {

    @JsonProperty("datasetDescription")
    private String datasetDescription;

    @JsonProperty("location")
    private List<Location> location;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("datasetDescription")
    public String getDatasetDescription() {
        return datasetDescription;
    }

    @JsonProperty("datasetDescription")
    public void setDatasetDescription(String datasetDescription) {
        this.datasetDescription = datasetDescription;
    }

    @JsonProperty("location")
    public List<Location> getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(List<Location> location) {
        this.location = location;
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