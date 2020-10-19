package co.edu.uniajc.restaurante.service;

import java.util.List;

import co.edu.uniajc.restaurante.entities.Pedido;

public interface PedidoService {
	
	List<Pedido> findAll();
	
	Pedido createPedido(Pedido pedido);
	
	Pedido updatePedido(Pedido pedido);
	
	void deletePedido(Pedido pedido);

}
