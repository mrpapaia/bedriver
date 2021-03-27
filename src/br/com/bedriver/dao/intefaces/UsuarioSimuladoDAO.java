package br.com.bedriver.dao.intefaces;

import java.util.Date;
import java.util.List;

import br.com.bedriver.model.Simulado;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;

public interface UsuarioSimuladoDAO {
	public void salvar(UsuarioSimulado simulado);

	public void atualizar(UsuarioSimulado simulado);

	public void excluir(UsuarioSimulado simulado);

	public UsuarioSimulado carregar(Integer codigo);

	public List<UsuarioSimulado> listar(Usuario usuario, Date dataInicio, Date dataFim);
}
