package com.nanshan.springbootresttemplate.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resource_id",
        "fields"
})
public class Result {

    @JsonProperty("resource_id")
    private String resourceId;

    @JsonProperty("fields")
    private List<Field> fields;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("resource_id")
    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty("resource_id")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
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