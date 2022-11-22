package com.gaes3.imisG.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleordencompra")
public class Detalleordencompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long iddetalleorden;
	
	private long cantidad;
	
	private Double preciounitario;
	
	private Double preciototal;


	@ManyToOne 
	@JoinColumn(name="fk_IdProductos")
	private Producto producto;
	
	@ManyToOne 
	@JoinColumn(name="fk_idorden")
	private Orden_de_compra ordendecompra;

	public long getIddetalleorden() {
		return iddetalleorden;
	}

	public void setIddetalleorden(long iddetalleorden) {
		this.iddetalleorden = iddetalleorden;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public Double getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(Double preciototal) {
		this.preciototal = preciototal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Orden_de_compra getOrdendecompra() {
		return ordendecompra;
	}

	public void setOrdendecompra(Orden_de_compra ordendecompra) {
		this.ordendecompra = ordendecompra;
	}

	@Override
	public String toString() {
		return "Detalleordencompra [iddetalleorden=" + iddetalleorden + ", cantidad=" + cantidad + ", preciounitario="
				+ preciounitario + ", preciototal=" + preciototal + ", producto=" + producto + ", ordendecompra="
				+ ordendecompra + "]";
	}

	public Detalleordencompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	


		

}
