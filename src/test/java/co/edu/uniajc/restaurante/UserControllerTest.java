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

import co.edu.uniajc.restaurante.entities.TipoUsuario;
import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.service.AuthService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 class UserControllerTest {
	
	
	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";
	
	@Autowired
	 AuthService authServ;
	
	@Test
	 void testGetUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/usuariows/list";
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
	 void testPostUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/usuariows/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
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
		final String baseUrl = url + randomServerPort + "/restaurante/usuariows/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
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
		final String baseUrl = url + randomServerPort + "/restaurante/usuariows/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token= authServ.login("linda@gmail.com","987");
		headers.add("Authorization","Bearer " + token);
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
