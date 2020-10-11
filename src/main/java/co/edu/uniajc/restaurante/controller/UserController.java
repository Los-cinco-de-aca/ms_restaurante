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

import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "usuariows")
public class UserController {

	Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	UserService userService;

	@GetMapping(value = "list")
	public ResponseEntity<List<Usuario>> getUsers() {
		log.info("LIST");
		List<Usuario> usuarios = userService.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	@PostMapping(value = "create")
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
		log.info("CREATE");
		Usuario userReturn = userService.createUser(usuario);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
		log.info("UPDATE");
		Usuario userReturn = userService.updateUser(usuario);
		if (userReturn != null) {
			return new ResponseEntity<>(userReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userReturn, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "delete")
	public HttpStatus deleteUser(@RequestBody Usuario usuario) {
		log.info("DELETE");
		userService.deleteUser(usuario);
		return HttpStatus.OK;
	}

}
