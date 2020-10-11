package co.edu.uniajc.restaurante.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.repository.UserRepository;
import co.edu.uniajc.restaurante.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger log= Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Usuario> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Usuario createUser(Usuario usuario) {
		 return userRepository.save(usuario);
	}

	@Override
	public Usuario updateUser(Usuario usuario) {
		return userRepository.save(usuario);
	}

	@Override
	public void deleteUser(Usuario usuario) {
		userRepository.delete(usuario);
	}

}
