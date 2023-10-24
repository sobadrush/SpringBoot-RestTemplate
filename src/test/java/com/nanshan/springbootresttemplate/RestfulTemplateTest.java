package com.nanshan.springbootresttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanshan.springbootresttemplate.entity.FC0032001.FC0032001Rs;
import com.nanshan.springbootresttemplate.utils.restful.ApiConfig;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
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

    private static String PRODUCT_ID;

    @Test
    @DisplayName("test001")
    @Disabled
    public void test001() {
        System.out.println("port = " + port);
        System.out.println("restTemplate = " + restTemplate);
    }

    @Test
    @DisplayName("test002: 發送 GET 請求測試")
    @Disabled
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
        PRODUCT_ID = resp.get("id");
    }

    @Test
    @DisplayName("Test004: 使用 exchange 發送自訂請求 (PATCH)")
    public void test004() {
        String productId = PRODUCT_ID;
        String url = MessageFormat.format("https://api.restful-api.dev/objects/{0}", "ff8081818b1b4123018b5f89dfa462d0");

        Map<String, String> paramMap = Map.of("name", "Nintendo Switch (PATCH 修改)");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-api-key", "g9i4SZ5iqGVcXB4A"); // 自訂 HEADER

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(paramMap, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PATCH, httpEntity, String.class);
        System.err.println("[response.getStatusCode]： " + response.getStatusCode());
        System.err.println("[response.getBody]： " + response.getBody());
    }

}
