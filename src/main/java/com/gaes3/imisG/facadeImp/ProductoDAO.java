package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Producto;


public class ProductoDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	//GUARDAR CLIENTE
	public void guardar(Producto producto ) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//EDITAR CLIENTE
	public void editar(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//BUSCAR CLIENTE
	public Producto buscar(long id) {
		Producto p = new Producto();
		p = entity.find(Producto.class, id);
		//JPAUtil.shutdown();
		return p;
				
	}
	//ELIMINAR CLIENTE
	public void eliminar(long id) {
		Producto p  = new Producto();
		p = entity.find(Producto .class, id);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
		
		
	}
	
	//LISTAR CLIENTES
	public List<Producto> obtenerProducto() {
		List<Producto> listaProductos = new ArrayList<>();
		Query q= entity.createQuery("SELECT p FROM Producto p");
		listaProductos= q.getResultList();
		return listaProductos;
	}
}
