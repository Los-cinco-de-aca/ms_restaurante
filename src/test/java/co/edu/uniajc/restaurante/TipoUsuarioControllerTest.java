package co.edu.uniajc.restaurante;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
 class TipoUsuarioControllerTest {
	
	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";
	
	@Test
	 void testGetTipoUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/tipousuariows/list";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	 void testPostTipoUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/tipousuariows/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		Usuario usuario = new Usuario();
		List<Usuario> listUsuarios = new ArrayList<>();
		usuario.setNombre("Palomino");
		usuario.setEmail("@");
		usuario.setPassword("234");
		usuario.setUsuarioId(123);
		listUsuarios.add(usuario);
		int tipoUsuarioId = 4;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Kings");
		listUsuarios.add(usuario);
		HttpEntity<TipoUsuario> request = new HttpEntity<>(tipoUsuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.POST,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	 void testPutTipoUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/tipousuariows/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		Usuario usuario = new Usuario();
		List<Usuario> listUsuarios = new ArrayList<>();
		usuario.setNombre("Palomino");
		usuario.setEmail("@");
		usuario.setPassword("234");
		usuario.setUsuarioId(123);
		listUsuarios.add(usuario);
		int tipoUsuarioId = 4;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Kings*");
		tipoUsuario.setListUsuarios(listUsuarios);
		HttpEntity<TipoUsuario> request = new HttpEntity<>(tipoUsuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	
	@Test
	 void testDeleteTipoUsuario() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/tipousuariows/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"7f2658b5-51f2-4b34-b4b8-a256d35d570f");
		TipoUsuario tipoUsuario = new TipoUsuario();
		int tipoUsuarioId = 4;
		tipoUsuario.setTipoUsuarioId(tipoUsuarioId);
		tipoUsuario.setDescripcion("Kings*");
		HttpEntity<TipoUsuario> request = new HttpEntity<>(tipoUsuario,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}

}
