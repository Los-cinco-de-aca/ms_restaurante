package co.edu.uniajc.restaurante;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import co.edu.uniajc.restaurante.entities.Pedido;
import co.edu.uniajc.restaurante.service.AuthService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PedidoControllerTest {

	@LocalServerPort
	int randomServerPort;

	String url = "http://localhost:";

	@Autowired
	AuthService authServ;
	

	@Test
	void testGetPedido() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/restaurante/pedidosws/list";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token = authServ.login("linda@gmail.com", "987");
		headers.add("Authorization", "Bearer " + token);
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testPostPedido() throws URISyntaxException, java.text.ParseException {
		RestTemplate restTemplate = new RestTemplate();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "26/10/2020";
		Date fecha = new Date();

		try {
			Date date = formatter.parse(dateInString);
			fecha = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		final String baseUrl = url + randomServerPort + "/restaurante/pedidosws/create";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token = authServ.login("linda@gmail.com", "987");
		headers.add("Authorization", "Bearer " + token);
		Pedido pedido = new Pedido();
		pedido.setPedidoId(7);
		pedido.setClienteId(1);
		pedido.setFecha(fecha);
		pedido.setMeseroId(2);
		pedido.setPlatoId(2);
		pedido.setTotal(89000);
		HttpEntity<Pedido> request = new HttpEntity<>(pedido, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testPutPedido() throws URISyntaxException, java.text.ParseException {
		RestTemplate restTemplate = new RestTemplate();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "26/10/2020";
		Date fecha = new Date();

		try {
			Date date = formatter.parse(dateInString);
			fecha = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		final String baseUrl = url + randomServerPort + "/restaurante/pedidosws/update";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token = authServ.login("linda@gmail.com", "987");
		headers.add("Authorization", "Bearer " + token);
		Pedido pedido = new Pedido();
		pedido.setPedidoId(7);
		pedido.setClienteId(1);
		pedido.setFecha(fecha);
		pedido.setMeseroId(2);
		pedido.setPlatoId(2);
		pedido.setTotal(89001);
		HttpEntity<Pedido> request = new HttpEntity<>(pedido, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	void testDeletePedido() throws URISyntaxException, java.text.ParseException {
		RestTemplate restTemplate = new RestTemplate();
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "26/10/2020";
		Date fecha = new Date();

		try {
			Date date = formatter.parse(dateInString);
			fecha = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		final String baseUrl = url + randomServerPort + "/restaurante/pedidosws/delete";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String token = authServ.login("linda@gmail.com", "987");
		headers.add("Authorization", "Bearer " + token);
		Pedido pedido = new Pedido();
		pedido.setPedidoId(7);
		pedido.setClienteId(1);
		pedido.setFecha(fecha);
		pedido.setMeseroId(2);
		pedido.setPlatoId(2);
		pedido.setTotal(89001);
		HttpEntity<Pedido> request = new HttpEntity<>(pedido, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

}
