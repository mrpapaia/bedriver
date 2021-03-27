package br.com.bedriver.dao.intefaces;

import java.util.List;

import br.com.bedriver.model.Usuario;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);

	public void atualizar(Usuario usuario);

	public void excluir(Usuario usuario);

	public Usuario carregar(Integer codigo);

	public Usuario buscarPorLogin(String login);
	
	public Usuario buscarPorResetPasswordToken(String resetPasswordToken);

	public List<Usuario> listar();
}