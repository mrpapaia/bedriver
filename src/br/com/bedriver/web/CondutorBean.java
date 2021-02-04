package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Condutor;

import br.com.bedriver.rn.CondutorRN;


@ManagedBean(name = "condutorBean")
@RequestScoped
public class CondutorBean {
	private List<Condutor> lista;

	public List<Condutor> getLista() {
		if (this.lista == null) {
			CondutorRN condutorRN = new CondutorRN();
			this.lista = condutorRN.listar();
		}
		return this.lista;
	}

}
