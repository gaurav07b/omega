package com.ems.config;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.or;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket pocAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(metaInfo())
				.select()
				.paths(path())
				.build();
				//.securitySchemes(Arrays.asList(apiKey()));
	}

//	private ApiKey apiKey() {
//		
//		return new ApiKey("authKey", "Authorization", "header");
//	}
	
//	@Bean
//	public SecurityConfiguration security() {
//		return new SecurityConfiguration(null, null, null, null, "Bearer access_token", ApiKeyVehicle.HEADER, "Authorization", ","); 
//	}

	@SuppressWarnings("unchecked")
	Predicate<String> path() {
		return or(regex("/poc/.*"), regex("/login"), regex("/signup"));
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInf = new ApiInfo("Employee Management System POC", "Spring Boot - Proof of Concept", "1.0",
				"https://spring.io/projects/spring-boot",
				new Contact("Gaurav Bansal", "https://github.com/gaurav07b/omega", "gaurav.bansal@infogain.com"),
				"Infogain Trainee License 1.0", "https://www.infogain.com");

		return apiInf;

	}
}
