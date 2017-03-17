package br.com.softodonto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.softodonto.dao.GenericDao;
import br.com.softodonto.modelo.Paciente;
import br.com.softodonto.util.FacesUtil;
import br.com.softodonto.util.MessageUtil;

@SessionScoped
@ManagedBean
public class PacienteBean {
	private List<Paciente> listPaciente;
	private Paciente paciente;
	private boolean cadastra;
	private boolean edita;
	
	public PacienteBean() {
		super();
		this.listPaciente = (List<Paciente>) new GenericDao().findAll(Paciente.class);
		this.cadastra = false;
		this.edita = false;
	}

	public List<Paciente> getListPaciente() {
		return listPaciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public boolean isCadastra() {
		return cadastra;
	}

	public boolean isEdita() {
		return edita;
	}
	
	public void antesCadastrarPaciente() {
		this.cadastra = true;
		this.edita = false;
		this.paciente = new Paciente();
		FacesUtil.redireciona("/pages/restrict/form_paciente.jsf");
	}

	public void antesEditarPaciente(Paciente p) {
		this.paciente = p;
		this.edita = true;
		this.cadastra = false;
		FacesUtil.redireciona("/pages/resctrict/form_paciente.jsf");
	}

	public void cadastraPaciente(){
		GenericDao dao = new GenericDao();
		try {
			dao.save(this.paciente);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("paciente.cadastra.erro"));
			e.printStackTrace();
			return;
		}
		FacesUtil.redireciona("/pages/restrict/list_paciente.jsf");
	}
	
	public void editaPaciente(){
		GenericDao dao = new GenericDao();
		try {
			dao.update(this.paciente);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("paciente.edita.erro"));
			e.printStackTrace();
			return;
		}
		FacesUtil.redireciona("/pages/restrict/list_paciente.jsf");
	}

	public void deletaPaciente(Paciente p) {
		GenericDao dao = new GenericDao();
		try {
			dao.delete(p);
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(MessageUtil.msgs().getString("paciente.delete.erro"));
			e.printStackTrace();
		}
		FacesUtil.redireciona("/pages/restrict/list_paciente.jsf");
	}

}
