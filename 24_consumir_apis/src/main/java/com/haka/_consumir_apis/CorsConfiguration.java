package com.haka._consumir_apis;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //liberando app cliente 1
        registry.addMapping("/**") // /** acesso a todas as rotas
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

        //liberando app cliente 2
        registry.addMapping("/topicos/**") // /topicos/** acesso ao topicos e todas as rotas dentro do topicos                .allowedOrigins("http://localhost:4000")
                .allowedMethods("GET", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
