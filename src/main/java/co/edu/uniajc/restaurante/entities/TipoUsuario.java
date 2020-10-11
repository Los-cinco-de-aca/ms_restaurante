package co.edu.uniajc.restaurante.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tipo_usuario")
@JsonInclude(value = Include.NON_NULL)
public class TipoUsuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer tipoUsuarioId;
	private String descripcion;
	
	
	private List<Usuario> listUsuarios;
	
	public TipoUsuario() {
	
	}
	
	@OneToMany(targetEntity=Usuario.class, mappedBy="fkTipoUsuario")
	@JsonIgnore
	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public TipoUsuario(Integer tipoUsuarioId, String descripcion) {
		this.tipoUsuarioId = tipoUsuarioId;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="tipo_usuario_id")
	public Integer getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(Integer tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
