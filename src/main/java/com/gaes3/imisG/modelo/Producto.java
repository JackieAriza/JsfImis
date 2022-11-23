package com.gaes3.imisG.modelo;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProductos;

	private String nombreProducto;

	private double valorProducto;

	private String estadoProducto;

	private long stock;

	// @OneToMany(mappedBy="producto",fetch=FetchType.LAZY)
	// private List<Detalle_Por_Factura> detalle_por_factura;

	@ManyToOne
	@JoinColumn(name = "fk_categoriaProductos")
	private Categoriaproducto categoriaproducto;

	public long getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(long idProductos) {
		this.idProductos = idProductos;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(double valorProducto) {
		this.valorProducto = valorProducto;
	}

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Categoriaproducto getCategoriaproducto() {
		return categoriaproducto;
	}

	@Override
	public String toString() {
		return "Producto [idProductos=" + idProductos + ", nombreProducto=" + nombreProducto + ", valorProducto="
				+ valorProducto + ", estadoProducto=" + estadoProducto + ", stock=" + stock + ", categoriaproducto="
				+ categoriaproducto + "]";
	}

	public void setCategoriaproducto(Categoriaproducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}
}
