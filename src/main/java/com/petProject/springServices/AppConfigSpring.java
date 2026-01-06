package com.petProject.springServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.http.HttpClient;

@Configuration
@ComponentScan("com.petProject.config.services.springServices")

@PropertySource("classpath:test_properties")
//Spring resolves classpath: relative to src/main/resources

public class AppConfigSpring {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public String beanName1() {
        return "beanName1";
    }


}

