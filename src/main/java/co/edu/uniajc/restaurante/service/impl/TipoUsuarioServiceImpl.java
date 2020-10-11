package co.edu.uniajc.restaurante.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniajc.restaurante.entities.TipoUsuario;
import co.edu.uniajc.restaurante.repository.TipoUsuarioRepository;
import co.edu.uniajc.restaurante.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	Logger log= Logger.getLogger(TipoUsuarioServiceImpl.class.getName());
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public TipoUsuario createTipoUsuario(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	public void deleteTipoUsuario(TipoUsuario tipoUsuario) {
		tipoUsuarioRepository.delete(tipoUsuario);
	}
	
}
