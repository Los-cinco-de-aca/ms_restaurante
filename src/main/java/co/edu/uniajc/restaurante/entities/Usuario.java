package co.edu.uniajc.restaurante.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "usuario")
@JsonInclude(value = Include.NON_NULL)
public class Usuario implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer usuarioId;
	private String nombre;
	private String email;
	private String password;
	
    public TipoUsuario fkTipoUsuario ;
    
    
	
	@ManyToOne
	@JoinColumn(name="tipo_usuario")
	public TipoUsuario getFkTipoUsuario() {
		return fkTipoUsuario;
	}

	public void setFkTipoUsuario(TipoUsuario fkTipoUsuario) {
		this.fkTipoUsuario = fkTipoUsuario;
	}

	
	public Usuario (){
		
	}

	public Usuario(Integer usuarioId, String nombre, String email, String password,
			TipoUsuario fkTipoUsuario) {
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fkTipoUsuario = fkTipoUsuario;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "usuario_id")
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Column(name= "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name= "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name= "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
