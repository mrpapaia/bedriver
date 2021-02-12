package br.com.bedriver.dao.intefaces;

import java.util.List;


import br.com.bedriver.model.CondutoresHab;



public interface CondutorDAO {
	public void salvar(CondutoresHab condutor);

	public void atualizar(CondutoresHab condutor);

	public void excluir(CondutoresHab condutor);

	public CondutoresHab carregar(Integer codigo);

	public List<CondutoresHab> listar();
}
