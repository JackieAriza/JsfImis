package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


import com.gaes3.imisG.facadeImp.FacturaDAO;
import com.gaes3.imisG.facadeImp.RolDAO;
import com.gaes3.imisG.facadeImp.Tipo_DocumentoDAO;
import com.gaes3.imisG.facadeImp.UsuarioDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Factura;
import com.gaes3.imisG.modelo.Rol;
import com.gaes3.imisG.modelo.Tipo_Documento;
import com.gaes3.imisG.modelo.Usuario;



@ManagedBean (name="usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;
	private static final long serialVersionUID = 1L;
	
	private List<Tipo_Documento> obtenerDocumentos;
	private Tipo_Documento tipo_documento;

	private List<Rol> obtenerRoles;
	private Rol rol;
	
	private List<Usuario> usuariou;

	
	public Usuario getUsuario() {
		return usuario;
	}

	public List<Tipo_Documento> getObtenerDocumentos() {
		Tipo_DocumentoDAO t = new Tipo_DocumentoDAO();
		obtenerDocumentos = t.obtenerDocumentos();
		return obtenerDocumentos;
	}

	public Tipo_Documento getTipo_Documento() {
		return tipo_documento;
	}

	public List<Rol> getObtenerRoles(){
		RolDAO r = new RolDAO();
		obtenerRoles = r.obtenerRoles();
		return obtenerRoles;
	}

	public Rol getRol() {
		return rol;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setObtenerDocumentos(List<Tipo_Documento> obtenerDocumentos) {
		this.obtenerDocumentos = obtenerDocumentos;
	}

	public void setTipo_Documento(Tipo_Documento tipo_Documento) {
		this.tipo_documento = tipo_Documento;
	}

	public void setObtenerRoles(List<Rol> obtenerRoles) {
		this.obtenerRoles = obtenerRoles;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		tipo_documento = new Tipo_Documento();
		rol = new Rol();
	}

	public String nuevo() {
		return  "/Usuarios/nuevoUsuario.xhtml?faces-redirect=true";
	}
	
	public String guardar () {
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		usuario.setTipo_documento(tipo_documento);
		usuario.setRol(rol);
		usuarioDAO.guardar(usuario);
		return  "/Usuarios/indexUsuarios.xhtml?faces-redirect=true";
	}
	
	public List<Usuario> obtenerUsuarios(){
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		
		
		return usuarioDAO.obtenerUsuarios();

	}
	public String editar(long id_usuario) {
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		Usuario c=new Usuario();
		c = usuarioDAO.buscar(id_usuario);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", c);
		return "/Usuarios/editarUsuario.xhtml?faces-redirect=true";

		
	}
	
	public String actualizar(Usuario usuario) {
		usuario.setTipo_documento(tipo_documento);
		usuario.setRol(rol);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);
		return "/Usuarios/indexUsuarios.xhtml?faces-redirect=true";
	}
	
	// eliminar un cliente
		public String eliminar(long id_usuario) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.eliminar(id_usuario);
			System.out.println("Usuario eliminado..");
			return "/Usuarios/indexUsuarios.xhtml?faces-redirect=true";
		}
		

		
		



}
