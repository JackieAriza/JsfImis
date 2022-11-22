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

	private Double precio;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_orden_compra; 
	
	@ManyToOne 
	@JoinColumn(name="fk_id_proveedor")
	private Proveedor proveedor;
	
	
	public long getId_orden_compra() {
		return id_orden_compra;
	}
	public void setId_orden_compra(long id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}

	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
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

	@Override
	public String toString() {
		return "Orden_de_compra [id_orden_compra=" + id_orden_compra + ", precio=" + precio
				+ ", fecha_orden_compra=" + fecha_orden_compra + ", proveedor=" + proveedor + "]";
	}
	public Orden_de_compra(long id_orden_compra, Double precio, Date fecha_orden_compra, Proveedor proveedor) {
		super();
		this.id_orden_compra = id_orden_compra;
		this.precio = precio;
		this.fecha_orden_compra = fecha_orden_compra;
		this.proveedor = proveedor;

	}
	public Orden_de_compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}