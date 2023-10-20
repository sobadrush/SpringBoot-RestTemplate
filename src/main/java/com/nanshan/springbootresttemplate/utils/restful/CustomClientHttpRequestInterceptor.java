package com.nanshan.springbootresttemplate.utils.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author RogerLo
 * @date 2023/10/20
 * ref. https://www.baeldung.com/spring-rest-template-builder
 */
public class CustomClientHttpRequestInterceptor
        implements org.springframework.http.client.ClientHttpRequestInterceptor {

    private static Logger logger = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        this.logRequestDetails(request);
        return execution.execute(request, body);
    }

    private void logRequestDetails(HttpRequest request) {
        logger.info(">>> Headers: {}", request.getHeaders());
        logger.info(">>> Request Method: {}", request.getMethod());
        logger.info(">>> Request URI: {}", request.getURI());
    }

}
