package br.com.bedriver.web.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoREST {
	
	private String sigla;
	private String nome;
	
	public EstadoREST() {
		
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "EstadoREST [sigla=" + sigla + ", nome=" + nome + "]";
	}

	
}
