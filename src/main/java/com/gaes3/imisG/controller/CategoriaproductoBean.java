package com.gaes3.imisG.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

@ManagedBean(name="categoriaproductoBean")
@RequestScoped
public class CategoriaproductoBean {
	
	private Categoriaproducto categoriaproducto;
	private List<Categoriaproducto> categoriaproductorp;
private static List<Boolean> list = Arrays.asList(true,true);
private CategoriaproductoDAO c = new CategoriaproductoDAO();
private UploadedFile subircat;
	
	
	
	

	public UploadedFile getSubircat() {
	return subircat;
}
public void setSubircat(UploadedFile subircat) {
	this.subircat = subircat;
}
	public List<Boolean> getList() {
		return list;
	}
	public String nuevo() {
		Categoriaproducto c= new Categoriaproducto();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoriaproducto", c);
		return "/Inventario/agregarcategoriaproducto.xhtml?faces-redirect=true";
	}
	public String empleadodashnuevo() {
		Categoriaproducto c= new Categoriaproducto();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoriaproducto", c);
		return "/DashboardEmpleado/agregarcategoria.xhtml?faces-redirect=true";
	}
	
	public String guardar(Categoriaproducto categoriaproducto) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.guardar(categoriaproducto);
		return "/Inventario/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	public String empleadodashguardar(Categoriaproducto categoriaproducto) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.guardar(categoriaproducto);
		return "/DashboardEmpleado/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	

	public List<Categoriaproducto> obtenerCategoriaproducto(){
	CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
	
	return categoriaproductoDAO.obtenerCategoriaproducto();
}
	
	public String editar(long id){
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		Categoriaproducto c= new Categoriaproducto();
		c=categoriaproductoDAO.buscar(id);
		System.out.print(c);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoriaproducto", c);
		
		return "/Inventario/editarcategoriaproducto.xhtml?faces-redirect=true";
	}
	public String empleadodasheditar(long id){
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		Categoriaproducto c= new Categoriaproducto();
		c=categoriaproductoDAO.buscar(id);
		System.out.print(c);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("categoriaproducto", c);
		
		return "/DashboardEmpleado/editarcategoriaproducto.xhtml?faces-redirect=true";
	}
	
	public String actualizar(Categoriaproducto categoriaproducto) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.editar(categoriaproducto);
		return"/Inventario/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	public String empleadodashactualizar(Categoriaproducto categoriaproducto) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.editar(categoriaproducto);
		return"/DashboardEmpleado/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	
	public String eliminar(long id) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.eliminar(id);
		System.out.println("Cliente Eliminado..");
	
		return "/Inventario/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	public String empleadodasheliminar(long id) {
		CategoriaproductoDAO categoriaproductoDAO= new CategoriaproductoDAO();
		categoriaproductoDAO.eliminar(id);
		System.out.println("Cliente Eliminado..");
	
		return "/DashboardEmpleado/listarcategoriaproducto.xhtml?faces-redirect=true";
	}
	

	public String reporte() throws FileNotFoundException, JRException {
		List<Categoriaproducto> cate = new ArrayList<>();
		cate = c.obtenerCategoriaproducto();
		System.out.println(cate);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/Productos.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(cate);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Angel Diaz");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\Angel\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources//Lista_Categorias.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bien";
	}
	public void cargarCat() {
		Date date = new Date();
		try {
			InputStream input = subircat.getInputStream();
			System.out.println(subircat);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
			categoriaproducto.setNom_categoria(currentRow.getCell(1).getStringCellValue());
					
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						categoriaproducto.setId_Categoriaproductos((int)currentRow.getCell(0).getNumericCellValue());
						c.editar(categoriaproducto);		
					
					} else {
						c.guardar(categoriaproducto);
					}
					categoriaproducto = new Categoriaproducto();
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



