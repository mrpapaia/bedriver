package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.InfracaoRN;

@ManagedBean(name = "graficoBean")
@RequestScoped
public class GraficoBean {

	private InfracaoRN infracaoRN = new InfracaoRN();
	
	public String getInfoEstado(String uf) {
		
		List<Infracoe> infracoes = infracaoRN.listar(uf);
		
		String nomeEstado = infracoes.get(0).getEstado().getNome();
		int registros = infracoes.size();
		
		return nomeEstado + ": " + registros + " Infrações";
	}
}
