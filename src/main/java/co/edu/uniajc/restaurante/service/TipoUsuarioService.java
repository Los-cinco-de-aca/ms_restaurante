package co.edu.uniajc.restaurante.service;

import java.util.List;

import co.edu.uniajc.restaurante.entities.TipoUsuario;
import co.edu.uniajc.restaurante.entities.Usuario;

public interface TipoUsuarioService {

	List<TipoUsuario> findAll();
	
	TipoUsuario createTipoUsuario(TipoUsuario tipoUsuario);
	
	TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario);
	
	void deleteTipoUsuario(TipoUsuario tipoUsuario);
	
}
