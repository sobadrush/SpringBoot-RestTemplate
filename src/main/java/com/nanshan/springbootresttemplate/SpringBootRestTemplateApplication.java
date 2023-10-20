package com.nanshan.springbootresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = { RestfulConfig.class })
public class SpringBootRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestTemplateApplication.class, args);
    }

}
