package co.edu.uniajc.restaurante.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.repository.UserRepository;
import co.edu.uniajc.restaurante.service.AuthService;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import org.springframework.security.core.authority.AuthorityUtils;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepository usuario_Repository;
	
	public String login(String correo, String password) {
		Optional<Usuario> customer = usuario_Repository.login(correo,password);
        if(customer.isPresent()){
            String token = UUID.randomUUID().toString();
            return token;
        }

        return StringUtils.EMPTY;
    }
	

}
