package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the dentista database table.
 * 
 */
@Entity
@Table(name="dentista")
public class Dentista{

	@Id
	@SequenceGenerator(name="dentista_seq", sequenceName = "s_dentista")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="dentista_seq")
	@Column(name="id_dentista")
	private int idDentista;

	private int cro;

	private String especialidade;

	private String observacao;

	//bi-directional many-to-one association to Pessoa
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Procedimento
	@OneToMany(mappedBy="dentista")
	private List<Procedimento> procedimentos;

	public Dentista() {
	}

	public long getIdDentista() {
		return this.idDentista;
	}

	public void setIdDentista(int idDentista) {
		this.idDentista = idDentista;
	}

	public int getCro() {
		return this.cro;
	}

	public void setCro(int cro) {
		this.cro = cro;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Procedimento> getProcedimentos() {
		return this.procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Procedimento addProcedimento(Procedimento procedimento) {
		getProcedimentos().add(procedimento);
		procedimento.setDentista(this);

		return procedimento;
	}

	public Procedimento removeProcedimento(Procedimento procedimento) {
		getProcedimentos().remove(procedimento);
		procedimento.setDentista(null);

		return procedimento;
	}

}