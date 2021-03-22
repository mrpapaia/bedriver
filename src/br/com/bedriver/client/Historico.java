
package br.com.bedriver.client;

import java.util.Date;

public class Historico {
	private Date dataRealizado;
	private String nome;
	private int nota;
	public Date getDataRealizado() {
		return this.dataRealizado;
	}

	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}

	

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}



	@Override
	public String toString() {
		return "[RESULTADO [DataRealizado=" + dataRealizado + ", Nome=" + nome + ", Nota=" + nota + "]";
	}
	
}
