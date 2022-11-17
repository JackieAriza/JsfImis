package com.gaes3.imisG.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gaes3.imisG.modelo.JPAUtil;
import com.gaes3.imisG.modelo.Tipo_Documento;



public class Tipo_DocumentoDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

	//LISTAR CLIENTES
	public List<Tipo_Documento> obtenerDocumentos() {
		List<Tipo_Documento> listaDocumentos = new ArrayList<>();
		Query q= entity.createQuery("SELECT t FROM Tipo_Documento t");
		listaDocumentos= q.getResultList();
		return listaDocumentos;
	}


}
