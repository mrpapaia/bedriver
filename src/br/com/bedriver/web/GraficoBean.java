package br.com.bedriver.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.CondutoresHab;
import br.com.bedriver.model.Estado;
import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.CondutorRN;
import br.com.bedriver.rn.EstadoRN;
import br.com.bedriver.rn.InfracaoRN;
import br.com.bedriver.util.Utils;

@ManagedBean(name = "graficoBean")
@RequestScoped
public class GraficoBean {

	private List<Infracoe> infracoes;
	private List<CondutoresHab> condutores;
	private Map<String, Number> frotas;
	
	public String getInfoEstadoInfracao(String uf) {
		
		if(infracoes == null) {
			InfracaoRN infracaoRN = new InfracaoRN();
			infracoes = infracaoRN.listar();
		}
		
		int registros = 0;
		
		Estado e = new EstadoRN().carregar(uf);
		
		for(Infracoe i : infracoes) {
			if(i.getEstado().getUf().equals(uf)) {
				registros += i.getQuantidade();
			}
		}
		
		return e.getNome() + ": " + (registros != 0 ? registros : "Sem Registros de ") + " Infrações";
	}
	
	public String getInfoEstadoFrota(String uf) {
		
		if(frotas == null) {
			frotas = Utils.getFrotasEstados();
		}
		
		Number registros = frotas.get(uf);
		
		Estado e = new EstadoRN().carregar(uf);
		
		return e.getNome() + ": " + (registros != null ? registros : "Sem Registros de ") + " Veículos";
	}
	
	public String getInfoEstadoCondutor(String uf) {
		
		if(condutores == null) {
			CondutorRN condutorRN = new CondutorRN();
			condutores = condutorRN.listar();
		}
		
		int registros = 0;
		
		Estado e = new EstadoRN().carregar(uf);
		
		for(CondutoresHab c : condutores) {
			if(c.getEstado().getUf().equals(uf)) {
				registros += c.getQtdHabilitados();
			}
		}
		
		return e.getNome() + ": " + (registros != 0 ? registros : "Sem Registros de ") + " Condutores";
	}
	

}
