package co.edu.uniajc.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.restaurante.entities.Platos;

@Repository
public interface PlatosRepository extends JpaRepository<Platos, Integer> {

}
