package com.nanshan.springbootresttemplate.entity.FC0032001;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "parameterName",
        "parameterValue"
})
public class Parameter {

    @JsonProperty("parameterName")
    private String parameterName;

    @JsonProperty("parameterValue")
    private String parameterValue;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("parameterName")
    public String getParameterName() {
        return parameterName;
    }

    @JsonProperty("parameterName")
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @JsonProperty("parameterValue")
    public String getParameterValue() {
        return parameterValue;
    }

    @JsonProperty("parameterValue")
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
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