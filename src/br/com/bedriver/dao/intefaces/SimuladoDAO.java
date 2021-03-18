package br.com.bedriver.dao.intefaces;

import java.util.List;
import br.com.bedriver.model.Simulado;

public interface SimuladoDAO {
	public void salvar(Simulado simulado);

	public void atualizar(Simulado simulado);

	public void excluir(Simulado simulado);

	public Simulado carregar(Integer codigo);

	public List<Simulado> listar();
}
