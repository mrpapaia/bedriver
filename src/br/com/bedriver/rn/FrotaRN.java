package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.FrotaDAO;
import br.com.bedriver.model.Frota;
import br.com.bedriver.util.DAOFactory;


public class FrotaRN {
	private FrotaDAO frotaDAO;

	public FrotaRN() {
		this.frotaDAO = DAOFactory.criarFrotaDAO();
	}

	public List<Frota> listar() {
		return this.frotaDAO.listar();
	}
}
