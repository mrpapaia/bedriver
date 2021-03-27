package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Infracoe;

public interface InfracaoDAO {
	public void salvar(Infracoe infracao);

	public void atualizar(Infracoe infracao);

	public void excluir(Infracoe infracao);

	public Infracoe carregar(Integer codigo);

	public List<Infracoe> listar();
}
