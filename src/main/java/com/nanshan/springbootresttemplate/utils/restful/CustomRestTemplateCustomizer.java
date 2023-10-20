package com.nanshan.springbootresttemplate.utils.restful;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

/**
 * @author RogerLo
 * @date 2023/10/20
 * ref. https://www.baeldung.com/spring-rest-template-builder
 */
public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
    }

}