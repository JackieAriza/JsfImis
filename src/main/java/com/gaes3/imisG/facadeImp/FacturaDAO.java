package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.Factura;
import com.gaes3.imisG.modelo.JPAUtil;

public class FacturaDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	/* guardar FACTURA */
	public void guardar(Factura factura) {
		entity.getTransaction().begin();
		entity.persist(factura);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// editar Factura
	public void editar(Factura factura) {
		entity.getTransaction().begin();
		entity.merge(factura);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// buscar Factura
	public Factura buscar(long idFactura) {
		Factura c = new Factura();
		c = entity.find(Factura.class, idFactura);
		// JPAUtil.shutdown();
		return c;
	}

	// eliminar una factura
	public void eliminar(long idFactura) {
		Factura c = new Factura();
		c = entity.find(Factura.class, idFactura);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todas facturas
	public List<Factura> obtenerFacturas() {
		List<Factura> listaFacturas = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Factura c");
		listaFacturas = q.getResultList();
		return listaFacturas;
	}
}
