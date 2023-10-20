package com.nanshan.springbootresttemplate;

import com.nanshan.springbootresttemplate.utils.restful.CustomRestTemplateCustomizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

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

    @Bean(name = "myRestTemplateBuilder")
    @DependsOn(value = { "customRestTemplateCustomizer" })
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder(this.customRestTemplateCustomizer());
    }

    @Bean(name = "RogerRestTemplate")
    @DependsOn(value = { "myRestTemplateBuilder" })
    public RestTemplate restTemplate(@Qualifier(value = "myRestTemplateBuilder") RestTemplateBuilder builder) {
        return builder.build();
    }

}
