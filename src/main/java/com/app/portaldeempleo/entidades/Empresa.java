package com.app.portaldeempleo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	private String telefono;

	//bi-directional many-to-one association to PuestoTrabajo
	@OneToMany(mappedBy="empresa")
	private List<PuestoTrabajo> puestoTrabajos;

	public Empresa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<PuestoTrabajo> getPuestoTrabajos() {
		return this.puestoTrabajos;
	}

	public void setPuestoTrabajos(List<PuestoTrabajo> puestoTrabajos) {
		this.puestoTrabajos = puestoTrabajos;
	}

	public PuestoTrabajo addPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		getPuestoTrabajos().add(puestoTrabajo);
		puestoTrabajo.setEmpresa(this);

		return puestoTrabajo;
	}

	public PuestoTrabajo removePuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		getPuestoTrabajos().remove(puestoTrabajo);
		puestoTrabajo.setEmpresa(null);

		return puestoTrabajo;
	}

}