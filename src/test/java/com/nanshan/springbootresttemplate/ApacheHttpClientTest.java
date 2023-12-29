package com.nanshan.springbootresttemplate;

import com.nanshan.springbootresttemplate.utils.restful.ApiConfig;
import com.nanshan.springbootresttemplate.utils.restful.ApiUriConfig;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * @author RogerLo
 * @date 2023/12/28
 */
public class ApacheHttpClientTest extends BaseTest {

    @Test
    @DisplayName("[Test_001]: 測試 Apache Http Client 套件發送請求: JSON_PLACEHOLDER")
    @Disabled
    // ref. https://www.tutorialspoint.com/apache_httpclient/apache_httpclient_http_get_request.htm
    // ref. Setting the TLS Version Statically: https://www.baeldung.com/apache-httpclient-tls
    void test_001() throws IOException {

        System.out.println(">>> port: " + port);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(new HttpGet(ApiUriConfig.JSON_PLACEHOLDER.getUriInfo() + "/users/1"))
        ) {
            String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            System.out.println(" >>> result users:  " + result);
        }
    }

    @Test
    @DisplayName("[Test_002]: 測試 Apache Http Client 套件發送請求: WEATHER_API")
    @Disabled
    void test_002() throws IOException {

        String queryStringAndAuthCode = MessageFormat.format("?Authorization={0}&limit=1&locationName={1}&elementName=Wx&sort=time", ApiConfig.AUTH_CODE.getVal(), "臺北市");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(new HttpGet(ApiUriConfig.WEATHER_API.getUriInfo() + queryStringAndAuthCode))
        ) {
            String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            System.out.println(" >>> result users:  " + result);
        }
    }

}
