package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_cnh database table.
 * 
 */
@Entity
@Table(name="categoria_cnh")
@NamedQuery(name="CategoriaCnh.findAll", query="SELECT c FROM CategoriaCnh c")
public class CategoriaCnh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descricao;

	//bi-directional many-to-one association to CondutoresHab
	@OneToMany(mappedBy="categoriaCnh")
	private List<CondutoresHab> condutoresHabs;

	public CategoriaCnh() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CondutoresHab> getCondutoresHabs() {
		return this.condutoresHabs;
	}

	public void setCondutoresHabs(List<CondutoresHab> condutoresHabs) {
		this.condutoresHabs = condutoresHabs;
	}

	public CondutoresHab addCondutoresHab(CondutoresHab condutoresHab) {
		getCondutoresHabs().add(condutoresHab);
		condutoresHab.setCategoriaCnh(this);

		return condutoresHab;
	}

	public CondutoresHab removeCondutoresHab(CondutoresHab condutoresHab) {
		getCondutoresHabs().remove(condutoresHab);
		condutoresHab.setCategoriaCnh(null);

		return condutoresHab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condutoresHabs == null) ? 0 : condutoresHabs.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CategoriaCnh other = (CategoriaCnh) obj;
		if (condutoresHabs == null) {
			if (other.condutoresHabs != null)
				return false;
		} else if (!condutoresHabs.equals(other.condutoresHabs))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}