package com.bappi.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bappi.learn"})
public class RabbitmqImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqImplApplication.class, args);
    }

}
