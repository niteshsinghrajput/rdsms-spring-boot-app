package com.rdsms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.rdsms")
@EntityScan("com.rdsms")
@SpringBootApplication
public class RdsmsSpringBootAppApplication {
	

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
        	
        	@Override
        	public void addCorsMappings(CorsRegistry registry) {
        		registry.addMapping("/**")
        		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
        		/*registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                .allowCredentials(true);*/
        	}
            
        /*	@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
                registry.addMapping("/users").allowedOrigins("http://localhost:8080");
                registry.addMapping("/branches").allowedOrigins("http://localhost:8080");
                registry.addMapping("/candidates").allowedOrigins("http://localhost:8080");
            }*/
        };
    }
	
	public static void main(String[] args) {
		SpringApplication.run(RdsmsSpringBootAppApplication.class, args);
	}
}
