package com.gaes3.imisG.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idRol;
	private String NombreRol;
	
	//@OneToMany(mappedBy="rol",fetch=FetchType.LAZY)
	//private List<Usuario> usuario;
	
	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return NombreRol;
	}
	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}
	@Override
	public String toString() {
		return  NombreRol;
	}

}
