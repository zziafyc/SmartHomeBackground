package com.zhongyong.smarthome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//入口
@SpringBootApplication
public class SmartHomeBackGroundApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SmartHomeBackGroundApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SmartHomeBackGroundApplication.class, args);
    }
}
