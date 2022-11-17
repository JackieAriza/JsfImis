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
@Table(name="proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id_proveedor;
	
	private long numero_documento;

	private String nombre_proveedor;

	private String apellido_proveedor; 

	private String email_proveedor;
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date fecha_creado_proveedor;

	
	@ManyToOne 
	@JoinColumn(name="fk_TipoDocumento")
	private Tipo_Documento tipo_documento;
	



	public long getId_proveedor() {
		return id_proveedor;
	}



	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}



	public long getNumero_documento() {
		return numero_documento;
	}



	public void setNumero_documento(long numero_documento) {
		this.numero_documento = numero_documento;
	}



	public String getNombre_proveedor() {
		return nombre_proveedor;
	}



	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}



	public String getApellido_proveedor() {
		return apellido_proveedor;
	}



	public void setApellido_proveedor(String apellido_proveedor) {
		this.apellido_proveedor = apellido_proveedor;
	}



	public String getEmail_proveedor() {
		return email_proveedor;
	}



	public void setEmail_proveedor(String email_proveedor) {
		this.email_proveedor = email_proveedor;
	}



	public Date getFecha_creado_proveedor() {
		return fecha_creado_proveedor;
	}



	public void setFecha_creado_proveedor(Date fecha_creado_proveedor) {
		this.fecha_creado_proveedor = fecha_creado_proveedor;
	}



	public Tipo_Documento getTipo_documento() {
		return tipo_documento;
	}



	public void setTipo_documento(Tipo_Documento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}



	@Override
	public String toString() {
		return nombre_proveedor ;
	}
	
	

	

	
}
