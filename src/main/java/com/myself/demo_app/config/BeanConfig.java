package com.myself.demo_app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
