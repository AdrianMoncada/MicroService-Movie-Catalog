package com.example.apiserie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
/*TO DO: Corroborate annotations*/
@EnableDiscoveryClient
@EnableMongoRepositories
public class ApiSerieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSerieApplication.class, args);
	}

}
