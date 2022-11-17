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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import com.gaes3.imisG.facadeImp.CategoriaproductoDAO;
import com.gaes3.imisG.facadeImp.ProductoDAO;
import com.gaes3.imisG.modelo.Categoriaproducto;
import com.gaes3.imisG.modelo.Producto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;




@ManagedBean(name="productoBean")
@RequestScoped
public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Producto producto;
	private List<Categoriaproducto> obtenerCategoriaproducto;
	private Categoriaproducto categoriaproducto;
	private List<Producto> productorp;
    private static List<Boolean> list = Arrays.asList(true,true,true,true,true,true);
    private ProductoDAO p = new ProductoDAO();
	
	
	
	
	

	public List<Boolean> getList() {
		return list;
	}

	public Producto getProducto() {
		return producto;
	}

	public List<Categoriaproducto> getObtenerCategoriaproducto() {
		CategoriaproductoDAO c = new CategoriaproductoDAO();
		obtenerCategoriaproducto = c.obtenerCategoriaproducto();
		return obtenerCategoriaproducto;
	}

	public Categoriaproducto getCategoriaproducto() {
		return categoriaproducto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setObtenerCategoriaproducto(List<Categoriaproducto> obtenerCategoriaproducto) {
		this.obtenerCategoriaproducto = obtenerCategoriaproducto;
	}

	public void setCategoriaproducto(Categoriaproducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}

	@PostConstruct
	public void init() {
		producto = new Producto();
		categoriaproducto = new Categoriaproducto();
	}

	public String nuevo() {
		return "/Inventario/agregarproducto.xhtml?faces-redirect=true";
	}
	
	public String empleadodashnuevo() {
		return "/DashboardEmpleado/agregarproducto.xhtml?faces-redirect=true";
	}

	public String guardar() {
		producto.setCategoriaproducto(categoriaproducto);
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.guardar(producto);
		return "/Inventario/listarproducto.xhtml?faces-redirect=true";

	}
	public String empleadodashguardar() {
		producto.setCategoriaproducto(categoriaproducto);
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.guardar(producto);
		return "/DashboardEmpleado/listarproducto.xhtml?faces-redirect=true";

	}

	public List<Producto> obtenerProducto() {
		ProductoDAO productoDAO = new ProductoDAO();
		return productoDAO.obtenerProducto();
	}

	public String editar(long id) {
		ProductoDAO productoDAO = new ProductoDAO();
		Producto p = new Producto();
		p = productoDAO.buscar(id);
		System.out.print(p);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);

		return "/Inventario/editarproductos.xhtml?faces-redirect=true";
	}
	public String empleadodasheditar(long id) {
		ProductoDAO productoDAO = new ProductoDAO();
		Producto p = new Producto();
		p = productoDAO.buscar(id);
		System.out.print(p);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);

		return "/DashboardEmpleado/editarproductos.xhtml?faces-redirect=true";
	}

	public String actualizar(Producto producto) {
		producto.setCategoriaproducto(categoriaproducto);
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.editar(producto);
		return "/Inventario/listarproducto.xhtml?faces-redirect=true";
	}
	public String empleadodashactualizar(Producto producto) {
		producto.setCategoriaproducto(categoriaproducto);
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.editar(producto);
		return "/DashboardEmpleado/listarproducto.xhtml?faces-redirect=true";
	}

	public String eliminar(long id) {
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.eliminar(id);
		System.out.println("producto Eliminado..");

		return "/Inventario/listarproducto.xhtml";
	}
	public String empleadodasheliminar(long id) {
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.eliminar(id);
		System.out.println("producto Eliminado..");

		return "/DashboardEmpleado/listarproducto.xhtml";
	}
	public void exportar() throws IOException {
		ProductoDAO p = new ProductoDAO();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue="attachment; filename=listaProducto_" + ".xlsx";
		response.setHeader(headerKey, headerValue);
		this.productorp=p.obtenerProducto();
}
	
	public String reporte() throws FileNotFoundException, JRException {
		List<Producto> pro = new ArrayList<>();
		pro = p.obtenerProducto();
		System.out.println(pro);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/Productos.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(pro);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Angel Diaz");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\Lista_Productos.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bien";
	}
}
