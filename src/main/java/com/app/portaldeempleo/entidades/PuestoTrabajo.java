package com.app.portaldeempleo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the puesto_trabajo database table.
 * 
 */
@Entity
@Table(name="puesto_trabajo")
@NamedQuery(name="PuestoTrabajo.findAll", query="SELECT p FROM PuestoTrabajo p")
public class PuestoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cierre")
	private Date fechaCierre;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="nombre_puesto")
	private String nombrePuesto;

	private String salario;

	@Column(name="tipo_trabajo")
	private String tipoTrabajo;

	//bi-directional many-to-one association to Postulante
	@OneToMany(mappedBy="puestoTrabajo")
	private List<Postulante> postulantes;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	public PuestoTrabajo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombrePuesto() {
		return this.nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getTipoTrabajo() {
		return this.tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public List<Postulante> getPostulantes() {
		return this.postulantes;
	}

	public void setPostulantes(List<Postulante> postulantes) {
		this.postulantes = postulantes;
	}

	public Postulante addPostulante(Postulante postulante) {
		getPostulantes().add(postulante);
		postulante.setPuestoTrabajo(this);

		return postulante;
	}

	public Postulante removePostulante(Postulante postulante) {
		getPostulantes().remove(postulante);
		postulante.setPuestoTrabajo(null);

		return postulante;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}