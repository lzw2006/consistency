package com.lzw.trainservice;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class TrainServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainServiceApplication.class, args);
    }
}
