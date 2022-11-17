package com.gaes3.imisG.modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="factura")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFactura;
	@Column
	private double totalfactura;
	@Column
	private Date Fecha_registro;
	
	//@OneToMany(mappedBy="factura",fetch=FetchType.LAZY)
	//private List<Detalle_Por_Factura> detalle_por_factura;

	@ManyToOne
	@JoinColumn(name="fk_idCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="fk_id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="fk_idPago")
	private FormaPago formaPago;

	public long getIdFactura() {
		return idFactura;
	}

	public double getTotalfactura() {
		return totalfactura;
	}

	public Date getFecha_registro() {
		return Fecha_registro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public void setTotalfactura(double totalfactura) {
		this.totalfactura = totalfactura;
	}

	public void setFecha_registro(Date fecha_registro) {
		Fecha_registro = fecha_registro;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return idFactura +":"+ cliente;
	}


	
	

	
	
}
