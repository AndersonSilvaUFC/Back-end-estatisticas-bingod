package br.com.bingod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.bingod"))
          .paths(regex("/api.*"))
          .build()
          .apiInfo(metaInfo());
    }
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
		   "Bingod API", 
		   "API REST para o bingo",
		   "1.0",
		   "Terms of Service",
		   new Contact("Francisco Anderson Silva Vieira", "https://www.instagram.com/andersonsilva5434",
	      "andersonsilva@alu.ufc.br"),"Apache License Version 2.0","https://www.apache.org.license.html", new ArrayList<VendorExtension>()
		);
		return apiInfo;
	}
	
}
