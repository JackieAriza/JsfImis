package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.gaes3.imisG.facadeImp.DetallePorFacturaDAO;
import com.gaes3.imisG.facadeImp.FacturaDAO;
import com.gaes3.imisG.facadeImp.ProductoDAO;
import com.gaes3.imisG.modelo.Detalle_Por_Factura;
import com.gaes3.imisG.modelo.Factura;
import com.gaes3.imisG.modelo.Producto;

@ManagedBean(name = "detalleporfacturaBean")
@RequestScoped
public class DetallePorFacturaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Detalle_Por_Factura detalleporfactura;
	private List<Factura> obtenerFactura;
	private Factura factura;
	private List<Producto> obtenerProductos;
	private Producto producto;
	private List<Detalle_Por_Factura> detalleporfacturarp;

	public Detalle_Por_Factura getDetalleporfactura() {
		return detalleporfactura;
	}

	public List<Factura> getObtenerFactura() {
		FacturaDAO c = new FacturaDAO();
		obtenerFactura = c.obtenerFacturas();
		return obtenerFactura;
	}

	public Factura getFactura() {
		return factura;
	}

	public List<Producto> getObtenerProductos() {
		ProductoDAO p = new ProductoDAO();
		obtenerProductos = p.obtenerProducto();
		return obtenerProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setDetalleporfactura(Detalle_Por_Factura detalleporfactura) {
		this.detalleporfactura = detalleporfactura;
	}

	public void setObtenerFacturas(List<Factura> obtenerFactura) {
		this.obtenerFactura = obtenerFactura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public void setObtenerProductos(List<Producto> obtenerProductos) {
		this.obtenerProductos = obtenerProductos;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@PostConstruct
	public void init() {
		detalleporfactura = new Detalle_Por_Factura();
		producto = new Producto();
		factura = new Factura();
	}

	public String nuevo() {

		return "/Ventas/nuevodetalle.xhtml";
	}
	public String empleadodashnuevo() {

		return "/DashboardEmpleado/nuevodetalle.xhtml";
	}

	public String guardar(Detalle_Por_Factura detalle_por_factura) {
		detalleporfactura.setProducto(producto);
		detalleporfactura.setFactura(factura);
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.guardar(detalleporfactura);
		return "/Ventas/detalleporfactura.xhtml";
	}
	public String empleadodashguardar(Detalle_Por_Factura detalle_por_factura) {
		detalleporfactura.setProducto(producto);
		detalleporfactura.setFactura(factura);
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.guardar(detalleporfactura);
		return "/DashboardEmpleado/detalleporfactura.xhtml";
	}

	public List<Detalle_Por_Factura> obtenerDetallePorFactura() {
		System.out.println("Entrando a obtener");
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		return d.obtenerDetallePorFacturas();
	}

	public String editar(long id) {
		DetallePorFacturaDAO detalleporfacturaDAO = new DetallePorFacturaDAO();
		Detalle_Por_Factura d = new Detalle_Por_Factura();
		d = detalleporfacturaDAO.buscar(id);
		System.out.print(d);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("detalle_por_factura", d);

		return "/Ventas/editardetalle.xhtml";
	}
	public String empleadodasheditar(long id) {
		DetallePorFacturaDAO detalleporfacturaDAO = new DetallePorFacturaDAO();
		Detalle_Por_Factura d = new Detalle_Por_Factura();
		d = detalleporfacturaDAO.buscar(id);
		System.out.print(d);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("detalle_por_factura", d);

		return "/DashboardEmpleado/editardetalle.xhtml";
	}

	public String actualizar(Detalle_Por_Factura detalle_por_factura) {
		detalleporfactura.setProducto(producto);
		detalleporfactura.setFactura(factura);
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.editar(detalleporfactura);
		return "/Ventas/detalleporfactura.xhtml";
	}
	public String empleadodashactualizar(Detalle_Por_Factura detalle_por_factura) {
		detalleporfactura.setProducto(producto);
		detalleporfactura.setFactura(factura);
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.editar(detalleporfactura);
		return "/DashboardEmpleado/detalleporfactura.xhtml";
	}

	public String eliminar(long id) {
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.eliminar(id);
		System.out.println("Cliente Eliminado..");

		return "/Ventas/detalleporfactura.xhtml";
	}
	public String empleadodasheliminar(long id) {
		DetallePorFacturaDAO d = new DetallePorFacturaDAO();
		d.eliminar(id);
		System.out.println("Cliente Eliminado..");

		return "/DashboardEmpelado/detalleporfactura.xhtml";
	}


}
