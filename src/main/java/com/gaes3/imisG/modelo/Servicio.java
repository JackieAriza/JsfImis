package com.gaes3.imisG.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_servicios;
	private String nombre_Servicio;
	private double valor_servicio;
	
	//@OneToMany(mappedBy="servicio",fetch=FetchType.LAZY)
	//private List<Equipo> equipo;

	
	@ManyToOne 
	@JoinColumn(name="fk_IdCliente")
	private Cliente cliente;
	
	@ManyToOne 
	@JoinColumn(name="fk_id_equipos")
	private Equipo equipo;
	
	public long getId_servicios() {
		return id_servicios;
	}
	public void setId_servicios(long id_servicios) {
		this.id_servicios = id_servicios;
	}
	public String getNombre_Servicio() {
		return nombre_Servicio;
	}
	public void setNombre_Servicio(String nombre_Servicio) {
		this.nombre_Servicio = nombre_Servicio;
	}
	public double getValor_servicio() {
		return valor_servicio;
	}
	public void setValor_servicio(double valor_servicio) {
		this.valor_servicio = valor_servicio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return "Servicio [id_servicios=" + id_servicios + ", nombre_Servicio=" + nombre_Servicio + ", valor_servicio="
				+ valor_servicio + ", cliente=" + cliente + ", equipo=" + equipo + "]";
	}
	

	
	
	

}
