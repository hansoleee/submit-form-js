package com.hansoleee.submitformjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SubmitFormJsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubmitFormJsApplication.class, args);
    }

}
