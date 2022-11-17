package com.gaes3.imisG.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formaPago")
public class FormaPago {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPago  ;
	private String TipoPago ;
	public long getIdPago() {
		return idPago;
	}
	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}
	public String getTipoPago() {
		return TipoPago;
	}
	public void setTipoPago(String tipoPago) {
		TipoPago = tipoPago;
	}
	@Override
	public String toString() {
		return TipoPago;
	}
	public FormaPago(long idPago, String tipoPago) {
		super();
		this.idPago = idPago;
		TipoPago = tipoPago;
	}
	public FormaPago() {
		super();
		
	}
	
	
	
}
