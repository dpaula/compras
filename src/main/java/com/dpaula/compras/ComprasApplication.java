package com.dpaula.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ComprasApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ComprasApplication.class, args);
    }

}
