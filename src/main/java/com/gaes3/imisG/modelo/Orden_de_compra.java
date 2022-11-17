package com.gaes3.imisG.modelo;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orden_de_compra")
public class Orden_de_compra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_orden_compra;

	private long cantidad ;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_orden_compra; 
	
	@ManyToOne 
	@JoinColumn(name="fk_id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne 
	@JoinColumn(name="fk_idProductos")
	private Producto producto;
	
	public long getId_orden_compra() {
		return id_orden_compra;
	}
	public void setId_orden_compra(long id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_orden_compra() {
		return fecha_orden_compra;
	}
	public void setFecha_orden_compra(Date fecha_orden_compra) {
		this.fecha_orden_compra = fecha_orden_compra;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Orden_de_compra [id_orden_compra=" + id_orden_compra + ", cantidad=" + cantidad
				+ ", fecha_orden_compra=" + fecha_orden_compra + ", proveedor=" + proveedor + ", producto=" + producto
				+ "]";
	}
	public Orden_de_compra(long id_orden_compra, long cantidad, Date fecha_orden_compra, Proveedor proveedor,
			Producto producto) {
		super();
		this.id_orden_compra = id_orden_compra;
		this.cantidad = cantidad;
		this.fecha_orden_compra = fecha_orden_compra;
		this.proveedor = proveedor;
		this.producto = producto;
	}
	public Orden_de_compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}