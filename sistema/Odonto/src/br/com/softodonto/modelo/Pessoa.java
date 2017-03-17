package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
public class Pessoa{

	@Id
	@SequenceGenerator(name="pessoa_seq", sequenceName = "s_pessoa")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pessoa_seq")
	@Column(name="id_pessoa")
	private Long idPessoa;

	private String bairro;

	private String cidade;

	private String complemento;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_exp")
	private Date dtExp;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nasc")
	private Date dtNasc;

	private String email;

	private String estado;

	private String logradouro;

	private String nome;

	private String numero;

	@Column(name="org_exp")
	private String orgExp;

	private String rg;

	private String sexo;

	//bi-directional many-to-one association to Dentista
	@OneToOne(mappedBy="pessoa")
	private Dentista dentista;

	//bi-directional many-to-one association to Paciente
	@OneToOne(mappedBy="pessoa")
	private Paciente paciente;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="pessoa")
	private List<Telefone> telefones;

	//bi-directional many-to-one association to Usuario
	@OneToOne(mappedBy="pessoa")
	private Usuario usuario;

	public Pessoa() {
	}

	public long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtExp() {
		return this.dtExp;
	}

	public void setDtExp(Date dtExp) {
		this.dtExp = dtExp;
	}

	public Date getDtNasc() {
		return this.dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrgExp() {
		return this.orgExp;
	}

	public void setOrgExp(String orgExp) {
		this.orgExp = orgExp;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Dentista getDentista() {
		return this.dentista;
	}

	public void setDentistas(Dentista dentista) {
		this.dentista = dentista;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setPessoa(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setPessoa(null);

		return telefone;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuarios(Usuario usuario) {
		this.usuario = usuario;
	}

}