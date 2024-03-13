package com.jtbank.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://localhost:1400")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
//@Configuration
//public class CorsConfig {
//    @Bean
//    WebMvcConfigurer corsconfigure(){
//        return addCorsMappings(registry) -> {
//          registry.addMapping(pathPatteren "/**")
//                  ,allowedOrigins("https://localhost:1400")
//                  ,allowedMethods("GET","POST","PUT","PATCH","DELETE")
//                  ,allowedHeaders("*");
//        };
//    }
//}
