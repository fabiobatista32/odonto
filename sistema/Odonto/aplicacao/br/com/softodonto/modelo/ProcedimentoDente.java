package br.com.softodonto.modelo;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;

/**
 * The persistent class for the procedimento_dente database table.
 * 
 */
@Entity
@Table(name="procedimento_dente")
public class ProcedimentoDente{

	@Id
	@SequenceGenerator(name="procedimento_dente_seq", sequenceName = "s_procedimento_dente")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="procedimento_dente_seq")
	@Column(name="id_procedimento_dente")
	private Long idProcedimentoDente;

	private Date data;

	private String obs;

	private String status;

	private BigDecimal valor;

	//bi-directional many-to-one association to OdontogramaDente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_odontograma_dente")
	private OdontogramaDente odontogramaDente;

	//bi-directional many-to-one association to Procedimento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_procedimento")
	private Procedimento procedimento;

	public ProcedimentoDente() {
	}

	public long getIdProcedimentoDente() {
		return this.idProcedimentoDente;
	}

	public void setIdProcedimentoDente(long idProcedimentoDente) {
		this.idProcedimentoDente = idProcedimentoDente;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public OdontogramaDente getOdontogramaDente() {
		return this.odontogramaDente;
	}

	public void setOdontogramaDente(OdontogramaDente odontogramaDente) {
		this.odontogramaDente = odontogramaDente;
	}

	public Procedimento getProcedimento() {
		return this.procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

}