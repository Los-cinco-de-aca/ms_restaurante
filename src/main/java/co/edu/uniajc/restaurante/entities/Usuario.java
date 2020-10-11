package co.edu.uniajc.restaurante.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "usuario")
@JsonInclude(value = Include.NON_NULL)
public class Usuario implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer usuarioId;
	private String alias;
	private String email;
	private String password;
	
	public Usuario (){
		
	}

	public Usuario(Integer usuarioId, String alias, String email, String password) {
		super();
		this.usuarioId = usuarioId;
		this.alias = alias;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="usuario_id")
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Column(name="alias")
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", alias=" + alias + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
}
