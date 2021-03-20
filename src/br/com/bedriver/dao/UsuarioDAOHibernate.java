package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bedriver.dao.intefaces.UsuarioDAO;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.util.HibernateUtil;

public class UsuarioDAOHibernate implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Usuario usuario) {
		Usuario usuarioPermissao = this.carregar(usuario.getId());
		usuario.setPermissao(usuarioPermissao.getPermissao());
		this.session.evict(usuarioPermissao);

		this.session.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

	public Usuario buscarPorLogin(String login) {
		//Session session1 = HibernateUtil.getSessionFactory().openSession();
		String hql = "select u from Usuario u where u.email = :login";
		
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}
	
	public Usuario buscarPorResetPasswordToken(String resetPasswordToken) {
		String hql = "select u from Usuario u where u.resetPasswordToken = :rpt";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("rpt", resetPasswordToken);
		return (Usuario) consulta.uniqueResult();
	}
}
