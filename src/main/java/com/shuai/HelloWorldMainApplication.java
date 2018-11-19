package com.shuai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import sun.awt.SunHints;

/**
 * @SpringBootApplication 标注一个主程序类，说明这是一个Spring Boot应用
 */
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
