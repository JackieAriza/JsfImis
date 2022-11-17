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

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;

import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.OrdendecompraDAO;
import com.gaes3.imisG.facadeImp.ProductoDAO;
import com.gaes3.imisG.facadeImp.ProveedorDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Orden_de_compra;
import com.gaes3.imisG.modelo.Producto;
import com.gaes3.imisG.modelo.Proveedor;
import com.gaes3.imisG.modelo.Tipo_Documento;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "ordendecompraBean")
@RequestScoped
public class OrdendecompraBean implements Serializable {

	private Orden_de_compra ordendecompra = new Orden_de_compra() ;
	private static final long serialVersionUID = 1L;
	
	private List<Proveedor> obtenerProveedor;
	private Proveedor proveedor;
	
	private List<Producto> obtenerProducto;
	private Producto producto;
	private List<Orden_de_compra> Ordendecompra;
	
	private OrdendecompraDAO o = new OrdendecompraDAO();
	private OrdendecompraDAO on = new OrdendecompraDAO();

	private static List<Boolean> list = Arrays.asList(true,true,true,true,true);
	

	public List<Boolean> getList() {
		return list;
	}
	

	
	public Orden_de_compra getOrdendecompra() {
		return ordendecompra;
	}



	public void setOrdendecompra(Orden_de_compra ordendecompra) {
		this.ordendecompra = ordendecompra;
	}



	public List<Proveedor> getObtenerProveedor() {
		ProveedorDAO p = new ProveedorDAO();
		obtenerProveedor = p.obtenerProveedor();
		return obtenerProveedor;
	}



	public void setObtenerProveedor(List<Proveedor> obtenerProveedor) {
		this.obtenerProveedor = obtenerProveedor;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public List<Producto> getObtenerProducto() {
		ProductoDAO c = new ProductoDAO();
		obtenerProducto = c.obtenerProducto();
		return obtenerProducto;
	}



	public void setObtenerProductos(List<Producto> obtenerProductos) {
		this.obtenerProducto = obtenerProductos;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	


	public OrdendecompraBean(Orden_de_compra ordendecompra, List<Proveedor> obtenerProveedor, Proveedor proveedor,
			List<Producto> obtenerProductos, Producto producto) {
		super();
		this.ordendecompra = ordendecompra;
		this.obtenerProveedor = obtenerProveedor;
		this.proveedor = proveedor;
		this.obtenerProducto = obtenerProductos;
		this.producto = producto;
	}



	public OrdendecompraBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@PostConstruct
	public void init() {
		ordendecompra = new Orden_de_compra();
		proveedor = new Proveedor();
		producto = new Producto();
	}
	
		
	
	public String listar() {
		return "/CompraProveedores/nuevao.xhtml?faces-redirect=true";
	}
	public void guardar(ActionEvent event) {
		ordendecompra.setProveedor(proveedor);
		ordendecompra.setProducto(producto);
		System.out.println("Entrastea guardar");
		//GUARDA LA FECHA DE REGISTRO
		Date fechaActual= new Date();
		System.out.println(fechaActual);
		ordendecompra.setFecha_orden_compra(fechaActual);
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		ordendecompraDAO.guardar(ordendecompra);
}
	public String direccionar() {
		return "/CompraProveedores/ordendecompra.xhtml?faces-redirect=true";
	}
	public List<Orden_de_compra> obtenerOrdenes_de_compra() {
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		return ordendecompraDAO.obtenerOrdenes_de_compra();
	}
	public String editar(long id) {
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		Orden_de_compra o = new Orden_de_compra();
		o = ordendecompraDAO.buscar(id);
		proveedor.setId_proveedor(o.getProveedor().getId_proveedor());
		producto.setIdProductos(o.getProducto().getIdProductos());
		ordendecompra = o;
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("ordendecompra", o);
		return "/CompraProveedores/editaro.xhtml";
	}
	public String actualizar(Orden_de_compra ordendecompra ) {
		//GUARDAR FECHA DE ACTUALIZACION
		ordendecompra.setProveedor(proveedor);
		ordendecompra.setProducto(producto);
		//Date fechaActual= new Date();
		//cliente.setFechaActual(new java.sql.Date(fechaActual.getTime()));
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		ordendecompraDAO.editar(ordendecompra);
		return "/CompraProveedores/ordendecompra.xhtml?faces-redirect=true";


	}
	public String eliminar(long id) {
		OrdendecompraDAO ordendecompraDAO =new OrdendecompraDAO();
		ordendecompraDAO.eliminar(id);
		System.out.println("Orden de compra eliminada");
		return "/CompraProveedores/ordendecompra.xhtml?faces-redirect=true";

		
	}


	
	public String reporteOrden() throws FileNotFoundException, JRException {
		List<Orden_de_compra> or = new ArrayList<>();
		or = o.obtenerOrdenes_de_compra();
		System.out.println(or);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/Ordendecompra.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(or);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Stiven Arboleda");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\reporteOrden_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bien";
	}
	public String tarjetaOr() throws FileNotFoundException, JRException {
		List<Orden_de_compra> ord = new ArrayList<>();
		ord = on.obtenerOrdenes_de_compra();
		System.out.println(ord);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/OrdenCompraTarje.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(ord);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Stiven Arboleda");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\reporteOrdenTraje_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bieno";
	}


	

	}
	

