package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import br.com.bedriver.model.Infracao;

import br.com.bedriver.rn.InfracaoRN;

@ManagedBean(name = "infracaoBean")
@RequestScoped
public class InfracaoBean {
	private List<Infracao> lista;

	public List<Infracao> getLista() {
		if (this.lista == null) {
			InfracaoRN infracaoRN = new InfracaoRN();
			this.lista = infracaoRN.listar();
		}
		return this.lista;
	}
}
