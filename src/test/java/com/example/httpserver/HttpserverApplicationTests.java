package com.example.httpserver;

import com.example.httpserver.controller.HexController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HttpserverApplicationTests {

	@Autowired
	private HexController hexController;

	@Test
	void contextLoads() {
		String[] args = new String[2];
		args[0] = "-port";
		args[1] = "8888";
		HttpserverApplication.main(args);
		assertThat(hexController).isNotNull();
	}
}
