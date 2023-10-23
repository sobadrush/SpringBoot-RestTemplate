package com.nanshan.springbootresttemplate.entity.FC0032001;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "result",
    "records"
})
public class FC0032001Rs {

    @JsonProperty("success")
    private String success;

    @JsonProperty("result")
    private Result result;

    @JsonProperty("records")
    private Records records;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(String success) {
        this.success = success;
    }

    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }

    @JsonProperty("records")
    public Records getRecords() {
        return records;
    }

    @JsonProperty("records")
    public void setRecords(Records records) {
        this.records = records;
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