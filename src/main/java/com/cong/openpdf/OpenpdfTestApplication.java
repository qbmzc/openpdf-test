package com.cong.openpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class OpenpdfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenpdfTestApplication.class, args);
    }

}
