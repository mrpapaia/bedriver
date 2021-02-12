package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.FrotaDAO;

import br.com.bedriver.model.FrotaVeiculo;
import br.com.bedriver.util.DAOFactory;


public class FrotaRN {
	private FrotaDAO frotaDAO;

	public FrotaRN() {
		this.frotaDAO = DAOFactory.criarFrotaDAO();
	}

	public List<FrotaVeiculo> listar() {
		return this.frotaDAO.listar();
	}
}
