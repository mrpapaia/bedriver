package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidades database table.
 * 
 */
@Entity
@Table(name="cidades")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to FrotaVeiculo
	@OneToMany(mappedBy="cidade")
	private List<FrotaVeiculo> frotaVeiculos;

	public Cidade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<FrotaVeiculo> getFrotaVeiculos() {
		return this.frotaVeiculos;
	}

	public void setFrotaVeiculos(List<FrotaVeiculo> frotaVeiculos) {
		this.frotaVeiculos = frotaVeiculos;
	}

	public FrotaVeiculo addFrotaVeiculo(FrotaVeiculo frotaVeiculo) {
		getFrotaVeiculos().add(frotaVeiculo);
		frotaVeiculo.setCidade(this);

		return frotaVeiculo;
	}

	public FrotaVeiculo removeFrotaVeiculo(FrotaVeiculo frotaVeiculo) {
		getFrotaVeiculos().remove(frotaVeiculo);
		frotaVeiculo.setCidade(null);

		return frotaVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((frotaVeiculos == null) ? 0 : frotaVeiculos.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (frotaVeiculos == null) {
			if (other.frotaVeiculos != null)
				return false;
		} else if (!frotaVeiculos.equals(other.frotaVeiculos))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}