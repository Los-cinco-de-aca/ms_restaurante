package co.edu.uniajc.restaurante;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import co.edu.uniajc.restaurante.entities.Platos;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 class PlatosControllerTest {
	
	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";
	
	@Test
	 void testGetPlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/platosws/list";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testPostPlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/platosws/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		Platos platos = new Platos();
		int platoId = 35;
        platos.setPlatoId(platoId);
        platos.setNombre("Carnitas BBQ");
        platos.setPrecio(12300);
		HttpEntity<Platos> request = new HttpEntity<>(platos,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.POST,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	 void testPutPlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/platosws/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		Platos platos = new Platos();
		int platoId = 35;
        platos.setPlatoId(platoId);
        platos.setNombre("Carnitas BBQ*");
        platos.setPrecio(12300);
		HttpEntity<Platos> request = new HttpEntity<>(platos,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testDeletePlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/platosws/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		Platos platos = new Platos();
		int platoId = 35;
        platos.setPlatoId(platoId);
        platos.setNombre("Carnitas BBQ*");
        platos.setPrecio(12300);
		HttpEntity<Platos> request = new HttpEntity<>(platos,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}

}
