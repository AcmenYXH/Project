package com.carss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageInterceptor;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.carss.mapper")
public class CarSharingSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSharingSysApplication.class, args);
	}
	@Bean
    public PageInterceptor pageHelper() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        properties.setProperty("reasonable", "true");
        properties.setProperty("offsetAsPageNum", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

}
