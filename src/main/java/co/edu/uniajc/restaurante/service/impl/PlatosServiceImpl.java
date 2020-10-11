package co.edu.uniajc.restaurante.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniajc.restaurante.entities.Platos;
import co.edu.uniajc.restaurante.repository.PlatosRepository;
import co.edu.uniajc.restaurante.service.PlatosService;

@Service
public class PlatosServiceImpl implements PlatosService {

	Logger log= Logger.getLogger(PlatosServiceImpl.class.getName());
	
	@Autowired
	PlatosRepository platosRepository;

	@Override
	public List<Platos> findAll() {
		// TODO Auto-generated method stub
		return platosRepository.findAll();
	}

	@Override
	public Platos createPlatos(Platos platos) {
		// TODO Auto-generated method stub
		return platosRepository.save(platos);
	}

	@Override
	public Platos updatePlatos(Platos platos) {
		// TODO Auto-generated method stub
		return platosRepository.save(platos);
	}

	@Override
	public void deletePlatos(Platos platos) {
		// TODO Auto-generated method stub
		platosRepository.delete(platos);
	}
	

}
