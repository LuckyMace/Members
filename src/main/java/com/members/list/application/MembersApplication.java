package com.members.list.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.members.list.repository")
@ComponentScan(basePackages = "com.members.list")
public class MembersApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MembersApplication.class, args);
	}

}

