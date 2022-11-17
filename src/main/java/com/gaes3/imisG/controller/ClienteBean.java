package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.ProveedorDAO;
import com.gaes3.imisG.facadeImp.Tipo_DocumentoDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Tipo_Documento;


@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean implements Serializable{
	private Cliente cliente; 
	private static final long serialVersionUID = 1L;
	private List<Tipo_Documento> obtenerDocumentos;
	private Tipo_Documento tipo_Documento;
	private List<Cliente> clienten;


	public List<Tipo_Documento> getObtenerDocumentos() {
		Tipo_DocumentoDAO t = new Tipo_DocumentoDAO();
		obtenerDocumentos = t.obtenerDocumentos();
		return obtenerDocumentos;
	}
	
	public void setObtenerDocumentos(List<Tipo_Documento> obtenerDocumentos) {
		this.obtenerDocumentos = obtenerDocumentos;
	}
	
	
	public Tipo_Documento getTipo_Documento() {
		return tipo_Documento;
	}
	public void setTipo_Documento(Tipo_Documento tipo_Documento) {
		this.tipo_Documento = tipo_Documento;
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		tipo_Documento = new Tipo_Documento();	
	}
	
	public String listar() {
		return "/Dashboard/nuevocliente.xhtml?faces-redirect=true";
	}
	
	public String nuevo() {
		return "/DashboardTecnico/nuevocliente.xhtml?faces-redirect=true";
	}
	public String nuevoemple() {
		return "/DashboardEmpleado/nuevocliente.xhtml?faces-redirect=true";
	}

	public String guardar() {
		cliente.setTipo_documento(tipo_Documento);
		//GUARDA LA FECHA DE REGISTRO
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.guardar(cliente);
		return "/Dashboard/inicioDash.xhtml?faces-redirect=true";
		
	}
	public String guardart() {
		cliente.setTipo_documento(tipo_Documento);
		//GUARDA LA FECHA DE REGISTRO
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.guardar(cliente);
		return "/DashboardTecnico/listarTecnico.xhtml?faces-redirect=true";
		
	}
	public String guardard() {
		cliente.setTipo_documento(tipo_Documento);
		//GUARDA LA FECHA DE REGISTRO
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.guardar(cliente);
		return "/DashboardEmpleado/empleado.xhtml?faces-redirect=true";
		
	}

	public List<Cliente> obtenerClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes();
	}
	public List<Cliente> obtenerClientest() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes();
	}
	public List<Cliente> obtenerClientesd() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes();
	}

	public String editar(long id) {
		System.out.println("dsfsdf");
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);	
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/Dashboard/editarcliente.xhtml?faces-redirect=true";
	}
	public String editard(long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);	
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/DashboardEmpleado/editarcliente.xhtml?faces-redirect=true";
	}
	public String editart(long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);	
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/DashboardTecnico/editarcliente.xhtml?faces-redirect=true";
	}

	public String actualizar(Cliente cliente) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		cliente.setTipo_documento(tipo_Documento);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/Dashboard/inicioDash.xhtml?faces-redirect=true";
	}
	public String actualizard(Cliente cliente) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		cliente.setTipo_documento(tipo_Documento);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/DashboardEmpleado/empleado.xhtml?faces-redirect=true";
	}
	
	public String actualizart(Cliente cliente) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		cliente.setTipo_documento(tipo_Documento);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/DashboardTecnico/listarTecnico.xhtml?faces-redirect=true";
	}

	public String eliminar(long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado");
		return "/Dashboard/inicioDash.xhtml?faces-redirect=true";

	}
	public String eliminard(long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado");
		return "/DashboardEmpleado/empleado.xhtml?faces-redirect=true";

	}
	public String eliminart(long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado");
		return "/DashboardTecnico/listarTecnico.xhtml?faces-redirect=true";

	}
	


}
