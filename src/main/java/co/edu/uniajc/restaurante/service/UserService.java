package co.edu.uniajc.restaurante.service;

import java.util.List;

import co.edu.uniajc.restaurante.entities.Usuario;

public interface UserService {

	List<Usuario> findAll();
	
	Usuario createUser(Usuario usuario);
	
	Usuario updateUser(Usuario usuario);
	
	void deleteUser(Usuario usuario);
	
}
