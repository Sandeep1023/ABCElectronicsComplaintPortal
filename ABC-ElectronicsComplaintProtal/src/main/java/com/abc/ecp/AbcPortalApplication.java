package com.abc.ecp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("{com.cg.cp.dto.Complaints}")
public class AbcPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcPortalApplication.class, args);
	}

}
