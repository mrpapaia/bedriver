package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Estado;

public interface EstadoDAO {
	public void salvar(Estado estado);

	public void atualizar(Estado estado);

	public void excluir(Estado estado);

	public Estado carregar(Integer codigo);

	public List<Estado> listar();
}
