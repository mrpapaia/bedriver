package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Condutor;



public interface CondutorDAO {
	public void salvar(Condutor condutor);

	public void atualizar(Condutor condutor);

	public void excluir(Condutor condutor);

	public Condutor carregar(Integer codigo);

	public List<Condutor> listar();
}
