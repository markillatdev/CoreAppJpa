package com.app.portaldeempleo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estatus_puesto_trabajo database table.
 * 
 */
@Entity
@Table(name="estatus_puesto_trabajo")
@NamedQuery(name="EstatusPuestoTrabajo.findAll", query="SELECT e FROM EstatusPuestoTrabajo e")
public class EstatusPuestoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Postulante
	@OneToMany(mappedBy="estatusPuestoTrabajo")
	private List<Postulante> postulantes;

	public EstatusPuestoTrabajo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Postulante> getPostulantes() {
		return this.postulantes;
	}

	public void setPostulantes(List<Postulante> postulantes) {
		this.postulantes = postulantes;
	}

	public Postulante addPostulante(Postulante postulante) {
		getPostulantes().add(postulante);
		postulante.setEstatusPuestoTrabajo(this);

		return postulante;
	}

	public Postulante removePostulante(Postulante postulante) {
		getPostulantes().remove(postulante);
		postulante.setEstatusPuestoTrabajo(null);

		return postulante;
	}

}