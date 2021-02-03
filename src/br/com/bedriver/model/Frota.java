package br.com.bedriver.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "frota_veiculo")
public class Frota implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private Integer qtd_veiculos;
	private String veiculo;
	private Integer id_cidade;
	/*@ElementCollection(targetClass = String.class)
	@JoinTable(name = "cidades", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome",
			}) }, joinColumns = @JoinColumn(name = "id"))
	@Column(name = "nome", length = 120)
	private Set<String> cidade = new HashSet<String>();
	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "estados", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"uf" }) }, joinColumns = @JoinColumn(name = "id"))
	@Column(name = "uf")
	private Set<String> uf = new HashSet<String>();;
*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtd_veiculos() {
		return qtd_veiculos;
	}

	public void setQtd_veiculos(Integer qtd_veiculos) {
		this.qtd_veiculos = qtd_veiculos;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	/*public Set<String> getCidade() {
		return cidade;
	}

	public void setCidade(Set<String> cidade) {
		this.cidade = cidade;
	}

	public Set<String> getUf() {
		return uf;
	}

	public void setUf(Set<String> uf) {
		this.uf = uf;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtd_veiculos == null) ? 0 : qtd_veiculos.hashCode());
		//result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Frota other = (Frota) obj;
	/*	if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;*/
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtd_veiculos == null) {
			if (other.qtd_veiculos != null)
				return false;
		} else if (!qtd_veiculos.equals(other.qtd_veiculos))
			return false;
		/*if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;*/
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	/**
	 * @return the id_cidade
	 */
	public Integer getId_cidade() {
		return id_cidade;
	}

	/**
	 * @param id_cidade the id_cidade to set
	 */
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}

}
