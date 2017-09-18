package com.lzw.compensation;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class CompensationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompensationApplication.class, args);
    }
}
