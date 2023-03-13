package com.ashokit.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ashokit.mvc.interceptor.TimerInterceptor;

@SpringBootApplication
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource msgSource = new ReloadableResourceBundleMessageSource();
		msgSource.setBasename("classpath:appErrors");
		return msgSource;
	}
	
	@Bean
	public TimerInterceptor timer()
	{
		return new TimerInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(timer()).addPathPatterns("/signin/**");
	}

}
