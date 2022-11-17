package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.FormaPago;
import com.gaes3.imisG.modelo.JPAUtil;

public class FormapagoDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	 // guardar forma de pago 
	public void guardar(FormaPago formaPago) {
		entity.getTransaction().begin();
		entity.persist(formaPago);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// editar FormaPago
	public void editar(FormaPago formaPago) {
		entity.getTransaction().begin();
		entity.merge(formaPago);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// buscar FormaPago
	public FormaPago buscar(long idPago) {
		FormaPago p = new FormaPago();
		p = entity.find(FormaPago.class, idPago);
		// JPAUtil.shutdown();
		return p;
	}

	// eliminar una FormaPago
	public void eliminar(long idPago) {
		FormaPago p = new FormaPago();
		p = entity.find(FormaPago.class, idPago);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	// obtener todas FormaPagos
	public List<FormaPago> obtenerFormaPagos() {
		List<FormaPago> listaFormaPagos = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM FormaPago p");
		listaFormaPagos = q.getResultList();
		return listaFormaPagos;
	}
}

