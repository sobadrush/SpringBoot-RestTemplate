package com.nanshan.springbootresttemplate;

import com.nanshan.springbootresttemplate.utils.restful.ApiConfig;
import com.nanshan.springbootresttemplate.utils.restful.ApiUriConfig;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
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

    @Test
    @DisplayName("[Test_003]: 測試 Apache Http Client 套件發送請求- SSLConnectionSocketFactory (使用 TLS): JSON_PLACEHOLDER")
    @Disabled
    void Test_003() throws IOException {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                SSLContexts.createDefault(),
                new String[]{ "TLSv1.2", "TLSv1.3" },
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        try (CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
             CloseableHttpResponse response = httpClient.execute(new HttpGet(ApiUriConfig.JSON_PLACEHOLDER.getUriInfo() + "/users/2"))
        ) {
            String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            System.out.println(" >>> result users:  " + result);
        }
    }

    @Test
    @DisplayName("[Test_004]: 測試 Apache Http Client 套件發送請求 - HttpClientConnectionManager (使用 TLS): JSON_PLACEHOLDER")
    @Disabled
    void Test_004() throws NoSuchAlgorithmException, IOException {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", new SSLConnectionSocketFactory(SSLContext.getDefault()))
                .register("http", new PlainConnectionSocketFactory())
                .build();

        try (PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
                CloseableHttpResponse response = httpClient.execute(new HttpGet(ApiUriConfig.JSON_PLACEHOLDER.getUriInfo() + "/users/2"))) {
            String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            System.out.println(" >>> result users:  " + result);
        }

    }

}
