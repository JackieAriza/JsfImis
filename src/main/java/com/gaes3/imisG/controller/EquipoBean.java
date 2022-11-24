package com.gaes3.imisG.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.gaes3.imisG.facadeImp.EquipoDAO;
import com.gaes3.imisG.facadeImp.ServicioDAO;
import com.gaes3.imisG.modelo.Equipo;
import com.gaes3.imisG.modelo.Servicio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@ManagedBean(name="equipoBean")
@RequestScoped
public class EquipoBean {
	private List<Equipo> equipo;
	private EquipoDAO e = new EquipoDAO();
	private UploadedFile fileq;
	private Equipo equipop;
	
	
	

	public Equipo getEquipop() {
		return equipop;
	}
	public void setEquipop(Equipo equipop) {
		this.equipop = equipop;
	}
	public UploadedFile getFileq() {
		return fileq;
	}
	public void setFileq(UploadedFile fileq) {
		this.fileq = fileq;
	}
	public String listar() {
		Equipo e= new Equipo();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("equipo", e);
		return "/Equipo/nuevoequipo.xhtml?faces-redirect=true";
	}
	public String nuevo() {
		Equipo e= new Equipo();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("equipo", e);
		return "/DashboardTecnico/nuevoequipo.xhtml?faces-redirect=true";
	}

	public String guardar(Equipo equipo) {
		//GUARDA LA FECHA DE REGISTRO
		Date fechaActual= new Date();
		equipo.setFecha_Entrega(new java.util.Date(fechaActual.getTime()));
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.guardar(equipo);
		return "/Equipo/listarequipo.xhtml?faces-redirect=true";
	}
	public String guardare(Equipo equipo) {
		//GUARDA LA FECHA DE REGISTRO
		Date fechaActual= new Date();
		equipo.setFecha_Entrega(new java.util.Date(fechaActual.getTime()));
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.guardar(equipo);
		return "/DashboardTecnico/listarequipo.xhtml?faces-redirect=true";
	}

	public List<Equipo> obtenerEquipos() {
		EquipoDAO equipoDAO = new EquipoDAO();
		return equipoDAO.obtenerEquipos();
	}
	public List<Equipo> obtenerEquipose() {
		EquipoDAO equipoDAO = new EquipoDAO();
		return equipoDAO.obtenerEquipos();
	}

	public String editar(long id) {
		EquipoDAO equipoDAO = new EquipoDAO();
		Equipo e = new Equipo();
		e = equipoDAO.buscar(id);
		System.out.println(e);
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("equipo", e);
		return "/Equipo/editarequipo.xhtml?faces-redirect=true";
	}
	public String editare(long id) {
		EquipoDAO equipoDAO = new EquipoDAO();
		Equipo e = new Equipo();
		e = equipoDAO.buscar(id);
		System.out.println(e);
		// esto es una sesion y va a persistir sobre toda la ejeccucion
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("equipo", e);
		return "/DashboardTecnico/editarequipo.xhtml?faces-redirect=true";
	}

	public String actualizar(Equipo equipo) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.editar(equipo);
		return "/Equipo/listarequipo.xhtml?faces-redirect=true";
	}
	
	public String actualizare(Equipo equipo) {
		//GUARDAR LA FECHA DE ACTUALIZACION
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.editar(equipo);
		return "/DashboardTecnico/listarequipo.xhtml?faces-redirect=true";
	}

	public String eliminar(int id) {
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.eliminar(id);
		System.out.println("equipo eliminado");
		return "/Equipo/listarequipo.xhtml?faces-redirect=true";

	}
	public String eliminare(int id) {
		EquipoDAO equipoDAO = new EquipoDAO();
		equipoDAO.eliminar(id);
		System.out.println("equipo eliminado");
		return "/DashboardTecnico/listarequipo.xhtml?faces-redirect=true";

	}
	public String reportesequi() throws FileNotFoundException, JRException {
		List<Equipo> equi = new ArrayList<>();
		equi = e.obtenerEquipos();
		System.out.println(equi);
		String UrlRelativa=FacesContext.getCurrentInstance().getExternalContext().getRealPath
				("resources/Equipos.jrxml");
		File file= new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(equi);
		System.out.println("Url");
		Map<String,Object> map = new HashMap<>();
		map.put("createdBy", "Yakelin Ariza");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		String URLpdf="C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\reporteEquipo_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint,URLpdf);
		return "Bien";
	}
	
	@PostConstruct
	public void init() {
		equipop = new Equipo();
	}
	
	public void cargae() {
		Date date = new Date();
		try {
			InputStream input = fileq.getInputStream();
			System.out.println(fileq);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					equipop.setMarca(currentRow.getCell(1).getStringCellValue());
					equipop.setCantidad((long)currentRow.getCell(2).getNumericCellValue());
					equipop.setFecha_Entrega(currentRow.getCell(3).getDateCellValue());
					equipop.setEstado(currentRow.getCell(4).getStringCellValue());
					
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						equipop.setId_equipos((long) currentRow.getCell(0).getNumericCellValue());
						e.editar(equipop);
					} else {
						e.guardar(equipop);
					}
					equipop = new Equipo();
				}
				i++;
			}
			System.out.println("Ingresados exitosamente");
			PrimeFaces.current().ajax().update("datosVenta:Venta");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cargaeequipo() {
		Date date = new Date();
		try {
			InputStream input = fileq.getInputStream();
			System.out.println(fileq);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					equipop.setMarca(currentRow.getCell(1).getStringCellValue());
					equipop.setCantidad((long)currentRow.getCell(2).getNumericCellValue());
					equipop.setFecha_Entrega(currentRow.getCell(3).getDateCellValue());
					equipop.setEstado(currentRow.getCell(4).getStringCellValue());
					
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						equipop.setId_equipos((long) currentRow.getCell(0).getNumericCellValue());
						e.editar(equipop);
					} else {
						e.guardar(equipop);
					}
					equipop = new Equipo();
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
