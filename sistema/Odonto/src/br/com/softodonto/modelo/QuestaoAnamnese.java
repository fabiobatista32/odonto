package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the questao_anamnese database table.
 * 
 */
@Entity
@Table(name="questao_anamnese")
public class QuestaoAnamnese{

	@Id
	@SequenceGenerator(name="questao_anamnese_seq", sequenceName = "s_questao_anamnese")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="questao_anamnese_seq")
	@Column(name="id_questao_anamnese")
	private int idQuestaoAnamnese;

	private String descricao;

	private int obrigatoria;

	private String pergunta;

	//bi-directional many-to-one association to AnamneseResposta
	@OneToMany(mappedBy="questaoAnamnese")
	private List<AnamneseResposta> anamneseRespostas;

	public QuestaoAnamnese() {
	}

	public long getIdQuestaoAnamnese() {
		return this.idQuestaoAnamnese;
	}

	public void setIdQuestaoAnamnese(int idQuestaoAnamnese) {
		this.idQuestaoAnamnese = idQuestaoAnamnese;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getObrigatoria() {
		return this.obrigatoria;
	}

	public void setObrigatoria(int obrigatoria) {
		this.obrigatoria = obrigatoria;
	}

	public String getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<AnamneseResposta> getAnamneseRespostas() {
		return this.anamneseRespostas;
	}

	public void setAnamneseRespostas(List<AnamneseResposta> anamneseRespostas) {
		this.anamneseRespostas = anamneseRespostas;
	}

	public AnamneseResposta addAnamneseResposta(AnamneseResposta anamneseResposta) {
		getAnamneseRespostas().add(anamneseResposta);
		anamneseResposta.setQuestaoAnamnese(this);

		return anamneseResposta;
	}

	public AnamneseResposta removeAnamneseResposta(AnamneseResposta anamneseResposta) {
		getAnamneseRespostas().remove(anamneseResposta);
		anamneseResposta.setQuestaoAnamnese(null);

		return anamneseResposta;
	}

}