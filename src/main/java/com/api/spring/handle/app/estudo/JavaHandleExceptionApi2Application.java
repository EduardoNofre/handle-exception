package com.api.spring.handle.app.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaHandleExceptionApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaHandleExceptionApi2Application.class, args);
	}

}
