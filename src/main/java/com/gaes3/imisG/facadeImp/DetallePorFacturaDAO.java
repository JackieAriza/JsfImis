package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.Detalle_Por_Factura;
import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Usuario;

public class DetallePorFacturaDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	//GUARDAR CLIENTE
	public void guardar(Detalle_Por_Factura detalleporfactura) {
		
		entity.getTransaction().begin();
		entity.persist(detalleporfactura);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//EDITAR CLIENTE
	public void editar(Detalle_Por_Factura detalleporfactura) {
		entity.getTransaction().begin();
		entity.merge(detalleporfactura);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//BUSCAR CLIENTE
	public Detalle_Por_Factura buscar(long idDetalle) {
		Detalle_Por_Factura d = new Detalle_Por_Factura();
		d = entity.find(Detalle_Por_Factura.class, idDetalle);
		//JPAUtil.shutdown();
		return d;
				
	}
	//ELIMINAR CLIENTE
	public void eliminar(long idDetalle) {
		Detalle_Por_Factura d = new Detalle_Por_Factura();
		d = entity.find(Detalle_Por_Factura.class, idDetalle);
		entity.getTransaction().begin();
		entity.remove(d);
		entity.getTransaction().commit();
		
		
	}
	
	//LISTAR CLIENTES
	public List<Detalle_Por_Factura> obtenerDetallePorFacturas(long id) {
		List<Detalle_Por_Factura> listaDetalle = new ArrayList<>();
		Query q= entity.createQuery("SELECT d FROM Detalle_Por_Factura d WHERE d.factura.idFactura = :id");
		q.setParameter("id", id);
		listaDetalle= q.getResultList();
		return listaDetalle;
	}

	
	//BUSCAR EMPLEADOS
	public List<Usuario> obtenerEmpleados(){
		List<Usuario> listausuarios = new ArrayList<>();
		Query q = entity.createQuery("SELECT u FROM Usuario u WHERE u.rol.idRol=1 OR u.rol.idRol=2");
		listausuarios = q.getResultList();
		return listausuarios;
	}

}
