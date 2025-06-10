package com.app.portaldeempleo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the postulantes database table.
 * 
 */
@Entity
@Table(name="postulantes")
@NamedQuery(name="Postulante.findAll", query="SELECT p FROM Postulante p")
public class Postulante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="curriculum_vitae")
	private String curriculumVitae;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	private String mensaje;

	@Column(name="salario_propuesto")
	private String salarioPropuesto;

	//bi-directional many-to-one association to EstatusPuestoTrabajo
	@ManyToOne
	@JoinColumn(name="estatus_puesto_trabajo_id")
	private EstatusPuestoTrabajo estatusPuestoTrabajo;

	//bi-directional many-to-one association to PuestoTrabajo
	@ManyToOne
	@JoinColumn(name="id_puesto_trabajo")
	private PuestoTrabajo puestoTrabajo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Postulante() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurriculumVitae() {
		return this.curriculumVitae;
	}

	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getSalarioPropuesto() {
		return this.salarioPropuesto;
	}

	public void setSalarioPropuesto(String salarioPropuesto) {
		this.salarioPropuesto = salarioPropuesto;
	}

	public EstatusPuestoTrabajo getEstatusPuestoTrabajo() {
		return this.estatusPuestoTrabajo;
	}

	public void setEstatusPuestoTrabajo(EstatusPuestoTrabajo estatusPuestoTrabajo) {
		this.estatusPuestoTrabajo = estatusPuestoTrabajo;
	}

	public PuestoTrabajo getPuestoTrabajo() {
		return this.puestoTrabajo;
	}

	public void setPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}