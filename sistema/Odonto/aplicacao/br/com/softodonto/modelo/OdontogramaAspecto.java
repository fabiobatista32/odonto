package br.com.softodonto.modelo;

import javax.persistence.*;


/**
 * The persistent class for the odontograma_aspectos database table.
 * 
 */
@Entity
@Table(name="odontograma_aspectos")
public class OdontogramaAspecto{

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int dente;

	private int aspecto;

	//bi-directional many-to-one association to Odontograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_odontograma")
	private Odontograma odontograma;

	public OdontogramaAspecto() {
	}

	public long getDente() {
		return this.dente;
	}

	public void setDente(int dente) {
		this.dente = dente;
	}

	public int getAspecto() {
		return this.aspecto;
	}

	public void setAspecto(int aspecto) {
		this.aspecto = aspecto;
	}

	public Odontograma getOdontograma() {
		return this.odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

}