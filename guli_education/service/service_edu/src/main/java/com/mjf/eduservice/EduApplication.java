package com.mjf.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LDlim
 * @date 2020/12/27 11:11
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mjf"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
