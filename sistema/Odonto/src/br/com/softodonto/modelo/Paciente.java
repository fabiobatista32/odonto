package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@Table(name="paciente")
public class Paciente{

	@Id
	@SequenceGenerator(name="paciente_seq", sequenceName = "s_paciente")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="paciente_seq")
	@Column(name="id_paciente")
	private long idPaciente;

	private String observacao;

	private String referencia;

	private String reponsavel;

	//bi-directional many-to-one association to AnamneseResposta
	@OneToMany(mappedBy="paciente")
	private List<AnamneseResposta> anamneseRespostas;

	//bi-directional many-to-one association to Odontograma
	@OneToMany(mappedBy="paciente")
	private List<Odontograma> odontogramas;

	//bi-directional many-to-one association to Pessoa
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Paciente() {
	}

	public long getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getReponsavel() {
		return this.reponsavel;
	}

	public void setReponsavel(String reponsavel) {
		this.reponsavel = reponsavel;
	}

	public List<AnamneseResposta> getAnamneseRespostas() {
		return this.anamneseRespostas;
	}

	public void setAnamneseRespostas(List<AnamneseResposta> anamneseRespostas) {
		this.anamneseRespostas = anamneseRespostas;
	}

	public AnamneseResposta addAnamneseResposta(AnamneseResposta anamneseResposta) {
		getAnamneseRespostas().add(anamneseResposta);
		anamneseResposta.setPaciente(this);

		return anamneseResposta;
	}

	public AnamneseResposta removeAnamneseResposta(AnamneseResposta anamneseResposta) {
		getAnamneseRespostas().remove(anamneseResposta);
		anamneseResposta.setPaciente(null);

		return anamneseResposta;
	}

	public List<Odontograma> getOdontogramas() {
		return this.odontogramas;
	}

	public void setOdontogramas(List<Odontograma> odontogramas) {
		this.odontogramas = odontogramas;
	}

	public Odontograma addOdontograma(Odontograma odontograma) {
		getOdontogramas().add(odontograma);
		odontograma.setPaciente(this);

		return odontograma;
	}

	public Odontograma removeOdontograma(Odontograma odontograma) {
		getOdontogramas().remove(odontograma);
		odontograma.setPaciente(null);

		return odontograma;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}