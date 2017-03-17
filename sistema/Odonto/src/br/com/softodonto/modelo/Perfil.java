package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
public class Perfil{

	@Id
	@SequenceGenerator(name="perfil_seq", sequenceName = "s_perfil")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="perfil_seq")
	@Column(name="id_perfil")
	private long idPerfil;

	private String descricao;

	private String perfil;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}