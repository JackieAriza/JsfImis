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
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;


import com.gaes3.imisG.controller.FacturaBean;
import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.FacturaDAO;
import com.gaes3.imisG.facadeImp.FormapagoDAO;
import com.gaes3.imisG.facadeImp.UsuarioDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Factura;
import com.gaes3.imisG.modelo.FormaPago;
import com.gaes3.imisG.modelo.Usuario;

@ManagedBean(name = "facturaBean")
@RequestScoped
public class FacturaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Factura factura;
	private List<Factura> facturaf;

	private List<Cliente> obtenerClientes;
	private Cliente cliente;

	private List<Usuario> obtenerUsuarios;
	private Usuario usuario;

	private List<FormaPago> obtenerFormaPagos;
	private FormaPago formaPago;

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Cliente> getObtenerClientes() {
		ClienteDAO c = new ClienteDAO();
		obtenerClientes = c.obtenerClientes();
		return obtenerClientes;
	}

	public void setObtenerClientes(List<Cliente> obtenerClientes) {
		this.obtenerClientes = obtenerClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Usuario> getObtenerUsuarios() {
		UsuarioDAO u = new UsuarioDAO();
		obtenerUsuarios = u.obtenerUsuarios();
		return obtenerUsuarios;
	}

	public void setObtenerUsuarios(List<Usuario> obtenerUsuarios) {
		this.obtenerUsuarios = obtenerUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<FormaPago> getObtenerFormaPagos() {
		FormapagoDAO p = new FormapagoDAO();
		obtenerFormaPagos = p.obtenerFormaPagos();
		return obtenerFormaPagos;
	}

	public void setObtenerFormaPagos(List<FormaPago> obtenerFormaPagos) {
		this.obtenerFormaPagos = obtenerFormaPagos;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	@PostConstruct
	public void init() {
		factura = new Factura();
		cliente = new Cliente();
		usuario = new Usuario();
		formaPago = new FormaPago();

	}

	public String nuevo() {
		return "/Ventas/nuevafactura.xhtml?faces-redirect=true";
	}

	public String empleadodashnuevo() {
		return "/DashboardEmpleado/nuevafactura.xhtml?faces-redirect=true";
	}

	public void guardar(ActionEvent event) {
		factura.setCliente(cliente);
		factura.setFormaPago(formaPago);
		factura.setUsuario(usuario);
		System.out.println("Entrastea guardar");
		// guarda la fecha de registro
		Date fechaActual = new Date();
		factura.setFecha_registro(fechaActual);
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.guardar(factura);
	}

	public void empleadodashguardar(ActionEvent event) {
		factura.setCliente(cliente);
		factura.setFormaPago(formaPago);
		factura.setUsuario(usuario);
		System.out.println("Entrastea guardar");
		// guarda la fecha de registro
		Date fechaActual = new Date();
		factura.setFecha_registro(fechaActual);
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.guardar(factura);
	}

	public String direccionar() {
		return "/Ventas/listarfactura.xhtml?faces-redirect=true";
	}

	public String empleadodashdireccionar() {
		return "/DashboardEmpleado/listarfactura.xhtml?faces-redirect=true";
	}

	public List<Factura> obtenerFacturas() {
		FacturaDAO facturaDAO = new FacturaDAO();
		return facturaDAO.obtenerFacturas();
	}

	public String editar(long id) {
		FacturaDAO facturaDAO = new FacturaDAO();
		Factura c = new Factura();
		c = facturaDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("factura", c);
		return "/Ventas/editarfactura.xhtml?faces-redirect=true";
	}

	public String empleadodasheditar(long id) {
		FacturaDAO facturaDAO = new FacturaDAO();
		Factura c = new Factura();
		c = facturaDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("factura", c);
		return "/DashboardEmpleado/editarfactura.xhtml?faces-redirect=true";
	}

	public String actualizar(Factura factura) {

		factura.setUsuario(usuario);
		factura.setCliente(cliente);
		factura.setFormaPago(formaPago);
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.editar(factura);
		return "/Ventas/listarfactura.xhtml?faces-redirect=true";
	}

	public String empleadodashactualizar(Factura factura) {

		factura.setUsuario(usuario);
		factura.setCliente(cliente);
		factura.setFormaPago(formaPago);
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.editar(factura);
		return "/DashboardEmpleado/listarfactura.xhtml?faces-redirect=true";
	}

	// eliminar una factura
	public String eliminar(long idFactura) {
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.eliminar(idFactura);
		return "/Ventas/listarfactura.xhtml?faces-redirect=true";
	}

	public String empleadodasheliminar(long idFactura) {
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.eliminar(idFactura);
		return "/DashboardEmpleado/listarfactura.xhtml?faces-redirect=true";
	}


}