package com.prototype.enc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PrototypeEncApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeEncApplication.class, args);
	}
}
