package co.edu.unbosque.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AGENTES")
public class Agente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date f_nacimiento;
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	@Column(name = "fecha_entrada_institucion", nullable = false)
	private Date e_institucion;
	
	@Column(name = "rango", nullable = false)
	private String rango;
	
	@Column(name = "#_casos", nullable = false)
	private int casos;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getF_nacimiento() {
		return f_nacimiento;
	}
	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getE_institucion() {
		return e_institucion;
	}
	public void setE_institucion(Date e_institucion) {
		this.e_institucion = e_institucion;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public int getCasos() {
		return casos;
	}
	public void setCasos(int casos) {
		this.casos = casos;
	}
	
	
	
}
