package com.example.managementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.example.managementsystem.Mapper")
//public class ManagementsystemApplication  extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ManagementsystemApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources((ManagementsystemApplication.class));
//    }
//}
public class ManagementsystemApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ManagementsystemApplication.class, args);
    }

}