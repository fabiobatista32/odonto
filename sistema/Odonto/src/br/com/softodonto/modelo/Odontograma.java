package br.com.softodonto.modelo;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the odontogramas database table.
 * 
 */
@Entity
@Table(name="odontogramas")
public class Odontograma{

	@Id
	@SequenceGenerator(name="odontograma_seq", sequenceName = "s_odontogramas")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="odontograma_seq")
	@Column(name="id_odontograma")
	private long idOdontograma;

	private Date data;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to OdontogramaAspecto
	@OneToMany(mappedBy="odontograma")
	private List<OdontogramaAspecto> odontogramaAspectos;

	//bi-directional many-to-one association to OdontogramaDente
	@OneToMany(mappedBy="odontograma")
	private List<OdontogramaDente> odontogramaDentes;

	//bi-directional many-to-one association to Paciente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente paciente;

	public Odontograma() {
	}

	public long getIdOdontograma() {
		return this.idOdontograma;
	}

	public void setIdOdontograma(long idOdontograma) {
		this.idOdontograma = idOdontograma;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<OdontogramaAspecto> getOdontogramaAspectos() {
		return this.odontogramaAspectos;
	}

	public void setOdontogramaAspectos(List<OdontogramaAspecto> odontogramaAspectos) {
		this.odontogramaAspectos = odontogramaAspectos;
	}

	public OdontogramaAspecto addOdontogramaAspecto(OdontogramaAspecto odontogramaAspecto) {
		getOdontogramaAspectos().add(odontogramaAspecto);
		odontogramaAspecto.setOdontograma(this);

		return odontogramaAspecto;
	}

	public OdontogramaAspecto removeOdontogramaAspecto(OdontogramaAspecto odontogramaAspecto) {
		getOdontogramaAspectos().remove(odontogramaAspecto);
		odontogramaAspecto.setOdontograma(null);

		return odontogramaAspecto;
	}

	public List<OdontogramaDente> getOdontogramaDentes() {
		return this.odontogramaDentes;
	}

	public void setOdontogramaDentes(List<OdontogramaDente> odontogramaDentes) {
		this.odontogramaDentes = odontogramaDentes;
	}

	public OdontogramaDente addOdontogramaDente(OdontogramaDente odontogramaDente) {
		getOdontogramaDentes().add(odontogramaDente);
		odontogramaDente.setOdontograma(this);

		return odontogramaDente;
	}

	public OdontogramaDente removeOdontogramaDente(OdontogramaDente odontogramaDente) {
		getOdontogramaDentes().remove(odontogramaDente);
		odontogramaDente.setOdontograma(null);

		return odontogramaDente;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}