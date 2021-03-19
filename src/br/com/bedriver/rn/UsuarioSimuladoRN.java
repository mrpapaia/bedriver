package br.com.bedriver.rn;

import java.util.Date;
import java.util.List;

import br.com.bedriver.dao.intefaces.UsuarioSimuladoDAO;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.util.DAOFactory;


public class UsuarioSimuladoRN {
	private UsuarioSimuladoDAO usuarioSimuladoDAO;

	public UsuarioSimuladoRN() {
		this.usuarioSimuladoDAO = DAOFactory.criarUsuarioSimuladoDAO();
	}

	public void salvar(UsuarioSimulado usuarioSimulado) {
		this.usuarioSimuladoDAO.salvar(usuarioSimulado);
	}

	public void excluir(UsuarioSimulado usuarioSimulado) {
		this.usuarioSimuladoDAO.excluir(usuarioSimulado);
	}

	public UsuarioSimulado carregar(Integer codigo) {
		return this.usuarioSimuladoDAO.carregar(codigo);
	}


	public List<UsuarioSimulado> listar(Usuario usuario, Date dataInicio, Date dataFim) {
		return this.usuarioSimuladoDAO.listar(usuario, dataInicio, dataFim);
	}
}
