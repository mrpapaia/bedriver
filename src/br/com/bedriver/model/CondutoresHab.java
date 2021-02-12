package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the condutores_hab database table.
 * 
 */
@Entity
@Table(name="condutores_hab")
@NamedQuery(name="CondutoresHab.findAll", query="SELECT c FROM CondutoresHab c")
public class CondutoresHab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	

	@Column(name="faixa_etaria")
	private String faixaEtaria;

	@Column(name="qtd_habilitados")
	private Integer qtdHabilitados;

	private String sexo;

	//bi-directional many-to-one association to CategoriaCnh
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaCnh categoriaCnh;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	public CondutoresHab() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	

	public String getFaixaEtaria() {
		return this.faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public Integer getQtdHabilitados() {
		return this.qtdHabilitados;
	}

	public void setQtdHabilitados(Integer qtdHabilitados) {
		this.qtdHabilitados = qtdHabilitados;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public CategoriaCnh getCategoriaCnh() {
		return this.categoriaCnh;
	}

	public void setCategoriaCnh(CategoriaCnh categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((categoriaCnh == null) ? 0 : categoriaCnh.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((faixaEtaria == null) ? 0 : faixaEtaria.hashCode());
		result = prime * result + ((qtdHabilitados == null) ? 0 : qtdHabilitados.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		CondutoresHab other = (CondutoresHab) obj;
		
		if (categoriaCnh == null) {
			if (other.categoriaCnh != null)
				return false;
		} else if (!categoriaCnh.equals(other.categoriaCnh))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (faixaEtaria == null) {
			if (other.faixaEtaria != null)
				return false;
		} else if (!faixaEtaria.equals(other.faixaEtaria))
			return false;
		if (qtdHabilitados == null) {
			if (other.qtdHabilitados != null)
				return false;
		} else if (!qtdHabilitados.equals(other.qtdHabilitados))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

}