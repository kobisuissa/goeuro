package com.goeuro.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.goeuro.model.Position;

public class PositionRestTemplate {
	
	private String endpoint;
	
	@Autowired
	private RestTemplate restTemplate;

	public PositionRestTemplate(String endpoint) {
		super();
		this.endpoint = endpoint;
	}
	
	public List<Position> getPositionsByString(String queryString) throws RestClientException {
		Position[] positions = restTemplate.getForObject(endpoint.concat(queryString), Position[].class);
		return Arrays.asList(positions);
	}


}
