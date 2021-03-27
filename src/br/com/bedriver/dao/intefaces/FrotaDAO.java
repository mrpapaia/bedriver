package br.com.bedriver.dao.intefaces;

import java.util.List;


import br.com.bedriver.model.FrotaVeiculo;


public interface FrotaDAO {
	public void salvar(FrotaVeiculo frota);

	public void atualizar(FrotaVeiculo frota);

	public void excluir(FrotaVeiculo frota);

	public FrotaVeiculo carregar(Integer codigo);

	public List<FrotaVeiculo> listar();
}
