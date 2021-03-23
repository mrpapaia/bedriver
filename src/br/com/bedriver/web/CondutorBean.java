package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.bedriver.model.CondutoresHab;
import br.com.bedriver.rn.CondutorRN;


@ManagedBean(name = "condutorBean")
@ViewScoped
public class CondutorBean {
	
	private List<CondutoresHab> lista;
	private static final Logger logger = LogManager.getLogger(CondutorBean.class);

	
	public List<CondutoresHab> getLista() {
		if (this.lista == null) {
			CondutorRN condutorRN = new CondutorRN();
			this.lista = condutorRN.listar();
			if (this.lista == null) {
				logger.error("Erro ao listar Condutores");
			} else {
				logger.info("Condutores listadas com sucesso");
			}
		}
		return this.lista;
	}

}