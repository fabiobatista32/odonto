package br.com.softodonto.modelo;

import javax.persistence.*;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario{

	@Id
	@SequenceGenerator(name="usuario_seq", sequenceName = "s_usuario")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="usuario_seq")
	@Column(name="id_usuario")
	private int idUsuario;

	private int ativo;

	private String login;

	private String senha;

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Pessoa
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getAtivo() {
		return this.ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
	
	

}