package com.nanshan.springbootresttemplate;

import com.nanshan.springbootresttemplate.utils.restful.CustomRestTemplateCustomizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author RogerLo
 * @date 2023/10/20
 */
@Configuration
public class RestfulConfig {

    @Bean
    public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
        return new CustomRestTemplateCustomizer();
    }

    @Bean("simpleClientHttpRequestFactory")
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        // factory.setConnectTimeout(5000);
        return factory;
    }

    @Bean(name = "myRestTemplateBuilder")
    @DependsOn(value = { "customRestTemplateCustomizer" })
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder(this.customRestTemplateCustomizer());
    }

    @Bean(name = "RogerRestTemplate")
    @DependsOn(value = { "myRestTemplateBuilder" })
    public RestTemplate restTemplate(@Qualifier(value = "myRestTemplateBuilder") RestTemplateBuilder builder,
             @Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory httpRequestFactory) {
        RestTemplate restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .build();
        restTemplate.setRequestFactory(httpRequestFactory);
        return restTemplate;
    }

}
