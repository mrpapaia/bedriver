package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.PerguntaDAO;
import br.com.bedriver.model.Pergunta;
import br.com.bedriver.util.DAOFactory;

public class PerguntaRN {
	private PerguntaDAO perguntaDAO;

	public PerguntaRN() {
		this.perguntaDAO = DAOFactory.criarPerguntaDAO();
	}

	public Pergunta carregar(Integer codigo) {
		return this.perguntaDAO.carregar(codigo);
	}

	public void salvar(Pergunta pergunta) {
		Integer codigo = pergunta.getId();
		if (codigo == null || codigo == 0) {
			this.perguntaDAO.salvar(pergunta);
		} else {
			this.perguntaDAO.atualizar(pergunta);
		}
	}

	public void excluir(Pergunta pergunta) {
		this.perguntaDAO.excluir(pergunta);
	}

	public List<Pergunta> listar() {
		return this.perguntaDAO.listar();
	}
}
