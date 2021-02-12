package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_perguntas database table.
 * 
 */
@Entity
@Table(name="categoria_perguntas")
@NamedQuery(name="CategoriaPergunta.findAll", query="SELECT c FROM CategoriaPergunta c")
public class CategoriaPergunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String tipo;

	//bi-directional many-to-one association to Pergunta
	@OneToMany(mappedBy="categoriaPergunta")
	private List<Pergunta> perguntas;

	public CategoriaPergunta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Pergunta> getPerguntas() {
		return this.perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Pergunta addPergunta(Pergunta pergunta) {
		getPerguntas().add(pergunta);
		pergunta.setCategoriaPergunta(this);

		return pergunta;
	}

	public Pergunta removePergunta(Pergunta pergunta) {
		getPerguntas().remove(pergunta);
		pergunta.setCategoriaPergunta(null);

		return pergunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((perguntas == null) ? 0 : perguntas.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		CategoriaPergunta other = (CategoriaPergunta) obj;
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
		if (perguntas == null) {
			if (other.perguntas != null)
				return false;
		} else if (!perguntas.equals(other.perguntas))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}