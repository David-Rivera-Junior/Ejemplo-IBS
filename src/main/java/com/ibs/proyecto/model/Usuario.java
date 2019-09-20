package com.ibs.proyecto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;

	private String apellidosUsuario;

	private String contraseña;

	private String correoUsuario;

	private String direccionUsuario;

	private String duiUsuario;

	private String nombresUsuario;

	private String telefonoUsuario;

	private String usuario;

	//bi-directional many-to-one association to Bitacora
	@OneToMany(mappedBy="usuarios", fetch=FetchType.EAGER)
	private Set<Bitacora> bitacoras;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="usuarios", fetch=FetchType.EAGER)
	private Set<Compra> compras;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idRol")
	private Role roles;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuarios", fetch=FetchType.EAGER)
	private Set<Venta> ventas;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidosUsuario() {
		return this.apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreoUsuario() {
		return this.correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getDireccionUsuario() {
		return this.direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getDuiUsuario() {
		return this.duiUsuario;
	}

	public void setDuiUsuario(String duiUsuario) {
		this.duiUsuario = duiUsuario;
	}

	public String getNombresUsuario() {
		return this.nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<Bitacora> getBitacoras() {
		return this.bitacoras;
	}

	public void setBitacoras(Set<Bitacora> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public Bitacora addBitacora(Bitacora bitacora) {
		getBitacoras().add(bitacora);
		bitacora.setUsuarios(this);

		return bitacora;
	}

	public Bitacora removeBitacora(Bitacora bitacora) {
		getBitacoras().remove(bitacora);
		bitacora.setUsuarios(null);

		return bitacora;
	}

	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setUsuarios(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setUsuarios(null);

		return compra;
	}

	public Role getRoles() {
		return this.roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Set<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setUsuarios(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuarios(null);

		return venta;
	}

}