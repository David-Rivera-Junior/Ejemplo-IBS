package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProducto;

	private String codigoProducto;

	private String estado;

	private BigInteger existencia;

	private Timestamp fechaIngreso;

	private Timestamp fechaModificacion;

	private String nombreProducto;

	private float precioCompra;

	private float precioVenta;

	private String presentacion;

	//bi-directional many-to-one association to Comprasproducto
	@OneToMany(mappedBy="productos", fetch=FetchType.EAGER)
	private Set<Comprasproducto> comprasproductos;

	//bi-directional many-to-one association to Inventariosproducto
	@OneToMany(mappedBy="productos", fetch=FetchType.EAGER)
	private Set<Inventariosproducto> inventariosproductos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categorias;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="idMarca")
	private Marca marcas;

	//bi-directional many-to-one association to Ventasproducto
	@OneToMany(mappedBy="productos", fetch=FetchType.EAGER)
	private Set<Ventasproducto> ventasproductos;

	public Producto() {
	}

	public Long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigInteger getExistencia() {
		return this.existencia;
	}

	public void setExistencia(BigInteger existencia) {
		this.existencia = existencia;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Set<Comprasproducto> getComprasproductos() {
		return this.comprasproductos;
	}

	public void setComprasproductos(Set<Comprasproducto> comprasproductos) {
		this.comprasproductos = comprasproductos;
	}

	public Comprasproducto addComprasproducto(Comprasproducto comprasproducto) {
		getComprasproductos().add(comprasproducto);
		comprasproducto.setProductos(this);

		return comprasproducto;
	}

	public Comprasproducto removeComprasproducto(Comprasproducto comprasproducto) {
		getComprasproductos().remove(comprasproducto);
		comprasproducto.setProductos(null);

		return comprasproducto;
	}

	public Set<Inventariosproducto> getInventariosproductos() {
		return this.inventariosproductos;
	}

	public void setInventariosproductos(Set<Inventariosproducto> inventariosproductos) {
		this.inventariosproductos = inventariosproductos;
	}

	public Inventariosproducto addInventariosproducto(Inventariosproducto inventariosproducto) {
		getInventariosproductos().add(inventariosproducto);
		inventariosproducto.setProductos(this);

		return inventariosproducto;
	}

	public Inventariosproducto removeInventariosproducto(Inventariosproducto inventariosproducto) {
		getInventariosproductos().remove(inventariosproducto);
		inventariosproducto.setProductos(null);

		return inventariosproducto;
	}

	public Categoria getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	public Marca getMarcas() {
		return this.marcas;
	}

	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}

	public Set<Ventasproducto> getVentasproductos() {
		return this.ventasproductos;
	}

	public void setVentasproductos(Set<Ventasproducto> ventasproductos) {
		this.ventasproductos = ventasproductos;
	}

	public Ventasproducto addVentasproducto(Ventasproducto ventasproducto) {
		getVentasproductos().add(ventasproducto);
		ventasproducto.setProductos(this);

		return ventasproducto;
	}

	public Ventasproducto removeVentasproducto(Ventasproducto ventasproducto) {
		getVentasproductos().remove(ventasproducto);
		ventasproducto.setProductos(null);

		return ventasproducto;
	}

}