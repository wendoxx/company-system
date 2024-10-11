package org.example.companysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CompanySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanySystemApplication.class, args);
    }

}
