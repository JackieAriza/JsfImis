package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Rol;
import com.gaes3.imisG.modelo.Usuario;

public class UsuarioDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	private List<Usuario> listaUsuarios;

	
	

	/* guardar usuario */
	public void guardar(Usuario Usuario) {
		entity.getTransaction().begin();
		entity.persist(Usuario);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// editar usuario
	public void editar(Usuario Usuario) {
		entity.getTransaction().begin();
		entity.merge(Usuario);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// buscar usuario
	public Usuario buscar(long id_usuario) {
		Usuario c = new Usuario();
		c = entity.find(Usuario.class, id_usuario);
		// JPAUtil.shutdown();
		return c;
	}

	// eliminar un usuario
	public void eliminar(long id_usuario) {
		Usuario c = new Usuario();
		c = entity.find(Usuario.class, id_usuario);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los cliente
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Usuario c");
		listaUsuarios = q.getResultList();
		return listaUsuarios;
	}
	
	public String validarUsuario(Usuario usuario) {
		String roles="none";
		try{
			this.entity.getTransaction().begin();
			Query q = this.entity.createQuery("SELECT u FROM Usuario u WHERE u.passUsuario='"+usuario.getPassUsuario()+"' AND u.emailUsuario='"+usuario.getEmailUsuario()+"'");
			this.listaUsuarios=q.getResultList();
			for(Usuario us: this.listaUsuarios) {
				RolDAO rolDAO = new RolDAO();
				Rol rol = new Rol();
				rol=rolDAO.buscar(us.getRol().getIdRol());
				System.out.println("nombre rol" + rol.getNombreRol());
				roles=rol.getNombreRol();
				
			}
			this.entity.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.entity.clear();
			
		}
		
		return roles;}
}
