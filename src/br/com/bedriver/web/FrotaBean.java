package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.bedriver.model.FrotaVeiculo;
import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.FrotaRN;
import br.com.bedriver.rn.InfracaoRN;
import br.com.bedriver.rn.UsuarioRN;

@ManagedBean(name = "frotaBean")
@RequestScoped
public class FrotaBean {

	private List<FrotaVeiculo> lista;
	private static final Logger logger = LogManager.getLogger(FrotaBean.class);

	public List<FrotaVeiculo> getLista() {

		if (this.lista == null) {
			FrotaRN frotaRN = new FrotaRN();
			this.lista = frotaRN.listar();
			if (this.lista == null) {
				logger.error("Erro ao listar frotas");
			} else {
				
				logger.info("Frotas listadas com sucesso");
			}
		}
		return this.lista;
	}
	
}