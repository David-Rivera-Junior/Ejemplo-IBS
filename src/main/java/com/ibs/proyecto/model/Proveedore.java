package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the proveedores database table.
 * 
 */
@Entity
@Table(name="proveedores")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProveedor;

	private String apellidoProveedor;

	private String correoProveedor;

	private String direccionProveedor;

	private String duiProveedor;

	private String nombreProveedor;

	private String telefonoProveedor;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="proveedores", fetch=FetchType.EAGER)
	private Set<Compra> compras;

	public Proveedore() {
	}

	public Long getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getApellidoProveedor() {
		return this.apellidoProveedor;
	}

	public void setApellidoProveedor(String apellidoProveedor) {
		this.apellidoProveedor = apellidoProveedor;
	}

	public String getCorreoProveedor() {
		return this.correoProveedor;
	}

	public void setCorreoProveedor(String correoProveedor) {
		this.correoProveedor = correoProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getDuiProveedor() {
		return this.duiProveedor;
	}

	public void setDuiProveedor(String duiProveedor) {
		this.duiProveedor = duiProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setProveedores(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setProveedores(null);

		return compra;
	}

}