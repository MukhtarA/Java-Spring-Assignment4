package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Payroll payroll = context.getBean("payroll", Payroll.class);
		payroll.menu();
	}
}
