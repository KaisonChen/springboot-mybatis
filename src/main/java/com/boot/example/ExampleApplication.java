package com.boot.example;

import com.boot.example.filter.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.boot.example.dao")
@SpringBootApplication
@EnableScheduling
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterDemo4Registration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//注入过滤器
		registration.setFilter(new CorsFilter());
		//拦截规则
		registration.addUrlPatterns("*");
		//过滤器名称
		registration.setName("DemoFilter");
		//是否自动注册 false 取消Filter的自动注册
		registration.setEnabled(false);
		//过滤器顺序
		registration.setOrder(1);
		return registration;
	}
}
