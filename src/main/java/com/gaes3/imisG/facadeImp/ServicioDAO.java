package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Servicio;

public class ServicioDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//GUARDAR SERVICIO
	public void guardar(Servicio servicio) {
		entity.getTransaction().begin();
		entity.persist(servicio);
		entity.getTransaction().commit();	
	}
	
	//EDITAR SERVICIO
	public void editar(Servicio servicio) {
		entity.getTransaction().begin();
		entity.merge(servicio);
		entity.getTransaction().commit();

	}
	
	//BUSCAR SERVICIO
	public Servicio buscar(long id) {
		Servicio s = new Servicio();
		s = entity.find(Servicio.class, id);
		return s;
	}
	//ElIMINAR SERVIVIO
	public void eliminar(long id) {
		Servicio s = new Servicio();
		s = entity.find(Servicio.class, id);
		entity.getTransaction().begin();
		entity.remove(s);
		entity.getTransaction().commit();
		
				
	}
	
	// LISTAR SERVICIOS
	
	public List<Servicio> obtenerServicios(){
		List<Servicio> listaServicios = new ArrayList<>();
		Query q = entity.createQuery("SELECT s From Servicio s");
		listaServicios = q.getResultList();
		return listaServicios;
		
	}


}
