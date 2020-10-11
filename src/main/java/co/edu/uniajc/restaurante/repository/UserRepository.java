package co.edu.uniajc.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.restaurante.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

}
