package com.gaes3.imisG.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	private long numDocumento;
	private String nomUsuario;
	private String apeUsuario;
	private long telUsuario;
	private String emailUsuario;
	private String passUsuario;
	private String estadoUsuario;
	
	@ManyToOne 
	@JoinColumn(name="fk_TipoDocumento")
	private Tipo_Documento tipo_documento;
	
	@ManyToOne 
	@JoinColumn(name="fk_idRol")
	private Rol rol;

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public long getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(long numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getApeUsuario() {
		return apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public long getTelUsuario() {
		return telUsuario;
	}

	public void setTelUsuario(long telUsuario) {
		this.telUsuario = telUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public Tipo_Documento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(Tipo_Documento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return nomUsuario +" " + apeUsuario;
	}

	public Usuario(long id_usuario, long numDocumento, String nomUsuario, String apeUsuario, long telUsuario,
			String emailUsuario, String passUsuario, String estadoUsuario, Tipo_Documento tipo_documento, Rol rol) {
		super();
		this.id_usuario = id_usuario;
		this.numDocumento = numDocumento;
		this.nomUsuario = nomUsuario;
		this.apeUsuario = apeUsuario;
		this.telUsuario = telUsuario;
		this.emailUsuario = emailUsuario;
		this.passUsuario = passUsuario;
		this.estadoUsuario = estadoUsuario;
		this.tipo_documento = tipo_documento;
		this.rol = rol;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

}
