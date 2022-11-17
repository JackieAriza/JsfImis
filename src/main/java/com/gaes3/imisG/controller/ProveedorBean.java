package com.gaes3.imisG.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.util.ResourceUtils;



import com.gaes3.imisG.facadeImp.ProveedorDAO;
import com.gaes3.imisG.facadeImp.Tipo_DocumentoDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Proveedor;
import com.gaes3.imisG.modelo.Tipo_Documento;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name="proveedorBean")
@NamedEvent
@RequestScoped
public class ProveedorBean implements Serializable {
	
	private Proveedor proveedor = new Proveedor();
	private static final long serialVersionUID = 1L;
	private List<Tipo_Documento> obtenerDocumentos;
	private Tipo_Documento tipo_Documento = new Tipo_Documento();
	private List<Proveedor> proveedorp;
	
	private ProveedorDAO p = new ProveedorDAO();
	
private static List<Boolean> list = Arrays.asList(true,true,true,true,true,true,true);
	

	public List<Boolean> getList() {
		return list;
	}
	
	
	public List<Tipo_Documento> getObtenerDocumentos() {
		Tipo_DocumentoDAO t = new Tipo_DocumentoDAO();
		obtenerDocumentos = t.obtenerDocumentos();
		return obtenerDocumentos;
	}
	
	public ProveedorBean(Proveedor proveedor, List<Tipo_Documento> obtenerDocumentos, Tipo_Documento tipo_Documento) {
		super();
		this.proveedor = proveedor;
		this.obtenerDocumentos = obtenerDocumentos;
		this.tipo_Documento = tipo_Documento;
	}


	public ProveedorBean() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	
	public String listar() {
		//System.out.println("Entrando a listar");
		return "/CompraProveedores/nuevoproveedor.xhtml?faces-redirect=true";
	}
	//Set agregados en proveedor
	public void guardar(ActionEvent event) {
	proveedor.setTipo_documento(tipo_Documento);
	System.out.println("Entrastea guardar");
	//GUARDA LA FECHA DE REGISTRO
	Date fechaActual= new Date();
	System.out.println(fechaActual);
	proveedor.setFecha_creado_proveedor(fechaActual);
	ProveedorDAO proveedorDAO = new ProveedorDAO();
	proveedorDAO.guardar(proveedor);
	}
	
	public String direccionar() {
		return "/CompraProveedores/listaproveedor.xhtml?faces-redirect=true";
	}
	//Change agregado en obtenerProveedor
	public List<Proveedor> obtenerProveedores(){
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		return proveedorDAO.obtenerProveedor();
		
	}
	
	public String editar(long id) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		Proveedor p = new Proveedor();
		p = proveedorDAO.buscar(id);
		tipo_Documento.setId_Tipo_Documento(p.getTipo_documento().getId_Tipo_Documento());
		proveedor = p;
		//System.out.println(p);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", p);
		return "/CompraProveedores/editarp.xhtml";
	}

	public String actualizar(Proveedor proveedor) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		proveedor.setTipo_documento(tipo_Documento);
		//Date fechaActual=new Date();
		//proveedor.setFechaActual(new java.sql.Date(fechaActual.getTime()));
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedorDAO.editar(proveedor);
		return "/CompraProveedores/listaproveedor.xhtml?faces-redirect=true";
	}
	
	public String eliminar(long id) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedorDAO.eliminar(id);
		System.out.println("Proveedor eliminado");
		return "/CompraProveedores/listaproveedor.xhtml?faces-redirect=true";
		
	}

	
	public String prueba() throws FileNotFoundException, JRException {
		List<Proveedor> pro = new ArrayList<>();
		pro = p.obtenerProveedor();
		System.out.println(pro);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/Proveedores.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(pro);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Stiven Arboleda");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\Lista_Proveedores_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bien";
	}


}