package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.InfracaoRN;

@ManagedBean(name = "infracaoBean")
@RequestScoped
public class InfracaoBean {
	
	private List<Infracoe> lista;
	private boolean mostraLista = true;
	private boolean mostraGrafico = false;

	public boolean isMostraLista() {
		return mostraLista;
	}

	public boolean isMostraGrafico() {
		return mostraGrafico;
	}

	public void setMostraGrafico(boolean mostraGrafico) {
		this.mostraGrafico = mostraGrafico;
		this.mostraLista = !mostraGrafico;
	}

	public void setMostraLista(boolean mostraLista) {
		this.mostraLista = mostraLista;
		this.mostraGrafico = !mostraLista;
	}

	public void setLista(List<Infracoe> lista) {
		this.lista = lista;
	}
	
	public List<Infracoe> getLista() {
		if (this.lista == null) {
			InfracaoRN infracaoRN = new InfracaoRN();
			this.lista = infracaoRN.listar();
		}
		return this.lista;
	}
}