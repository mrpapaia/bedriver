package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Pergunta;

public interface PerguntaDAO {
	public void salvar(Pergunta pergunta);

	public void atualizar(Pergunta pergunta);

	public void excluir(Pergunta pergunta);

	public Pergunta carregar(Integer codigo);

	public List<Pergunta> listar();
}
