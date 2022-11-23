package com.gaes3.imisG.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.PrimeFaces;

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
	private List<Producto> obtenerProductos = new ArrayList<>();
	private Producto producto;
	private List<Detalle_Por_Factura> detalleporfacturarp;
	
	private int id;
	
	private ProductoDAO productoDao = new ProductoDAO();
	
	private static final ArrayList<Detalle_Por_Factura> listacarrito = new ArrayList<Detalle_Por_Factura>();

	
	
	public ArrayList<Detalle_Por_Factura> getListacarrito() {
		return listacarrito;
	}

	public Detalle_Por_Factura getDetalleporfactura() {
		return detalleporfactura;
	}

	public List<Factura> getObtenerFactura() {
		FacturaDAO c = new FacturaDAO();
		obtenerFactura = c.obtenerFacturas();
		return obtenerFactura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public List<Producto> getObtenerProductos() {
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
		obtenerProductos = productoDao.obtenerProducto();
	}

	public String nuevo() {

		return "/Ventas/nuevodetalle.xhtml?faces-redirect=true";
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

		return "/DashboardEmpleado/detalleporfactura.xhtml";
	}

	
	public void agregar() {
		Detalle_Por_Factura df = new Detalle_Por_Factura();
		Producto p = new Producto();
		boolean verificar = false;
		long cantidadtotal=0;
		p = productoDao.buscar(producto.getIdProductos());
		if(producto.getStock()>0) {			
			if(p.getStock()>=producto.getStock()) {	
				for(Detalle_Por_Factura detalle: listacarrito ) {
					if(producto.getIdProductos() == detalle.getProducto().getIdProductos()) {
						verificar = true;
						cantidadtotal=cantidadtotal+detalle.getCantidadDetalle();
					}
				}
				if(verificar==true) {
					cantidadtotal=cantidadtotal+producto.getStock();
				}
				if(p.getStock()>=cantidadtotal) {
					df.setIdDetalle(listacarrito.size() + 1);
					df.setCantidadDetalle(producto.getStock());
					df.setProducto(producto);
					df.setSubTotal(producto.getValorProducto() * producto.getStock());
					df.setValorUnitario(producto.getValorProducto());
					df.setTotalGeneral(producto.getValorProducto()*producto.getStock());
					listacarrito.add(df);
					addMessage("Exitoso", "El producto fue agregado exitosamente");
					df = new Detalle_Por_Factura();
					producto = new Producto();
					PrimeFaces.current().ajax().update("datosVenta");
					PrimeFaces.current().ajax().update("detallesVenta:ventas");
				}else {
					addMessageError("Error", "La suma total de los productos es igual a " + cantidadtotal + " y no puede ser mayor a "+ p.getStock() + " que es la cantidad del inventario");
				}
			}else {
				addMessageError("Error", "La cantidad no puede ser mayor a la que existe en el inventario");
			}
		}else {
			addMessageError("Error", "La cantidad no puede ser menor o igual a 0");
		}
	}

	public void encontrar() {
		producto = productoDao.buscar(producto.getIdProductos());
		if(producto!=null) {
			addMessage("Exitoso","El producto " + producto.getNombreProducto() + " fue encontrado.");		
		}else {
			addMessageError("Error", "El produto no fue encontrado");
		}
	}
	
	public void eliminarDetalleCarrito(Detalle_Por_Factura detalle) {
		listacarrito.remove(detalle);
		ArrayList<Detalle_Por_Factura> lista = new ArrayList<>();
		int id = 1;
		for(Detalle_Por_Factura d: listacarrito){
			d.setIdDetalle(id);
			lista.add(d);
			id++;
		}
		listacarrito.clear();
		for(Detalle_Por_Factura d: lista) {
			listacarrito.add(d);
		}
		PrimeFaces.current().ajax().update("datosVenta");
		PrimeFaces.current().ajax().update("detallesVenta:ventas");
	}
	
	public void editarDetalleCarrito(Detalle_Por_Factura detalle) {
		producto =new Producto();
		producto.setStock(detalle.getCantidadDetalle());
		producto.setValorProducto(detalle.getValorUnitario());
		producto.setIdProductos(detalle.getProducto().getIdProductos());
		producto.setNombreProducto(detalle.getProducto().getNombreProducto());
		id=(int) detalle.getIdDetalle();
		System.out.println(id);
		PrimeFaces.current().ajax().update("datosVenta2");
		PrimeFaces.current().ajax().update("detallesVenta:ventas");
		PrimeFaces.current().executeScript("PF('dlgl').show();");
	}
	
	public void editarDetalle() {
		Detalle_Por_Factura df = new Detalle_Por_Factura();
		Producto p = new Producto();
		boolean verificar = false;
		long cantidadtotal=0;
		p = productoDao.buscar(producto.getIdProductos());
		if(producto.getStock()>0) {			
			if(p.getStock()>=producto.getStock()) {	
				for(Detalle_Por_Factura detalle: listacarrito ) {
					if(producto.getIdProductos() == detalle.getProducto().getIdProductos()) {
						verificar = true;
						cantidadtotal=detalle.getCantidadDetalle();
						break;
					}
				}
				if(verificar==true) {
					cantidadtotal=cantidadtotal+producto.getStock();
				}
				if(p.getStock()>=cantidadtotal) {	
					System.out.println(producto);
					df.setCantidadDetalle(producto.getStock());
					df.setProducto(producto);
					df.setSubTotal(producto.getValorProducto() * producto.getStock());
					df.setValorUnitario(producto.getValorProducto());
					df.setTotalGeneral(producto.getValorProducto()*producto.getStock());
					System.out.println(id);
					ArrayList<Detalle_Por_Factura> lista = new ArrayList<>();
					for(Detalle_Por_Factura detalle: listacarrito) {
						if(detalle.getIdDetalle()!=id) {
							lista.add(detalle);
							System.out.println("Prueba2");
						}else {
							lista.add(df);
						}
					}
					listacarrito.clear();
					int idlista=1;
					for(Detalle_Por_Factura detalle: lista) {
						detalle.setIdDetalle(idlista);
						listacarrito.add(detalle);
						idlista++;
					}
					addMessage("Exitoso", "El producto fue editado exitosamente");
					df = new Detalle_Por_Factura();
					producto = new Producto();
					PrimeFaces.current().ajax().update("datosVenta");
					PrimeFaces.current().ajax().update("detallesVenta:ventas");
				}else {
					addMessageError("Error", "La suma total de los productos es igual a " + cantidadtotal + " y no puede ser mayor a "+ p.getStock() + " que es la cantidad del inventario");
				}
			}else {
				addMessageError("Error", "La cantidad no puede ser mayor a la que existe en el inventario");
			}
		}else {
			addMessageError("Error", "La cantidad no puede ser menor o igual a 0");
		}
	}
	
	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessageWarning(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void limpiarcarrito() {
		listacarrito.clear();
		PrimeFaces.current().ajax().update("datosVenta");
		PrimeFaces.current().ajax().update("detallesVenta:ventas");
	}
}
