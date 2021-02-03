package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Frota;


public interface FrotaDAO {
	public void salvar(Frota frota);

	public void atualizar(Frota frota);

	public void excluir(Frota frota);

	public Frota carregar(Integer codigo);

	public List<Frota> listar();
}
