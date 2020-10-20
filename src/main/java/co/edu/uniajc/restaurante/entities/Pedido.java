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
	@Table(name = "pedido")
	@JsonInclude(value = Include.NON_NULL)
	public class Pedido implements Serializable {

		private static final long serialVersionUID = 1L;
		
		
		private Integer pedidoId;
		private Integer clienteId;
		private Integer meseroId;
		private Integer platoId;
		private Integer cantidad;
		private Integer total;
		private Date    fecha;
		
		
		public  Pedido() {
			//Do nothing
		}
		
		public  Pedido(Pedido pedido) {
			this.pedidoId = pedido.pedidoId;
			this.clienteId = pedido.clienteId;
			this.meseroId = pedido.meseroId;
			this.platoId = pedido.platoId;
			this.cantidad = pedido.cantidad;
			this.total = pedido.total;
			this.fecha = pedido.fecha;
		}


		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@Column(name="pedido_id")
		public Integer getPedidoId() {
			return pedidoId;
		}


		public void setPedidoId(Integer pedidoId) {
			this.pedidoId = pedidoId;
		}


		@Column(name="cliente_id")
		public Integer getClienteId() {
			return clienteId;
		}


		public void setClienteId(Integer clienteId) {
			this.clienteId = clienteId;
		}

		@Column(name="mesero_id")
		public Integer getMeseroId() {
			return meseroId;
		}


		public void setMeseroId(Integer meseroId) {
			this.meseroId = meseroId;
		}

		@Column(name="plato_id")
		public Integer getPlatoId() {
			return platoId;
		}


		public void setPlatoId(Integer platoId) {
			this.platoId = platoId;
		}

		@Column(name="cantidad")
		public Integer getCantidad() {
			return cantidad;
		}


		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		@Column(name="total")
		public Integer getTotal() {
			return total;
		}


		public void setTotal(Integer total) {
			this.total = total;
		}

		@Column(name="fecha")
		public Date getFecha() {
			return fecha;
		}


		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
		
		

}
