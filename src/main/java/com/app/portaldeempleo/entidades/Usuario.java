package com.app.portaldeempleo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O la estrategia correspondiente
	private Integer id;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;
	
	private String apellido;

	private String password;

	private String telefono;
	
	private String pais;
	
	private String ciudad;
	
	@Column(columnDefinition = "TEXT", name="acerca_mi")
	private String acercaMi;
	
	@Column(name="anios_experiencia")
	private String aniosExperiencia;
	
	@Column(columnDefinition = "TEXT", name="experiencia_laboral")
	private String experienciaLaboral;
	
	private String habilidades;
	  

	//bi-directional many-to-one association to Postulante
	@OneToMany(mappedBy="usuario")
	private List<Postulante> postulantes;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public Usuario() {
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAcercaMi() {
	    return acercaMi;
	}

	public void setAcercaMi(String acercaMi) {
	    this.acercaMi = acercaMi;
	}

	public String getExperienciaLaboral() {
	    return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
	    this.experienciaLaboral = experienciaLaboral;
	}
	
	public String getAniosExperiencia() {
	    return aniosExperiencia;
	}

	public void setAniosExperiencia(String aniosExperiencia) {
	    this.aniosExperiencia = aniosExperiencia;
	}
	
	public String getHabilidades() {
	    return habilidades;
	}
	    
	public void setHabilidades(String habilidades) {
	    this.habilidades = habilidades;
	}
	
	public List<Postulante> getPostulantes() {
		return this.postulantes;
	}

	public void setPostulantes(List<Postulante> postulantes) {
		this.postulantes = postulantes;
	}

	public Postulante addPostulante(Postulante postulante) {
		getPostulantes().add(postulante);
		postulante.setUsuario(this);

		return postulante;
	}

	public Postulante removePostulante(Postulante postulante) {
		getPostulantes().remove(postulante);
		postulante.setUsuario(null);

		return postulante;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}