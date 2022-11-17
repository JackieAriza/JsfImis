package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Proveedor;

public class ProveedorDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	//GUARDAR PROVEEDOR
	public void guardar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.persist(proveedor);
		entity.getTransaction().commit();
		///JPAUtil.shutdown();

	}
	//EDITAR PROVEEDOR
	public void editar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.merge(proveedor);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//BUSCAR PROVEEDOR
	public Proveedor buscar(long id) {
	Proveedor p = new Proveedor();
	p = entity.find(Proveedor.class, id);
	//JPAUtil.shutdown();
	return p;
			
	
	}
	//ELIMINAR PROVEEDOR
	public void eliminar(long id) {
		Proveedor p = new Proveedor();
		p = entity.find(Proveedor.class, id);
		System.out.println("DaoEliminar");
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
		
	}
	//LISTAR PROVEEDOR
	public List<Proveedor> obtenerProveedor(){
		List<Proveedor> listaProveedores = new ArrayList<>();
		Query q= entity.createQuery("SELECT p FROM Proveedor p ");
		listaProveedores= q.getResultList();
		return listaProveedores;
	}

	
}
