package com.gaes3.imisG.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gaes3.imisG.facadeImp.CategoriaproductoDAO;
import com.gaes3.imisG.facadeImp.ProductoDAO;


@Entity
@Table(name="categoriaproducto")
public class Categoriaproducto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Categoriaproductos;
	private String nom_categoria;
	//@OneToMany(mappedBy="categoriaproducto",fetch=FetchType.LAZY)
		//private List<Producto> producto;
	
	public void setId_Categoriaproductos(long id_Categoriaproductos) {
		this.id_Categoriaproductos = id_Categoriaproductos;
	}
	public void setNom_categoria(String nom_categoria) {
		this.nom_categoria = nom_categoria;
	}
	public String getNom_categoria() {
		return nom_categoria;
	}
	public long getId_Categoriaproductos() {
		return id_Categoriaproductos;
	}
	
	@Override
	public String toString() {
		return nom_categoria
				;
	}
	
	

}

