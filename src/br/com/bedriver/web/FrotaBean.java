package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Frota;
import br.com.bedriver.rn.FrotaRN;



@ManagedBean(name = "frotaBean")
@RequestScoped
public class FrotaBean {
	private List<Frota> lista;
	
	
	public List<Frota> getLista() {
		
		if (this.lista == null) {			
			FrotaRN frotaRN = new FrotaRN();			
			this.lista = frotaRN.listar();		}
		return this.lista;
	}
}
