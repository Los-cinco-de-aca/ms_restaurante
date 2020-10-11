package co.edu.uniajc.restaurante.service;

import java.util.List;

import co.edu.uniajc.restaurante.entities.Platos;

public interface PlatosService {

	List<Platos> findAll();
	
	Platos createPlatos(Platos platos);
	
	Platos updatePlatos(Platos platos);
	
	void deletePlatos(Platos platos);
	
}
