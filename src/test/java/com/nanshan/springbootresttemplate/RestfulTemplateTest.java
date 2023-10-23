package com.nanshan.springbootresttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanshan.springbootresttemplate.entity.FC0032001.FC0032001Rs;
import com.nanshan.springbootresttemplate.utils.restful.ApiConfig;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author RogerLo
 * @date 2023/10/20
 */
public class RestfulTemplateTest extends BaseTest {

    @LocalServerPort
    private int port;

    @Resource(name = "RogerRestTemplate")
    private RestTemplate restTemplate;

    @Test
    @DisplayName("test001")
    // @Disabled
    public void test001() {
        System.out.println("port = " + port);
        System.out.println("restTemplate = " + restTemplate);
    }

    @Test
    @DisplayName("test002: 發送 GET 請求測試")
    // @Disabled
    public void test002() {
        String url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization={authCode}&limit=1&locationName={area}&elementName=Wx&sort=time";
        Map<String, String> params = Map.of(
        "authCode", ApiConfig.AUTH_CODE.getVal(),
        "area", "臺北市"
        );
        // String respBody = restTemplate.getForObject(url, String.class, params);
        FC0032001Rs fc0032001Rs = restTemplate.getForObject(url, FC0032001Rs.class, params);
        System.out.println("fc0032001Rs = " + fc0032001Rs);
    }

    @Test
    @DisplayName("Test003: 發送 POST 請求測試")
    public void test003() throws JsonProcessingException {
        String url = "https://api.restful-api.dev/objects";
        String postJson = "{" +
                            "   \"name\": \"Apple MacBook Pro 16\"," +
                            "   \"data\": {" +
                            "      \"year\": 2019," +
                            "      \"price\": 1849.99," +
                            "      \"CPU model\": \"Intel Core i9\"," +
                            "      \"Hard disk size\": \"1 TB\"" +
                            "   }" +
                            "}";
        Map jsonMapForPost = new ObjectMapper().readValue(postJson, Map.class);
        System.err.println("postJson = " + postJson);
        Map<String, String> resp = restTemplate.postForObject(url, jsonMapForPost, Map.class);
        // String resp = restTemplate.postForObject(url, jsonMapForPost, String.class);
        System.err.println("resp = " + resp);
    }

}
