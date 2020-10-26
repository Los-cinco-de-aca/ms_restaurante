package co.edu.uniajc.restaurante.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniajc.restaurante.entities.Pedido;
import co.edu.uniajc.restaurante.repository.PedidoRepository;
import co.edu.uniajc.restaurante.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	Logger log= Logger.getLogger(PedidoServiceImpl.class.getName());
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido createPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public void deletePedido(Pedido pedido) {
		pedidoRepository.delete(pedido);
		
	}
	


}
