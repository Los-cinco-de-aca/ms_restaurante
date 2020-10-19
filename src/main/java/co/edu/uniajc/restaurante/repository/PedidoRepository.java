package co.edu.uniajc.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.restaurante.entities.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer> {

}
