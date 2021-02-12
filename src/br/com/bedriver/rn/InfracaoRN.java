package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.InfracaoDAO;

import br.com.bedriver.model.Infracoe;
import br.com.bedriver.util.DAOFactory;

public class InfracaoRN {
	private InfracaoDAO infracaoDAO;

	public InfracaoRN() {		
		this.infracaoDAO = DAOFactory.criarInfracaoDAO();
	}

	public List<Infracoe> listar() {
		return this.infracaoDAO.listar();
	}

}
