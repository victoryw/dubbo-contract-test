package com.victory.dubbo.contracttest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ContractTestApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ContractTestApplication.class)
				.web(false)
				.run(args);
	}

}
