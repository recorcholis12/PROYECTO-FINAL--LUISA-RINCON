package co.edu.unbosque.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ATAQUES")
public class Ataque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "empresa", nullable = false, unique = true)
	private String empresa;
	
	@Column(name = "duracion_ataque", nullable = false)
	private int tiempo;
	
	@Column(name = "#_personas_afectadas", nullable = false)
	private int p_afectadas;
	
	@Column(name = "fecha_ataque", nullable = false)
	private Date fecha;
	
	@Column(name = "barrio", nullable = false)
	private String lugar;
	
	@Column(name = "agente1", nullable = true)
	private String agentes1;
	
	@Column(name = "agente2", nullable = true)
	private String agentes2;
	
	@Column(name = "agente3", nullable = true)
	private String agentes3;
	
	@Column(name = "agente4", nullable = true)
	private String agentes4;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getP_afectadas() {
		return p_afectadas;
	}
	public void setP_afectadas(int p_afectadas) {
		this.p_afectadas = p_afectadas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getAgentes1() {
		return agentes1;
	}
	public void setAgentes1(String agentes1) {
		this.agentes1 = agentes1;
	}
	public String getAgentes2() {
		return agentes2;
	}
	public void setAgentes2(String agentes2) {
		this.agentes2 = agentes2;
	}
	public String getAgentes3() {
		return agentes3;
	}
	public void setAgentes3(String agentes3) {
		this.agentes3 = agentes3;
	}
	public String getAgentes4() {
		return agentes4;
	}
	public void setAgentes4(String agentes4) {
		this.agentes4 = agentes4;
	}
		
	
}
