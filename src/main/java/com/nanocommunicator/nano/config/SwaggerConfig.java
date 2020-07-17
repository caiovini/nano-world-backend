package com.nanocommunicator.nano.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.nanocommunicator.nano.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(this.apiInfo());                                           
    }
	
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Nano comunicator")
	            .description("Application to show nano peers around the world")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Caio Vinicius", "", "caio2791@yahoo.com.br"))
	            .build();
	}

}

