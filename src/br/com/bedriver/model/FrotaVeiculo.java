package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the frota_veiculo database table.
 * 
 */
@Entity
@Table(name="frota_veiculo")
@NamedQuery(name="FrotaVeiculo.findAll", query="SELECT f FROM FrotaVeiculo f")
public class FrotaVeiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="qtd_veiculos")
	private Integer qtdVeiculos;

	private String veiculo;

	//bi-directional one-to-one association to Estado
	@OneToOne(mappedBy="frotaVeiculo")
	private Estado estado;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;

	public FrotaVeiculo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdVeiculos() {
		return this.qtdVeiculos;
	}

	public void setQtdVeiculos(Integer qtdVeiculos) {
		this.qtdVeiculos = qtdVeiculos;
	}

	public String getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((qtdVeiculos == null) ? 0 : qtdVeiculos.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		FrotaVeiculo other = (FrotaVeiculo) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (qtdVeiculos == null) {
			if (other.qtdVeiculos != null)
				return false;
		} else if (!qtdVeiculos.equals(other.qtdVeiculos))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

}