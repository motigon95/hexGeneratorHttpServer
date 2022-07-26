package com.example.httpserver;

import com.example.httpserver.utils.Command;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpserverApplication {

	static Command command = new Command();
	public static void main(String[] args) {
		if(!command.isValid(args)) return;
		System.getProperties().put("server.port", command.getPortNumber());
		SpringApplication.run(HttpserverApplication.class, args);
	}
}
