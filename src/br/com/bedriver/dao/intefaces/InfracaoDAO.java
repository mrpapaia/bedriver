package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Infracao;



public interface InfracaoDAO {
	public void salvar(Infracao infracao);

	public void atualizar(Infracao infracao);

	public void excluir(Infracao infracao);

	public Infracao carregar(Integer codigo);

	public List<Infracao> listar();

}
