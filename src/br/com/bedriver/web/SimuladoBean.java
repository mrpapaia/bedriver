package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Simulado;
import br.com.bedriver.rn.SimuladoRN;

@ManagedBean(name = "simuladoBean")
@RequestScoped
public class SimuladoBean {

	private Simulado simulado = new Simulado();
	private List<Simulado> lista;
	private Simulado simuladoEscolhido;

	public String salvar() {
		
		SimuladoRN simuladoRN = new SimuladoRN();
		simuladoRN.salvar(this.simulado);
		
		return "/index";
		
	}
	
	public List<Simulado> getLista() {
		
		if (this.lista == null) {
			SimuladoRN simuladoRN = new SimuladoRN();
			this.lista = simuladoRN.listar();
		}
		return this.lista;
	}
	
	public Simulado getSimulado() {
		return simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public Simulado getSimuladoEscolhido() {
		return simuladoEscolhido;
	}

	public String setSimuladoEscolhido(Simulado simuladoEscolhido) {
		this.simuladoEscolhido = simuladoEscolhido;
		return "/public/pergunta.xhtml";
	}

}
