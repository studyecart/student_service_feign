package com.studyecart.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.studyecart.controller", "com.studyecart.service"})
@EntityScan("com.studyecart.entity")
@EnableJpaRepositories("com.studyecart.repository")
@EnableFeignClients("com.studyecart.feignclients")
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
 /*   @Bean
	public WebClient webClient(){
		WebClient webClient;
		webClient= WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;

}*/
}
