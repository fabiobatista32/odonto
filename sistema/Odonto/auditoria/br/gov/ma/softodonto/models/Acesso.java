package br.gov.ma.softodonto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "acesso", schema = "auditoria")
public class Acesso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "access_id_seq", sequenceName = "auditoria.access_id_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "access_id_seq")
	@Column(name = "id")
	private Long id;
	
	private String pagina;
	private String ip;
	private Date horario;
	
	public Acesso() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	
}