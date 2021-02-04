package br.com.bedriver.model;

import javax.persistence.*;

@Entity
@Table(name = "condutores_hab")
public class Condutor {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer qtd_habilitados;
	private String sexo;
	private String faixa_etaria;
	@Column(name="id_categoria")
	private String categoria;
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQtd_habilitados() {
		return qtd_habilitados;
	}
	public void setQtd_habilitados(Integer qtd_habilitados) {
		this.qtd_habilitados = qtd_habilitados;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFaixa_etaria() {
		return faixa_etaria;
	}
	public void setFaixa_etaria(String faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((faixa_etaria == null) ? 0 : faixa_etaria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtd_habilitados == null) ? 0 : qtd_habilitados.hashCode());
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
		Condutor other = (Condutor) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (faixa_etaria == null) {
			if (other.faixa_etaria != null)
				return false;
		} else if (!faixa_etaria.equals(other.faixa_etaria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtd_habilitados == null) {
			if (other.qtd_habilitados != null)
				return false;
		} else if (!qtd_habilitados.equals(other.qtd_habilitados))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	

}
