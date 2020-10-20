package co.edu.uniajc.restaurante;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import co.edu.uniajc.restaurante.service.AuthService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 class PlatosControllerTest {
	
	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";
	
	@Autowired
	 AuthService authServ;
	
	@Test
	 void testGetPlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/platosws/list";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testPostPlatos() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/platosws/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
		Platos platos = new Platos();
		int platoId = 7;
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
		final String baseUrl = url + randomServerPort + "/restaurante/platosws/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
		Platos platos = new Platos();
		int platoId = 7;
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
		final String baseUrl = url + randomServerPort + "/restaurante/platosws/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
		Platos platos = new Platos();
		int platoId = 7;
        platos.setPlatoId(platoId);
        platos.setNombre("Carnitas BBQ*");
        platos.setPrecio(12300);
		HttpEntity<Platos> request = new HttpEntity<>(platos,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}

}
