package com.cabhow.rest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@EnableWebMvc
@Profile("!prod")
public class APISwaggerConfig {

	private static final String TITLE = "Cabhow.com Bookings Service API";
	public static final String TRANS_TYPE = "";

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info().title(TITLE).description("This API contains all the booking related stuff"));
	}
}
