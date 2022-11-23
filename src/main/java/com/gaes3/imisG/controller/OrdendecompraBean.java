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

import org.primefaces.PrimeFaces;

import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.OrdendecompraDAO;
import com.gaes3.imisG.facadeImp.ProductoDAO;
import com.gaes3.imisG.facadeImp.ProveedorDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Detalle_Por_Factura;
import com.gaes3.imisG.modelo.Detalleordencompra;
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

	private Orden_de_compra ordendecompra = new Orden_de_compra();
	private static final long serialVersionUID = 1L;

	// Carrito ordenes

	private List<Proveedor> obtenerProveedor;
	private Proveedor proveedor = new Proveedor();

	private List<Producto> obtenerProducto;
	private Producto producto = new Producto();
	// carrito
	private ProductoDAO productoDAO = new ProductoDAO();
	private List<Orden_de_compra> Ordendecompras;

	private OrdendecompraDAO o = new OrdendecompraDAO();
	// carrito
	private Orden_de_compra orden = new Orden_de_compra();
	private Detalleordencompra detalle = new Detalleordencompra();
	
	private Double total = 0.0;
	
	private List<Detalleordencompra> listad;

	private static List<Boolean> list = Arrays.asList(true, true, true, true);

	// variable carrito
	private long cantidad = 0;

	// Agrego lista para carrito de ordenes
	private static final ArrayList<Detalleordencompra> carritoOrdenes = new ArrayList<Detalleordencompra>();

	// Agrego get de carrito de ordenes
	/*
	 * public static ArrayList<Orden_de_compra> getCarritoordenes() { return
	 * carritoOrdenes; }
	 */

	
	public List<Detalleordencompra> getCarritoOrdenes() {
		return carritoOrdenes;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public static void setList(List<Boolean> list) {
		OrdendecompraBean.list = list;
	}

	public List<Boolean> getList() {
		return list;
	}

	public List<Detalleordencompra> getListad() {
		return listad;
	}

	public void setListad(List<Detalleordencompra> listad) {
		this.listad = listad;
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

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
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
		System.out.println("Entrastea guardar");
		// GUARDA LA FECHA DE REGISTRO
		Date fechaActual = new Date();
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

		ordendecompra = o;
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("ordendecompra", o);
		return "/CompraProveedores/editaro.xhtml";
	}

	public String actualizar(Orden_de_compra ordendecompra) {
		// GUARDAR FECHA DE ACTUALIZACION
		ordendecompra.setProveedor(proveedor);
		// Date fechaActual= new Date();
		// cliente.setFechaActual(new java.sql.Date(fechaActual.getTime()));
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		ordendecompraDAO.editar(ordendecompra);
		return "/CompraProveedores/ordendecompra.xhtml?faces-redirect=true";

	}

	public String eliminar(long id) {
		OrdendecompraDAO ordendecompraDAO = new OrdendecompraDAO();
		ordendecompraDAO.eliminar(id);
		System.out.println("Orden de compra eliminada");
		return "/CompraProveedores/ordendecompra.xhtml?faces-redirect=true";

	}
	// acciones carrito ordenes

	public void addOrden() {
		try {
			orden.setProveedor(proveedor);
			this.o.guardar(ordendecompra);
			PrimeFaces.current().ajax().update("DadosOrden:Orden");
			init();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void updateOrden(Orden_de_compra ordendecompra) {
		try {
			this.o.editar(this.ordendecompra);
			PrimeFaces.current().ajax().update("datosOrden:Orden");
			init();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();

		}
	}

	public void deleteOrden(Orden_de_compra ordendecompra) {
		try {
			this.o.eliminar(cantidad);
			this.Ordendecompras.remove(ordendecompra);
			PrimeFaces.current().ajax().update("datosOrden:Orden");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public String reporteOrden() throws FileNotFoundException, JRException {
		List<Orden_de_compra> or = new ArrayList<>();
		or = o.obtenerOrdenes_de_compra();
		System.out.println(or);
		String UrlRelativa = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("resources/Ordendecompra.jrxml");
		File file = new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(or);
		System.out.println("Url");
		Map<String, Object> map = new HashMap<>();
		map.put("createdBy", "Stiven Arboleda");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
		String URLpdf = "C:\\Users\\horac\\JsfImis\\src\\main\\webapp\\resources\\orddendecompra_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint, URLpdf);
		return "Bien";
	}

	public String tarjetaOr() throws FileNotFoundException, JRException {
		List<Orden_de_compra> ord = new ArrayList<>();
		ord = o.obtenerOrdenes_de_compra();
		System.out.println(ord);
		String UrlRelativa = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("resources/OrdenCompraTarje.jrxml");
		File file = new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ord);
		System.out.println("Url");
		Map<String, Object> map = new HashMap<>();
		map.put("createdBy", "Stiven Arboleda");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
		String URLpdf = "C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\reporteOrdenTraje_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint, URLpdf);
		return "Bieno";
	}

	// carrito orden encontrar producto

	public void encontrar() throws Exception {
		producto = productoDAO.finsById(producto.getIdProductos());
		if (producto != null) {
			addMessage("Encontrado", "El producto" + producto.getNombreProducto() + "fue encontrado");
			PrimeFaces.current().ajax().update("datosProducto");
		} else {
			addMessageError("Error", "El producto con id" + producto.getIdProductos() + "no existe ");

		}
	}

	public void agregar() {
		if (cantidad > 0) {
			detalle.setCantidad(cantidad);
			detalle.setProducto(producto);
			detalle.setPreciounitario(producto.getValorProducto());
			detalle.setPreciototal(cantidad * producto.getValorProducto());
			carritoOrdenes.add(detalle);
			detalle = new Detalleordencompra();
			producto = new Producto();
			cantidad = 0;
			total=0.0;
			for(Detalleordencompra dc: carritoOrdenes) {
				total=total+dc.getPreciototal();
			}
			PrimeFaces.current().ajax().update("datosDetalle");
			PrimeFaces.current().ajax().update("datosCliente");
			PrimeFaces.current().ajax().update("detallesOrden");
		} else {
			addMessageError("Error", "La cantidad no puede ser igual o menor a 0");
			detalle = new Detalleordencompra();
			producto = new Producto();
			cantidad = 0;
			PrimeFaces.current().ajax().update("message");
		}
	}

	public void generarDetalle() {
		Date fehca = new Date();
		orden.setFecha_orden_compra(fehca);
		Double precio = 0.0;
		for (Detalleordencompra v : carritoOrdenes) {
			precio += v.getPreciototal();
		}
		orden.setPrecio(precio);
		orden.setProveedor(proveedor);
		o.guardar(orden);
		orden = new Orden_de_compra();
		List<Orden_de_compra> lista = new ArrayList<>();
		lista = o.obtenerOrdenes_de_compra();
		for(Orden_de_compra or: lista) {
			orden = or;
		}
		for(Detalleordencompra dc: carritoOrdenes) {
			dc.setIddetalleorden(0);
			dc.setOrdendecompra(orden);
		}
		o.insertarDetalles(carritoOrdenes);
		carritoOrdenes.clear();
		total=0.0;
		PrimeFaces.current().ajax().update("datosDetalle");
		PrimeFaces.current().ajax().update("datosCliente");
		PrimeFaces.current().ajax().update("detallesOrden");
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void limpiar() {
		carritoOrdenes.clear();
	}
	
	public void ver(long id) {
		listad = o.verDetalles(id);
		System.out.println(listad);
		PrimeFaces.current().ajax().update("form:listadetalle");
	}

}
