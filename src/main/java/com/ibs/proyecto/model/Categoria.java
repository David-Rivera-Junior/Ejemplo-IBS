package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoria;

	private String codigoCategoria;

	private String nombreCategoria;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categorias", fetch=FetchType.EAGER)
	private Set<Producto> productos;

	public Categoria() {
	}

	public Categoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Long getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCategorias(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCategorias(null);

		return producto;
	}

}