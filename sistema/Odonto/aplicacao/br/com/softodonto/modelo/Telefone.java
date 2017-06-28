package br.com.softodonto.modelo;

import javax.persistence.*;

/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="telefone")
public class Telefone{

	@Id
	@SequenceGenerator(name="telefone_seq", sequenceName = "s_telefone")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="telefone_seq")
	@Column(name="id_telefone")
	private int idTelefone;

	private int ddd;

	private String numero;

	private int tipo;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Telefone() {
	}

	public long getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getDdd() {
		return this.ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}