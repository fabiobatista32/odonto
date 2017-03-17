package br.com.softodonto.modelo;

import javax.persistence.*;

/**
 * The persistent class for the anamnese_resposta database table.
 * 
 */
@Entity
@Table(name="anamnese_resposta")
public class AnamneseResposta{

	@Id
	@SequenceGenerator(name="anamnese_resposta_seq", sequenceName = "s_anamnese_resposta")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="anamnese_resposta_seq")
	@Column(name="id_anamnese_resposta")
	private int idAnamneseResposta;

	@Column(name="codigo_resposta")
	private int codigoResposta;

	private String observacao;

	private String resposta;

	//bi-directional many-to-one association to Paciente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente paciente;

	//bi-directional many-to-one association to QuestaoAnamnese
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_questao_anamnese")
	private QuestaoAnamnese questaoAnamnese;

	public AnamneseResposta() {
	}

	public long getIdAnamneseResposta() {
		return this.idAnamneseResposta;
	}

	public void setIdAnamneseResposta(int idAnamneseResposta) {
		this.idAnamneseResposta = idAnamneseResposta;
	}

	public int getCodigoResposta() {
		return this.codigoResposta;
	}

	public void setCodigoResposta(int codigoResposta) {
		this.codigoResposta = codigoResposta;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public QuestaoAnamnese getQuestaoAnamnese() {
		return this.questaoAnamnese;
	}

	public void setQuestaoAnamnese(QuestaoAnamnese questaoAnamnese) {
		this.questaoAnamnese = questaoAnamnese;
	}

}