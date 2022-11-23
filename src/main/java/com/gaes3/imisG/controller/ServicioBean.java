package com.gaes3.imisG.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import org.primefaces.model.file.UploadedFile;

import com.gaes3.imisG.facadeImp.ClienteDAO;
import com.gaes3.imisG.facadeImp.EquipoDAO;
import com.gaes3.imisG.facadeImp.ServicioDAO;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Equipo;

import com.gaes3.imisG.modelo.Servicio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "servicioBean")
@RequestScoped
public class ServicioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Servicio servicio;
	private List<Cliente> obtenerClientes;
	private Cliente cliente;
	private List<Equipo> obtenerEquipos;
	private Equipo equipo;
	private ServicioDAO s = new ServicioDAO();
	private UploadedFile file;

	private static List<Boolean> list = Arrays.asList(true, true, true, true, true, true);

	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Boolean> getList() {
		return list;
	}

	public List<Equipo> getObtenerEquipos() {
		EquipoDAO e = new EquipoDAO();
		obtenerEquipos = e.obtenerEquipos();
		return obtenerEquipos;
	}

	public Equipo getEquipos() {
		return equipo;
	}

	public void setObtenerEquipos(List<Equipo> obtenerEquipos) {
		this.obtenerEquipos = obtenerEquipos;
	}

	public void setEquipos(Equipo equipos) {
		this.equipo = equipos;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public List<Cliente> getObtenerClientes() {
		ClienteDAO c = new ClienteDAO();
		obtenerClientes = c.obtenerClientes();
		return obtenerClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public void setObtenerClientes(List<Cliente> obtenerClientes) {
		this.obtenerClientes = obtenerClientes;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		servicio = new Servicio();
		equipo = new Equipo();
		list = Arrays.asList(true, true, true, true, true, true);
	}

	public String listar() {
		return "/Servicio/nuevoservicio.xhtml?faces-redirect=true";

	}

	public String listars() {
		return "/DashboardTecnico/nuevoservicio.xhtml?faces-redirect=true";

	}

	public String guardar() {
		servicio.setEquipo(equipo);
		servicio.setCliente(cliente);
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.guardar(servicio);
		return "/Servicio/listarservicios.xhtml";
	}

	public String guardars() {
		servicio.setEquipo(equipo);
		servicio.setCliente(cliente);
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.guardar(servicio);
		return "/DashboardTecnico/listarservicios.xhtml";
	}

	public List<Servicio> obtenerServicios() {
		ServicioDAO clienteDAO = new ServicioDAO();
		return clienteDAO.obtenerServicios();
	}

	public List<Servicio> obtenerServiciosv() {
		ServicioDAO clienteDAO = new ServicioDAO();
		return clienteDAO.obtenerServicios();
	}

	public String editar(long id) {
		ServicioDAO servicioDAO = new ServicioDAO();
		Servicio s = new Servicio();
		s = servicioDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("servicio", s);
		return "/Servicio/editarservicio.xhtml?faces-redirect=true";
	}

	public String editars(long id) {
		ServicioDAO servicioDAO = new ServicioDAO();
		Servicio s = new Servicio();
		s = servicioDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("servicio", s);
		return "/DashboardTecnico/editarservicio.xhtml?faces-redirect=true";
	}

	public String actualizar(Servicio servicio) {
		// GUARDAR LA FECHA DE ACTUALIZACION
		servicio.setCliente(cliente);
		servicio.setEquipo(equipo);
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.editar(servicio);
		return "/Servicio/listarservicios.xhtml?faces-redirect=true";
	}

	public String actualizars(Servicio servicio) {
		// GUARDAR LA FECHA DE ACTUALIZACION
		servicio.setCliente(cliente);
		servicio.setEquipo(equipo);
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.editar(servicio);
		return "/DashboardTecnico/listarservicios.xhtml?faces-redirect=true";
	}

	public String eliminar(long id) {
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.eliminar(id);
		System.out.println("Servicio eliminado");
		return "/Servicio/listarservicios.xhtml?faces-redirect=true";

	}

	public String eliminars(long id) {
		ServicioDAO servicioDAO = new ServicioDAO();
		servicioDAO.eliminar(id);
		System.out.println("Servicio eliminado");
		return "/DashboardTecnico/listarservicios.xhtml?faces-redirect=true";

	}

	public String reportes() throws FileNotFoundException, JRException {
		List<Servicio> ser = new ArrayList<>();
		ser = s.obtenerServicios();
		System.out.println(ser);
		String UrlRelativa = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("resources/ServicioEquipo_1.jrxml");
		File file = new File(UrlRelativa);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ser);
		System.out.println("Url");
		Map<String, Object> map = new HashMap<>();
		map.put("createdBy", "Yakelin Ariza");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
		String URLpdf = "C:\\Users\\YakelinAriza\\eclipse-workspace\\imisG\\src\\main\\webapp\\resources\\reporteServicio_.pdf";
		JasperExportManager.exportReportToPdfFile(jasperPrint, URLpdf);
		return "Bien";
	}

	public void cargardeproductos() {

		Date date = new Date();
		try {
			InputStream input = file.getInputStream();
			System.out.println(file);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					servicio.setNombre_Servicio(currentRow.getCell(1).getStringCellValue());
					servicio.setValor_servicio(currentRow.getCell(2).getNumericCellValue());
					cliente.setIdCliente((long) currentRow.getCell(3).getNumericCellValue());
					equipo.setId_equipos((long) currentRow.getCell(4).getNumericCellValue());
					servicio.setCliente(cliente);
					servicio.setEquipo(equipo);
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						servicio.setId_servicios((int) currentRow.getCell(0).getNumericCellValue());
						s.editar(servicio);
					} else {
						s.guardar(servicio);
					}
					servicio = new Servicio();
				}
				i++;
			}
			System.out.println("Ingresados exitosamente");
			PrimeFaces.current().ajax().update("datosVenta:Venta");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void upload() {
		Date date = new Date();
		try {
			InputStream input = file.getInputStream();
			System.out.println(file);
			@SuppressWarnings("resource")
			XSSFWorkbook libro = new XSSFWorkbook(input);
			Sheet sheet = libro.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				if (i > 0) {
					servicio.setNombre_Servicio(currentRow.getCell(1).getStringCellValue());
					servicio.setValor_servicio(currentRow.getCell(2).getNumericCellValue());
					cliente.setIdCliente((long) currentRow.getCell(3).getNumericCellValue());
					equipo.setId_equipos((long) currentRow.getCell(4).getNumericCellValue());
					servicio.setCliente(cliente);
					servicio.setEquipo(equipo);
					if (currentRow.getCell(0).getNumericCellValue() > 0) {
						servicio.setId_servicios((int) currentRow.getCell(0).getNumericCellValue());
						s.editar(servicio);
					} else {
						s.guardar(servicio);
					}
					servicio = new Servicio();
				}
				i++;
			}
			System.out.println("Ingresados exitosamente");
			PrimeFaces.current().ajax().update("datosVenta:Venta");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

}
