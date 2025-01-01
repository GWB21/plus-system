package com.cas.backend;

import com.cas.backend.model.Num;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
        Integer input = 3;
        Num num = new Num(input);
        System.out.println(num);
    }

}
