package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the procedimento database table.
 * 
 */
@Entity
@Table(name="procedimento")
public class Procedimento{

	@Id
	@SequenceGenerator(name="procedimento_seq", sequenceName = "s_procedimento")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="procedimento_seq")
	@Column(name="id_procedimento")
	private Long idProcedimento;

	private String descricao;

	@Column(name="dt_inicio_tratamento")
	private Date dtInicioTratamento;

	@Column(name="dt_retorno")
	private Date dtRetorno;

	@Column(name="dt_termino_tratamento")
	private Date dtTerminoTratamento;

	private String nome;

	private float valor;

	//bi-directional many-to-one association to Dentista
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dentista")
	private Dentista dentista;

	//bi-directional many-to-one association to Especialidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_especialidade")
	private Especialidade especialidade;

	//bi-directional many-to-one association to ProcedimentoDente
	@OneToMany(mappedBy="procedimento")
	private List<ProcedimentoDente> procedimentoDentes;

	public Procedimento() {
	}

	public long getIdProcedimento() {
		return this.idProcedimento;
	}

	public void setIdProcedimento(long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtInicioTratamento() {
		return this.dtInicioTratamento;
	}

	public void setDtInicioTratamento(Date dtInicioTratamento) {
		this.dtInicioTratamento = dtInicioTratamento;
	}

	public Date getDtRetorno() {
		return this.dtRetorno;
	}

	public void setDtRetorno(Date dtRetorno) {
		this.dtRetorno = dtRetorno;
	}

	public Date getDtTerminoTratamento() {
		return this.dtTerminoTratamento;
	}

	public void setDtTerminoTratamento(Date dtTerminoTratamento) {
		this.dtTerminoTratamento = dtTerminoTratamento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Dentista getDentista() {
		return this.dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public List<ProcedimentoDente> getProcedimentoDentes() {
		return this.procedimentoDentes;
	}

	public void setProcedimentoDentes(List<ProcedimentoDente> procedimentoDentes) {
		this.procedimentoDentes = procedimentoDentes;
	}

	public ProcedimentoDente addProcedimentoDente(ProcedimentoDente procedimentoDente) {
		getProcedimentoDentes().add(procedimentoDente);
		procedimentoDente.setProcedimento(this);

		return procedimentoDente;
	}

	public ProcedimentoDente removeProcedimentoDente(ProcedimentoDente procedimentoDente) {
		getProcedimentoDentes().remove(procedimentoDente);
		procedimentoDente.setProcedimento(null);

		return procedimentoDente;
	}

}