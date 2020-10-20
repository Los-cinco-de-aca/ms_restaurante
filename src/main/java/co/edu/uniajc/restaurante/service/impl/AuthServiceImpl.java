package co.edu.uniajc.restaurante.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.restaurante.entities.Usuario;
import co.edu.uniajc.restaurante.repository.UserRepository;
import co.edu.uniajc.restaurante.service.AuthService;
import co.edu.uniajc.restaurante.utilidades.ConstanteComun;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository usuarioRepository;

	public String login(String correo, String password) {

		Optional<Usuario> customer = usuarioRepository.login(correo, password);
		if (customer.isPresent()) {

			String secretKey = ConstanteComun.KEY_SECURITY;
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

			String token = Jwts.builder().setId("softtekJWT").setSubject(correo)
					.claim("authorities",
							grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 1800000))
					.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

			return "Bearer " + token;
		}
		return StringUtils.EMPTY;
	}
}
