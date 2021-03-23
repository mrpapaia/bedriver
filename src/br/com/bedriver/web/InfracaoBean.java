package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.InfracaoRN;

@ManagedBean(name = "infracaoBean")
@RequestScoped
public class InfracaoBean {
	
	private List<Infracoe> lista;
	private static final Logger logger = LogManager.getLogger(InfracaoBean.class);
	
	public List<Infracoe> getLista() {
		if (this.lista == null) {
			InfracaoRN infracaoRN = new InfracaoRN();
			this.lista = infracaoRN.listar();
			if (this.lista == null) {
				logger.error("Erro ao listar frotas");
			} else {
				logger.info("Infrações listadas com sucesso");
			}
		}
		return this.lista;
	}
}