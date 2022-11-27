package com.gaes3.imisG.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdCliente;
	@Column(nullable = false)
	private long NumDoc;
	@Column(nullable = false)
	private String NombreCliente;
	@Column(nullable = false)
	private String ApellidoCliente;
	@Column(nullable = false)
	private long TeleCliente;
	@Column(nullable = false, unique = true)
	private String EmailCliente;
	
	//@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY)
	//private List<Factura> factura;
	
	//@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY)
	//private List<Servicio> servicio;
	

	
	@ManyToOne 
	@JoinColumn(name="fk_TipoDocumento")
	private Tipo_Documento tipo_documento;
	
	
	
	public long getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(long idCliente) {
		IdCliente = idCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return ApellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		ApellidoCliente = apellidoCliente;
	}
	
	public long getNumDoc() {
		return NumDoc;
	}
	public void setNumDoc(long numDoc) {
		NumDoc = numDoc;
	}
	public long getTeleCliente() {
		return TeleCliente;
	}
	public void setTeleCliente(long teleCliente) {
		TeleCliente = teleCliente;
	}
	public String getEmailCliente() {
		return EmailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		EmailCliente = emailCliente;
	}
	public Tipo_Documento getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(Tipo_Documento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	@Override
	public String toString() {
		return  NombreCliente +  ApellidoCliente;
	}
	
	
	
	



	
	
	
	
}
