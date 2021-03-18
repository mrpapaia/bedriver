package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Estado;
import br.com.bedriver.model.Simulado;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.rn.SimuladoRN;
import br.com.bedriver.rn.UsuarioRN;

@ManagedBean(name = "simuladoBean")
@RequestScoped
public class SimuladoBean {

	private Simulado simulado = new Simulado();
	private List<Simulado> lista;
	
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
	
	

}
