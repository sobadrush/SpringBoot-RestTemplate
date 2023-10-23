package com.nanshan.springbootresttemplate.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String pa55wd;
    private Integer age;

    @JsonIgnore
    @JsonAnySetter // 方法和属性上只需要一處標注即可
    private Map<String, String> additionalAttrs = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getAdditionalAttrs() {
        return additionalAttrs;
    }

    // @JsonAnySetter
    // public void testAdditionalAttrs(String key, String value) {
    //     additionalAttrs.put(key, value);
    // }

    // /**
    //  * 測試：@JsonAnyGetter
    //  */
    // public static void main(String[] args) throws JsonProcessingException {
    //     User userA = User.builder()
    //         .username("Roger")
    //         .pa55wd("1qaz@WSX")
    //         .age(23)
    //         .additionalAttrs(Map.of(
    //         "test1", "testOne",
    //         "test2", "testTwo"))
    //         .build();
    //
    //     String jsonResult = new ObjectMapper().writeValueAsString(userA);
    //     System.out.println("jsonResult = " + jsonResult);
    // }

    /**
     * 測試：@JsonAnySetter
     */
    public static void main(String[] args) throws JsonProcessingException {
        String jsonStr = "{\"username\":\"Roger\",\"pa55wd\":\"1qaz@WSX\",\"age\":23,\"test1\":\"testOne\",\"test2\":\"testTwo\"}";
        User userB = new ObjectMapper().readValue(jsonStr, User.class);
        System.out.println("userB = " + userB);
    }
}
