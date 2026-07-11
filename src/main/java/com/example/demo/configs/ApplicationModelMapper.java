package com.example.demo.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ApplicationModelMapper {
   @Bean
    // Here create a method for the Model mapper so that we can call each time while making the DTO of object
    public ModelMapper getModelMapper(){
       return new ModelMapper();
   }
}
