package com.gaes3.imisG.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.gaes3.imisG.facadeImp.FormapagoDAO;
import com.gaes3.imisG.modelo.FormaPago;

@ManagedBean(name = "formapagoBean")
@RequestScoped
public class FormapagoBean {
	
	public String nuevo() {
		FormaPago c= new FormaPago();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("formapago", c);
		return  "/Ventas/nuevaformapago.xhtml?faces-redirect=true";
	}
	public String empleadodashnuevo() {
		FormaPago c= new FormaPago();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("formapago", c);
		return  "/DashboardEmpleado/nuevaformapago.xhtml?faces-redirect=true";
	}
	
	public String guardar (FormaPago formaPago) {
		//guarda la fecha de registro		
		FormapagoDAO formapagoDAO= new FormapagoDAO();
		formapagoDAO.guardar(formaPago);
		return  "/Ventas/listarformapago.xhtml?faces-redirect=true";
	}
	
	public String empleadodashguardar (FormaPago formaPago) {
		//guarda la fecha de registro		
		FormapagoDAO formapagoDAO= new FormapagoDAO();
		formapagoDAO.guardar(formaPago);
		return  "/DashboardEmpleado/listarformapago.xhtml?faces-redirect=true";
	}

	public List<FormaPago> obtenerFormaPagos() {
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		return formapagoDAO.obtenerFormaPagos();
	}

	public String editar(long idPago) {
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		FormaPago p = new FormaPago();
		p = formapagoDAO.buscar(idPago);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("formaPago", p);
		return "/Ventas/editarformapago.xhtml?faces-redirect=true";
	}
	public String empleadodasheditar(long idPago) {
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		FormaPago p = new FormaPago();
		p = formapagoDAO.buscar(idPago);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("formaPago", p);
		return "/DashboardEmpleado/editarformapago.xhtml?faces-redirect=true";
	}

	public String actualizar(FormaPago formaPago) {	
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		formapagoDAO.editar(formaPago);
		return "/Ventas/listarformapago.xhtml?faces-redirect=true";
	}
	public String empleadodashactualizar(FormaPago formaPago) {	
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		formapagoDAO.editar(formaPago);
		return "/DashboardEmpleado/listarformapago.xhtml?faces-redirect=true";
	}

	// eliminar un cliente
	public String eliminar(long idPago) {
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		formapagoDAO.eliminar(idPago);
		System.out.println("eliminado..");
		return "/Ventas/listarformapago.xhtml?faces-redirect=true";
	}
	public String empleadodasheliminar(long idPago) {
		FormapagoDAO formapagoDAO = new FormapagoDAO();
		formapagoDAO.eliminar(idPago);
		System.out.println("eliminado..");
		return "/DashboardEmpleado/listarformapago.xhtml?faces-redirect=true";
	}

}
