package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.UsuarioDAO;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.util.DAOException;
import br.com.bedriver.util.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getId();
		if (codigo == null || codigo == 0) {
				this.usuarioDAO.salvar(usuario);
			} else {
				this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
	
	public void updateResetPasswordToken(String token, String email) throws DAOException {
		
		Usuario usuario = this.usuarioDAO.buscarPorLogin(email);
		
		if(usuario != null) {
			usuario.setResetPasswordToken(token);
			this.usuarioDAO.salvar(usuario);
		}else {
			throw new DAOException("Não foi encontrado nenhum usuário com este email " + email);
		}
		
	}
	
	public Usuario get(String resetPasswordToken) {
		return this.usuarioDAO.buscarPorResetPasswordToken(resetPasswordToken);
	}

}
