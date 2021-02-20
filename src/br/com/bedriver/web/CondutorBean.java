package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import br.com.bedriver.model.CondutoresHab;
import br.com.bedriver.rn.CondutorRN;


@ManagedBean(name = "condutorBean")
@RequestScoped
public class CondutorBean {
	
	private List<CondutoresHab> lista;
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

	public void setLista(List<CondutoresHab> lista) {
		this.lista = lista;
	}
	
	public List<CondutoresHab> getLista() {
		if (this.lista == null) {
			CondutorRN condutorRN = new CondutorRN();
			this.lista = condutorRN.listar();
		}
		return this.lista;
	}

}
