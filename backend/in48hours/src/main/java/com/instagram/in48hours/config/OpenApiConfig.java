package com.instagram.in48hours.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name="TuanDat",
						email="nguyentuandat1601@gmail.com"
						),
				description = "OpenApi documentation for Spring security",
				title = "OpenApi Instagram - TuanDat",
				version = "1.0",
				license = @License(
						name ="Dat License"
						
						),
				termsOfService = "Term of service"
				),
		servers = @Server(
				description = "Local EVN",
				url="http://localhost:8080"
				)
		
		)
@SecurityScheme(
		name="bearerAuth",
		description = "JWT auth description",
		scheme = "bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		in = SecuritySchemeIn.HEADER
		
		)

public class OpenApiConfig {

}
