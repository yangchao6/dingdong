package com.example.DingDong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.example.DingDong.dao")
public class DingDongApplication {

	public static void main(String[] args) {
		SpringApplication.run(DingDongApplication.class, args);
	}
}
