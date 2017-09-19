package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDubboClientApplication {

    public static void main(String[] args) {
        /*ConfigurableApplicationContext run = SpringApplication.run(BootDubboClientApplication.class, args);
        ResponseServiceImpl response = (ResponseServiceImpl) run.getBean(ResponseService.class);
        response.reply();*/
       SpringApplication.run(BootDubboClientApplication.class, args);
    }
}
