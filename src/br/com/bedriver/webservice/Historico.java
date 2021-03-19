package br.com.bedriver.webservice;

import java.util.Date;

public class Historico {
	private Integer nota;
	private String nome;
	private Date dataRealizado;
	
	
	
	public Historico() {
		
	}
	public Historico(Integer nota, String nome, Date dataRealizado) {
		super();
		this.nota = nota;
		this.nome = nome;
		this.dataRealizado = dataRealizado;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataRealizado() {
		return dataRealizado;
	}
	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}
}
