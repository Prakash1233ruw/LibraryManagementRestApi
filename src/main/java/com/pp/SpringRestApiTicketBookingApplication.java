package com.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library Management API", 
version = "1.0",
description = "An API for Library Management"),
servers = @Server(url = "http://localhost:8787/LibraryManagementAPP",
		            description = " This API URL will help Store books and status of book loans"))
public class SpringRestApiTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiTicketBookingApplication.class, args);
	}

}
