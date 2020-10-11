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

import co.edu.uniajc.restaurante.entities.TipoUsuario;
import co.edu.uniajc.restaurante.entities.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 class UserControllerTest {
	
	
	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";
	
	@Test
	 void testGetUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/usuariows/list";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testPostUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/usuariows/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		Usuario usuario = new Usuario();
		usuario.setNombre("Jonathan Palomino");
		usuario.setEmail("jonatan@hotmail.com");
		usuario.setPassword("789435");
		usuario.setUsuarioId(8888);
		int tipoUsuarioId = 3;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Cliente");	
		usuario.setFkTipoUsuario(tipoUsuario);
		HttpEntity<Usuario> request = new HttpEntity<>(usuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.POST,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	 void testPutUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/usuariows/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		Usuario usuario = new Usuario();
		usuario.setNombre("Jonathan Palomino Villada");
		usuario.setEmail("jonatan@hotmail.com");
		usuario.setPassword("789435");
		usuario.setUsuarioId(8888);
		int tipoUsuarioId = 3;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Cliente");	
		usuario.setFkTipoUsuario(tipoUsuario);
		HttpEntity<Usuario> request = new HttpEntity<>(usuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testDeleteTipoUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/usuariows/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		Usuario usuario = new Usuario();
		usuario.setNombre("Jonathan Palomino Villada");
		usuario.setEmail("jonatan@hotmail.com");
		usuario.setPassword("789435");
		usuario.setUsuarioId(8888);
		int tipoUsuarioId = 3;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Cliente");	
		usuario.setFkTipoUsuario(tipoUsuario);
		HttpEntity<Usuario> request = new HttpEntity<>(usuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}


}
