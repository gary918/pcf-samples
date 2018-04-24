package com.gary.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient

public class SearchApplication {

	// URL for account service
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNT";

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public SearchService searchService() {
		return new SearchService(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public SearchController searchController() {
		return new SearchController(searchService());
	}
}
