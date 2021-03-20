package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.SimuladoDAO;
import br.com.bedriver.model.Simulado;
import br.com.bedriver.util.DAOFactory;

public class SimuladoRN {
	
	private SimuladoDAO simuladoDAO;
	
	public SimuladoRN() {
		this.simuladoDAO = DAOFactory.criarSimuladoDAO();
	}

	public Simulado carregar(Integer codigo) {
		return this.simuladoDAO.carregar(codigo);
	}

	public void salvar(Simulado simulado) {
		Integer codigo = simulado.getId();
		if (codigo == null || codigo == 0) {
				this.simuladoDAO.salvar(simulado);
			} else {
				this.simuladoDAO.atualizar(simulado);
		}
	}

	public void excluir(Simulado simulado) {
		this.simuladoDAO.excluir(simulado);
	}

	public List<Simulado> listar() {
		return this.simuladoDAO.listar();
	}
	
	public Simulado buscar(int idSimulado) {
		return this.simuladoDAO.buscar(idSimulado);
	}

}
