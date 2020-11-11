package com.app.charlie;

import com.app.charlie.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaPracticeApplication {

	public static void main(String[] args) {
	  SpringApplication.run(AppConfig.class, args);
	}

}
