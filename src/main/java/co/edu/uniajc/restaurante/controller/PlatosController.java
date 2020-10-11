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

import co.edu.uniajc.restaurante.entities.Platos;
import co.edu.uniajc.restaurante.service.PlatosService;

//@CrossOrigin(origins="http://localhost:3000")
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "platosws")
public class PlatosController {

	Logger log = Logger.getLogger(PlatosController.class.getName());

	@Autowired
	PlatosService platosService;

	@GetMapping(value = "list")
	public ResponseEntity<List<Platos>> getPlatos() {
		log.info("LIST");
		List<Platos> platos = platosService.findAll();
		return new ResponseEntity<>(platos, HttpStatus.OK);
	}

	@PostMapping(value = "create")
	public ResponseEntity<Platos> createPlatos(@RequestBody Platos platos) {
		log.info("CREATE");
		Platos userReturn = platosService.createPlatos(platos);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<Platos> updatePlatos(@RequestBody Platos platos) {
		log.info("UPDATE");
		Platos userReturn = platosService.updatePlatos(platos);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "delete")
	public HttpStatus deletePlatos(@RequestBody Platos platos) {
		log.info("DELETE");
		platosService.deletePlatos(platos);
		return HttpStatus.OK;
	}

}
