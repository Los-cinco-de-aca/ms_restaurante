package co.edu.uniajc.restaurante.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.restaurante.entities.Pedido;
import co.edu.uniajc.restaurante.service.PedidoService;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "pedidosws")
public class PedidoController {
	
	Logger log = Logger.getLogger(PedidoController.class.getName());

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping(value = "list")
	public ResponseEntity<List<Pedido>> getPedido() {
		log.info("LIST");
		List<Pedido> pedido = pedidoService.findAll();
		return new ResponseEntity<>(pedido, HttpStatus.OK);
	}

	@PostMapping(value = "create")
	public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
		log.info("CREATE");
		Pedido pedidoReturn = pedidoService.createPedido(pedido);
		if (pedidoReturn != null) {
			return new ResponseEntity<>(pedidoReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedidoReturn, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
		log.info("UPDATE");
		Pedido pedidoReturn = pedidoService.updatePedido(pedido);
		if (pedidoReturn != null) {
			return new ResponseEntity<>(pedidoReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedidoReturn, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "delete")
	public HttpStatus deletePlatos(@RequestBody Pedido pedido) {
		log.info("DELETE");
		pedidoService.deletePedido(pedido);
		return HttpStatus.OK;
	}


}
