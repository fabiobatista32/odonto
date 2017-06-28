package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the especialidade database table.
 * 
 */
@Entity
@Table(name="especialidade")
public class Especialidade{

	@Id
	@SequenceGenerator(name="especialidade_seq", sequenceName = "s_especialidade")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="especialidade_seq")
	@Column(name="id_especialidade")
	private int idEspecialidade;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Procedimento
	@OneToMany(mappedBy="especialidade")
	private List<Procedimento> procedimentos;

	public Especialidade() {
	}

	public long getIdEspecialidade() {
		return this.idEspecialidade;
	}

	public void setIdEspecialidade(int idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
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

	public List<Procedimento> getProcedimentos() {
		return this.procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Procedimento addProcedimento(Procedimento procedimento) {
		getProcedimentos().add(procedimento);
		procedimento.setEspecialidade(this);

		return procedimento;
	}

	public Procedimento removeProcedimento(Procedimento procedimento) {
		getProcedimentos().remove(procedimento);
		procedimento.setEspecialidade(null);

		return procedimento;
	}

}