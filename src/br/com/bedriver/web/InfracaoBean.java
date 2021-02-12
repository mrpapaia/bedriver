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

	public List<Infracoe> getLista() {
		if (this.lista == null) {
			InfracaoRN infracaoRN = new InfracaoRN();
			this.lista = infracaoRN.listar();
		}
		return this.lista;
	}
}
