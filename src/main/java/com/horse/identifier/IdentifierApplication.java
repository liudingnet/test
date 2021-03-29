package com.horse.identifier;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.horse.identifier.mapper")
public class IdentifierApplication {
	public static void main(String[] args) {
		SpringApplication.run(IdentifierApplication.class, args);
	}

}
