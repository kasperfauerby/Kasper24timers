package com.example.kasper24timers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Kasper24TimersApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kasper24TimersApplication.class, args);
    }

}
