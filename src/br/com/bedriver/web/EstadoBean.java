package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Estado;
import br.com.bedriver.rn.EstadoRN;
@ManagedBean(name = "estadoBean")
@RequestScoped
public class EstadoBean {
	private List<Estado> lista;
	private Estado estado;
	
	public Estado estadoAtual() {
		if(estado == null) {
			estado = new Estado();
		}
		
		return estado;
	}
	
	public List<Estado> getLista() {
		if (this.lista == null) {
			EstadoRN estadoRN = new EstadoRN();
			this.lista = estadoRN.listar();
		}
		return this.lista;
	}
}
