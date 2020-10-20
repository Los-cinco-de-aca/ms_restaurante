package co.edu.uniajc.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.restaurante.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "SELECT * FROM usuario WHERE email = ?1 and password = ?2 ", nativeQuery = true)
	Optional<Usuario> login(String email,String password);


}
