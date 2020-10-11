package co.edu.uniajc.restaurante.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "platos")
@JsonInclude(value = Include.NON_NULL)
public class Platos implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer platoId;
	private String nombre;
	private Integer precio;

	public Platos() {
	}

	public Platos(Integer platoId, String nombre, Integer precio) {
		this.platoId = platoId;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="plato_id")
	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="precio")
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}
