package com.gaes3.imisG.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;

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
	private ProductoDAO productoDAO = new ProductoDAO();
	private UploadedFile subirpr;

	
	
	
	

	

	public UploadedFile getSubirpr() {
		return subirpr;
	}

	public void setSubirpr(UploadedFile subirpr) {
		this.subirpr = subirpr;
	}

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
	
	public void cargarProd() {
		Date date = new Date();
		try {
			InputStream input = subirpr.getInputStream();
			System.out.println(subirpr);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					producto.setNombreProducto(currentRow.getCell(1).getStringCellValue());
					producto.setValorProducto((long)currentRow.getCell(2).getNumericCellValue());
					producto.setEstadoProducto(currentRow.getCell(3).getStringCellValue());
					producto.setStock((long)currentRow.getCell(4).getNumericCellValue());
					categoriaproducto.setId_Categoriaproductos((long)currentRow.getCell(5).getNumericCellValue());
					producto.setCategoriaproducto(categoriaproducto);
					
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						producto.setIdProductos((int)currentRow.getCell(0).getNumericCellValue());
						p.editar(producto);
					} else {
						p.guardar(producto);
					}
					producto = new Producto();
				}
				i++;
			}
			System.out.println("Ingresados exitosamente");
			PrimeFaces.current().ajax().update("datosVenta:Venta");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//carrito orden encontrar producto
	
		public void encontar() throws Exception{
			producto = productoDAO.finsById(producto.getIdProductos());
			if(producto!=null) {
				addMessage("Encontrado", "El producto" + producto.getNombreProducto() + "fue encontrado");
				PrimeFaces.current().ajax().update("datosOrdenes:Orden");
			}else {
				addMessageError("Error","El producto con id" + producto.getIdProductos() + "no existe ");
				
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
}

