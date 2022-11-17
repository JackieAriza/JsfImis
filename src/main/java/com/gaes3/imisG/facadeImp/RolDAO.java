package com.gaes3.imisG.facadeImp;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Rol;

public class RolDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();


/*		EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
		//GUARDAR ROL
		public void guardar(Rol rol) {
			entity.getTransaction().begin();
			entity.persist(rol);
			entity.getTransaction().commit();
			///JPAUtil.shutdown();

		}
		//EDITAR ROL
		public void editar(Rol rol) {
			entity.getTransaction().begin();
			entity.merge(rol);
			entity.getTransaction().commit();
			//JPAUtil.shutdown();
		
		*///BUSCAR ROL
		public Rol buscar(long id) {
		Rol r = new Rol();
		r = entity.find(Rol.class, id);
		//JPAUtil.shutdown();
		return r;
				
		
		}/*
		//ELIMINAR ROL
		public void eliminar(long id) {
			Rol r = new Rol();
			r = entity.find(Rol.class, id);
			System.out.println("DaoEliminar");
			entity.getTransaction().begin();
			entity.remove(r);
			entity.getTransaction().commit();
			
		}*/
		//LISTAR ROL
		public List<Rol> obtenerRoles(){
			List<Rol> listaRoles = new ArrayList<>();
			Query q= entity.createQuery("SELECT r FROM Rol r ");
			listaRoles= q.getResultList();
			return listaRoles;
		}

		
	}



