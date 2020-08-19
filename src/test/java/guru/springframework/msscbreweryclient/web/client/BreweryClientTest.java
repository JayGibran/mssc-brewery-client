package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDTO;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	void testGetBeerById() {
		BeerDTO beerDTO = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(beerDTO);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDTO beerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerName("Guiness").build();	
		
		URI uri = client.saveNewBeer(beerDTO);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer () {
		BeerDTO beerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerName("Guiness").build();
		
		client.updateBeer(beerDTO);
				
	}
	
	@Test
	void testDeleteBeer () {
		client.deleteBeer(UUID.randomUUID());
	}
	
	@Test
	void testGetCustomerById() {
		CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDTO);
	}
	
	@Test
	void testSaveNewCustomer() {
		CustomerDTO customerDTO = CustomerDTO.builder().id(UUID.randomUUID()).name("Jay").build();	
		
		URI uri = client.saveNewCustomer(customerDTO);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateCustomer () {
		CustomerDTO customerDTO = CustomerDTO.builder().id(UUID.randomUUID()).name("Jay").build();
		
		client.updateCustomer(customerDTO);
				
	}
	
	@Test
	void testDeleteCustomer () {
		client.deleteCustomer(UUID.randomUUID());
	}
	

}
