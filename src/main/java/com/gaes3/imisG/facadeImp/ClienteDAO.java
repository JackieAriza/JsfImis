package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.JPAUtil;



public class ClienteDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	//GUARDAR CLIENTE
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//EDITAR CLIENTE
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	//BUSCAR CLIENTE
	public Cliente buscar(long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return c;
				
	}
	//ELIMINAR CLIENTE
	public void eliminar(long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
		
		
	}
	
	//LISTAR CLIENTES
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q= entity.createQuery("SELECT c FROM Cliente c");
		listaClientes= q.getResultList();
		return listaClientes;
	}
	
	public List<Cliente> obtenerCorreos() {
		List<Cliente> listacorreos= new ArrayList<>();
		Query q= entity.createQuery("SELECT EmailCliente FROM cliente");
		listacorreos= q.getResultList();
		return listacorreos;
	}
}
