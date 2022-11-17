package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.Categoriaproducto;
import com.gaes3.imisG.modelo.JPAUtil;

public class CategoriaproductoDAO {
EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
//guardar categoria producto//
public void guardar(Categoriaproducto categoriaproducto) {
	entity.getTransaction().begin();
	entity.persist(categoriaproducto);
	entity.getTransaction().commit();
	//JPAUtil.shutdown();
	
}
//editar catgeoria producto//
public void editar(Categoriaproducto categoriaproducto) {
	entity.getTransaction().begin();
	entity.merge(categoriaproducto);
	entity.getTransaction().commit();
	//JPAUtil.shutdown();
	
}

//Eliminar categoria producto
public void eliminar(Long id) {
	entity.getTransaction().begin();
	Categoriaproducto c= new Categoriaproducto();
	c=entity.find(Categoriaproducto.class, id);
	entity.remove(c);
	entity.getTransaction().commit();
	//JPAUtil.shoutdown
}

//buscar categoria producto//

public Categoriaproducto buscar(long id) {
	
	Categoriaproducto c= new Categoriaproducto();
	c=entity.find(Categoriaproducto.class, id);
	//JPAUtil.shutdown();
	return c;
	
}
//obtener todos//
public List<Categoriaproducto> obtenerCategoriaproducto(){
	List<Categoriaproducto> listaCategoriaproductos= new ArrayList<>();
	Query q=entity.createQuery("SELECT c FROM Categoriaproducto c");
	listaCategoriaproductos=q.getResultList();
	return listaCategoriaproductos;
	
}

}

