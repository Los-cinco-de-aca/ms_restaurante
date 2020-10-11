package co.edu.uniajc.restaurante.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.restaurante.entities.TipoUsuario;
import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.service.TipoUsuarioService;
import co.edu.uniajc.restaurante.service.UserService;

//@CrossOrigin(origins="http://localhost:3000")
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "tipousuariows")
public class TipoUsuarioController {

	Logger log = Logger.getLogger(TipoUsuarioController.class.getName());

	@Autowired
	TipoUsuarioService tipoUsuarioService;

	@GetMapping(value = "list")
	public ResponseEntity<List<TipoUsuario>> getTipoUsuarios() {
		log.info("LIST");
		List<TipoUsuario> tipoUsuario = tipoUsuarioService.findAll();
		return new ResponseEntity<>(tipoUsuario, HttpStatus.OK);
	}

	@PostMapping(value = "create")
	public ResponseEntity<TipoUsuario> createTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		log.info("CREATE");
		TipoUsuario userReturn = tipoUsuarioService.createTipoUsuario(tipoUsuario);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<TipoUsuario> updateTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		log.info("UPDATE");
		TipoUsuario userReturn = tipoUsuarioService.updateTipoUsuario(tipoUsuario);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "delete")
	public HttpStatus deleteTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		log.info("DELETE");
		tipoUsuarioService.deleteTipoUsuario(tipoUsuario);
		return HttpStatus.OK;
	}

}
