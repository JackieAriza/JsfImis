package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.ProveedorDAO;
import com.gaes3.imisG.facadeImp.Tipo_DocumentoDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Servicio;
import com.gaes3.imisG.modelo.Tipo_Documento;


@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean implements Serializable{
	private Cliente cliente; 
	private static final long serialVersionUID = 1L;
	private List<Tipo_Documento> obtenerDocumentos;
	private Tipo_Documento tipo_Documento;
	private List<Cliente> clienten;
	private UploadedFile subir; 
	private ClienteDAO c = new ClienteDAO();
	
	


	public UploadedFile getSubir() {
		return subir;
	}

	public void setSubir(UploadedFile subir) {
		this.subir = subir;
	}

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
	public void cargame() {
		Date date = new Date();
		try {
			InputStream input = subir.getInputStream();
			System.out.println(subir);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					System.out.println("mmm");
					cliente.setNumDoc(currentRow.getCell(1).getStringCellValue());
					System.out.println("aaa");
					cliente.setNombreCliente(currentRow.getCell(2).getStringCellValue());
					System.out.println("ddd");
					cliente.setApellidoCliente(currentRow.getCell(3).getStringCellValue());
					System.out.println("fff");
					cliente.setTeleCliente(currentRow.getCell(4).getStringCellValue());
					System.out.println("dfg");
					cliente.setEmailCliente(currentRow.getCell(5).getStringCellValue());
					tipo_Documento.setId_Tipo_Documento((int)currentRow.getCell(6).getNumericCellValue());
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						cliente.setIdCliente((int)currentRow.getCell(0).getNumericCellValue());
						c.editar(cliente);
					} else {
						c.guardar(cliente);
					}
					cliente = new Cliente();
				}
				i++;
			}
			System.out.println("Ingresados exitosamente");
			PrimeFaces.current().ajax().update("datosVenta:Venta");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	


}
