package br.com.softodonto.modelo;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the odontograma_dentes database table.
 * 
 */
@Entity
@Table(name="odontograma_dentes")
public class OdontogramaDente{

	@Id
	@SequenceGenerator(name="odontograma_dentes_seq", sequenceName = "s_odontograma_dentes")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="odontograma_dentes_seq")
	@Column(name="id_odontograma_dente")
	private Long idOdontogramaDente;

	private int dente;

	private int face;

	//bi-directional many-to-one association to Odontograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_odontograma")
	private Odontograma odontograma;

	//bi-directional many-to-one association to ProcedimentoDente
	@OneToMany(mappedBy="odontogramaDente")
	private List<ProcedimentoDente> procedimentoDentes;

	public OdontogramaDente() {
	}

	public long getIdOdontogramaDente() {
		return this.idOdontogramaDente;
	}

	public void setIdOdontogramaDente(long idOdontogramaDente) {
		this.idOdontogramaDente = idOdontogramaDente;
	}

	public int getDente() {
		return this.dente;
	}

	public void setDente(int dente) {
		this.dente = dente;
	}

	public int getFace() {
		return this.face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public Odontograma getOdontograma() {
		return this.odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

	public List<ProcedimentoDente> getProcedimentoDentes() {
		return this.procedimentoDentes;
	}

	public void setProcedimentoDentes(List<ProcedimentoDente> procedimentoDentes) {
		this.procedimentoDentes = procedimentoDentes;
	}

	public ProcedimentoDente addProcedimentoDente(ProcedimentoDente procedimentoDente) {
		getProcedimentoDentes().add(procedimentoDente);
		procedimentoDente.setOdontogramaDente(this);

		return procedimentoDente;
	}

	public ProcedimentoDente removeProcedimentoDente(ProcedimentoDente procedimentoDente) {
		getProcedimentoDentes().remove(procedimentoDente);
		procedimentoDente.setOdontogramaDente(null);

		return procedimentoDente;
	}

}