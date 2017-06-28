package br.com.softodonto.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.softodonto.dao.GenericDao;
import br.com.softodonto.modelo.Paciente;
import br.com.softodonto.modelo.Perfil;
import br.com.softodonto.modelo.Usuario;
import br.com.softodonto.util.FacesUtil;
import br.com.softodonto.util.MessageUtil;

@SessionScoped
@ManagedBean
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> listUsuario;
	private Usuario usuario;
	private boolean cadastra;
	private boolean edita;
	private List<Perfil> listPerfil;
	
	public UsuarioBean() {
		super();
		this.listUsuario = (List<Usuario>) new GenericDao().findAll(Usuario.class);
		this.listPerfil = (List<Perfil>) new GenericDao().findAll(Perfil.class);
		this.cadastra = false;
		this.edita = false;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isCadastra() {
		return cadastra;
	}

	public void setCadastra(boolean cadastra) {
		this.cadastra = cadastra;
	}

	public boolean isEdita() {
		return edita;
	}

	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	
	public List<Perfil> getListPerfil() {
		return listPerfil;
	}

	public void setListPerfil(List<Perfil> listPerfil) {
		this.listPerfil = listPerfil;
	}

	public void antesCadastrarUsuario() {
		this.cadastra = true;
		this.edita = false;
		this.usuario = new Usuario();
		FacesUtil.redireciona("/pages/restrict/form_usuario.jsf");
	}

	public void antesEditarUsuario(Usuario u) {
		this.usuario = u;
		this.edita = true;
		this.cadastra = false;
		FacesUtil.redireciona("pages/resctrict/form_usuario.jsf");
	}

	public void cadastraUsuario(){
		GenericDao dao = new GenericDao();
		try {
			dao.save(this.usuario);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("usuario.cadastra.erro"));
			e.printStackTrace();
			return;
		}
		FacesUtil.redireciona("/pages/restrict/list_usuario.jsf");
	}
	
	public void editaUsuario(){
		GenericDao dao = new GenericDao();
		try {
			dao.update(this.usuario);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("usuario.edita.erro"));
			e.printStackTrace();
			return;
		}
		FacesUtil.redireciona("/pages/restrict/list_usuario.jsf");
	}

	public void deletaUsuario(Paciente p) {
		GenericDao dao = new GenericDao();
		try {
			dao.delete(p);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("usuario.delete.erro"));
			e.printStackTrace();
		}
		FacesUtil.redireciona("/pages/restrict/list_usuario.jsf");
	}

}
