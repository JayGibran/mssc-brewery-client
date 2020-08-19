package guru.springframework.msscbreweryclient.web.client;


import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreInvalidFields = false)
public class BreweryClient {
	
	public final String BEER_PATH_V1 = "/api/v1/beer/";
	
	public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	
	private String apiHost;
	
	private final RestTemplate restTemplate;
	
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	public BeerDTO getBeerById(UUID id){
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + id, BeerDTO.class);
	}
	
	public URI saveNewBeer(BeerDTO beerDTO) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO); 
	}
	
	public void updateBeer(BeerDTO beerDTO) {
		restTemplate.put(apiHost + BEER_PATH_V1 + UUID.randomUUID() , beerDTO);
	}
	
	public void deleteBeer(UUID id) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + id);
	}

	public CustomerDTO getCustomerById(UUID id) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + id, CustomerDTO.class);
	}

	public URI saveNewCustomer(CustomerDTO customerDTO) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDTO); 
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + UUID.randomUUID() , customerDTO);
	}

	public void deleteCustomer(UUID id) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + id);
	}
	



}
