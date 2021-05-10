package com.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@ComponentScan({ "com.sse" })
public class ServerSentEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSentEventsApplication.class, args);
	}

}
