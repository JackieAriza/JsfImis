package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.Detalleordencompra;
import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Orden_de_compra;


public class OrdendecompraDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	//GUARDAR ORDEN DE COMPRA 
	public void guardar(Orden_de_compra ordendecompra) {
		entity.getTransaction().begin();
		entity.persist(ordendecompra);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();

}
	//EDITAR ORDEN DE COMPRA 
		public void editar(Orden_de_compra ordendecompra) {
			entity.getTransaction().begin();
			entity.merge(ordendecompra);
			entity.getTransaction().commit();
			//JPAUtil.shutdown();
			
		}
		//BUSCAR ORDEN DE COMPRA 
		public Orden_de_compra buscar(long id) {
			Orden_de_compra o = new Orden_de_compra();
			o = entity.find(Orden_de_compra.class, id);
			//JPAUtil.shutdown();
			return o;
					
		}
		//ELIMINAR ORDEN DE COMPRA
		public void eliminar(long id) {
			Orden_de_compra o = new Orden_de_compra();
			o = entity.find(Orden_de_compra.class, id);
			entity.getTransaction().begin();
			entity.remove(o);
			entity.getTransaction().commit();
			
			
		}
		//LISTAR ORDEN DE COMPRA
		public List<Orden_de_compra> obtenerOrdenes_de_compra() {
			List<Orden_de_compra> listaOrden_de_compra = new ArrayList<>();
			Query q= entity.createQuery("SELECT o FROM Orden_de_compra o");
			listaOrden_de_compra= q.getResultList();
			return listaOrden_de_compra;
		}
		
		public void insertarDetalles(List<Detalleordencompra> dc) {
			entity.getTransaction().begin();
			for(Detalleordencompra detalles: dc) {
				entity.persist(detalles);
			}
			entity.getTransaction().commit();
		}
		
		@SuppressWarnings("unchecked")
		public List<Detalleordencompra> verDetalles(long id){
			List<Detalleordencompra> listad = new ArrayList<>();
			Query q = entity.createQuery("SELECT dc FROM Detalleordencompra dc WHERE dc.ordendecompra.id_orden_compra=:id");
			q.setParameter("id", id);
			listad = q.getResultList();
			return listad;
		}
		
}
