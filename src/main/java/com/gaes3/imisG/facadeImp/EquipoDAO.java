package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.gaes3.imisG.modelo.Equipo;
import com.gaes3.imisG.modelo.JPAUtil;

public class EquipoDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// GUARDAR EQUIPO
	public void guardar(Equipo equipo) {
		entity.getTransaction().begin();
		entity.persist(equipo);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();

	}

	// EDITAR EQUIPO
	public void editar(Equipo equipo) {
		entity.getTransaction().begin();
		entity.merge(equipo);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();

	}

	// BUSCAR EQUIPO
	public Equipo buscar(long id) {
		Equipo e = new Equipo();
		e = entity.find(Equipo.class, id);
		// JPAUtil.shutdown();
		return e;

	}

	// ELIMINAR EQUIPO
	public void eliminar(long id) {
		Equipo e = new Equipo();
		e = entity.find(Equipo.class, id);
		entity.getTransaction().begin();
		entity.remove(e);
		entity.getTransaction().commit();

	}

	// LISTA EQUIPOS
	public List<Equipo> obtenerEquipos() {
		List<Equipo> listaEquipos = new ArrayList<>();
		Query q = entity.createQuery("SELECT e FROM Equipo e");
		listaEquipos = q.getResultList();
		return listaEquipos;
	}
}
