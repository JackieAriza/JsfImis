package com.gaes3.imisG.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class Tipo_Documento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Tipo_Documento;
	private String Nombre_doc;
	
	//@OneToMany(mappedBy="tipo_documento",fetch=FetchType.LAZY)
	//private List<Proveedor> proveedor;
	
	//@OneToMany(mappedBy="tipo_documento",fetch=FetchType.LAZY)
	//private List<Cliente> cliente;
	
	//@OneToMany(mappedBy="tipo_documento",fetch=FetchType.LAZY)
	//private List<Usuario> usuario;
	
	public long getId_Tipo_Documento() {
		return id_Tipo_Documento;
	}
	public void setId_Tipo_Documento(long id_Tipo_Documento) {
		this.id_Tipo_Documento = id_Tipo_Documento;
	}
	public String getNombre_doc() {
		return Nombre_doc;
	}
	public void setNombre_doc(String nombre_doc) {
		Nombre_doc = nombre_doc;
	}
	@Override
	public String toString() {
		return Nombre_doc;
	}

	

}

