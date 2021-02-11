package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.EstadoDAO;
import br.com.bedriver.model.Estado;
import br.com.bedriver.util.DAOFactory;

public class EstadoRN {
	private EstadoDAO estadoDAO;

	public EstadoRN() {
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}

	public List<Estado> listar() {
		return this.estadoDAO.listar();
	}

}
