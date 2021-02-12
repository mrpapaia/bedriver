package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perguntas database table.
 * 
 */
@Entity
@Table(name="perguntas")
@NamedQuery(name="Pergunta.findAll", query="SELECT p FROM Pergunta p")
public class Pergunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String alternativas;

	private Integer resposta;

	private String texto;

	//bi-directional many-to-one association to CategoriaPergunta
	@ManyToOne
	@JoinColumn(name="id_cat_pergunta")
	private CategoriaPergunta categoriaPergunta;

	//bi-directional many-to-many association to Simulado
	@ManyToMany(mappedBy="perguntas")
	private List<Simulado> simulados;

	public Pergunta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlternativas() {
		return this.alternativas;
	}

	public void setAlternativas(String alternativas) {
		this.alternativas = alternativas;
	}

	public Integer getResposta() {
		return this.resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public CategoriaPergunta getCategoriaPergunta() {
		return this.categoriaPergunta;
	}

	public void setCategoriaPergunta(CategoriaPergunta categoriaPergunta) {
		this.categoriaPergunta = categoriaPergunta;
	}

	public List<Simulado> getSimulados() {
		return this.simulados;
	}

	public void setSimulados(List<Simulado> simulados) {
		this.simulados = simulados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativas == null) ? 0 : alternativas.hashCode());
		result = prime * result + ((categoriaPergunta == null) ? 0 : categoriaPergunta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
		result = prime * result + ((simulados == null) ? 0 : simulados.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Pergunta other = (Pergunta) obj;
		if (alternativas == null) {
			if (other.alternativas != null)
				return false;
		} else if (!alternativas.equals(other.alternativas))
			return false;
		if (categoriaPergunta == null) {
			if (other.categoriaPergunta != null)
				return false;
		} else if (!categoriaPergunta.equals(other.categoriaPergunta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		if (simulados == null) {
			if (other.simulados != null)
				return false;
		} else if (!simulados.equals(other.simulados))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

}