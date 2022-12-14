package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import com.gaes3.imisG.Utilities.SessionUtils;
import com.gaes3.imisG.facadeImp.RolDAO;
import com.gaes3.imisG.facadeImp.UsuarioDAO;
import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Usuario;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	RolDAO rolDao = new RolDAO();
	private Usuario usuario = new Usuario();

	public LoginBean() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LoginBean(UsuarioDAO usuarioDAO, RolDAO rolDao, Usuario usuario) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.rolDao = rolDao;
		this.usuario = usuario;
	}

	public String iniciarSession() {
		String path = "";
		String usuarioRol = "";
		System.out.println("Usuario");
		usuarioRol = this.usuarioDAO.validarUsuario(usuario);
		HttpSession session = SessionUtils.getSession();
		System.out.println(session);
		switch (usuarioRol) {
		case "Administrador":
			session.setAttribute("username", usuario.getNomUsuario());
			path = "Dashboard/inicioDash.jsf?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		case "Empleado":
			System.out.println(usuarioRol);
			session.setAttribute("username", usuario.getNomUsuario());
			path = "DashboardEmpleado/empleado.jsf?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		case "Tecnico":
			session.setAttribute("username", usuario.getNomUsuario());
			path = "DashboardTecnico/listarTecnico.jsf?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		}
		return path;

	}

	public void verificarSesionAdministrador(ComponentSystemEvent event) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String u ="";
		u = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		if (u == null) {
			ec.redirect(ec.getRequestContextPath()+"/index.jsf");
		}else if(u.equalsIgnoreCase("Empleado")) {
			ec.redirect(ec.getRequestContextPath()+"/DashboardEmpleado/empleado.jsf");
		}else if(u.equalsIgnoreCase("Tecnico")) {
			ec.redirect(ec.getRequestContextPath()+"/DashboardTecnico/listarTecnico.jsf");
		}
	}
	
	public void verificarSesionEmpleado(ComponentSystemEvent event) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String u ="";
		u = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		if (u == null) {
			ec.redirect(ec.getRequestContextPath()+"/index.jsf");
		}else if(u.equalsIgnoreCase("Administrador")) {
			ec.redirect(ec.getRequestContextPath()+"/Dashboard/inicioDash.jsf");
		}else if(u.equalsIgnoreCase("Tecnico")) {
			ec.redirect(ec.getRequestContextPath()+"/DashboardTecnico/listarTecnico.jsf");
		}
	}
	
	public void verificarSesionTecnico(ComponentSystemEvent event) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String u ="";
		u = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		if (u == null) {
			ec.redirect(ec.getRequestContextPath()+"/index.jsf");
		}else if(u.equalsIgnoreCase("Administrador")) {
			ec.redirect(ec.getRequestContextPath()+"/Dashboard/inicioDash.jsf");
		}else if(u.equalsIgnoreCase("Empleado")) {
			ec.redirect(ec.getRequestContextPath()+"/DashboardEmpleado/empleado.jsf");
		}
	}

	public void cerrarSesion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath()+"/login.jsf");
	}
}
