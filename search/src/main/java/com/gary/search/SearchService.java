package com.gary.search;

import java.net.URI;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class SearchService {
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;

	public SearchService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public Account findByName(String accountName) {
		
		return restTemplate.getForObject(serviceUrl+"/dosearch/{accountName}", Account.class, accountName);
		/*
		URI uri = UriComponentsBuilder.fromUriString("//account")
	            .build()
	            .toUri();
		return restTemplate.getForObject(uri, Account.class, accountName);
		*/
		/*Account acc = new Account();
		acc.setId(100);
		acc.setName("tara");
		acc.setBalance(2000.0);
		return acc;
		*/
	}

}
