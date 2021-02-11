package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.EstadoDAO;
import br.com.bedriver.model.Estado;

public class EstadoDAOHibernate implements EstadoDAO {
	
	private Session session;

	public void setSession(Session session) {
		
		this.session = session;
	}

	@Override
	public void salvar(Estado estado) {
	}

	@Override
	public void atualizar(Estado estado) {
	}

	@Override
	public void excluir(Estado estado) {
	}

	@Override
	public Estado carregar(Integer codigo) {
		return null;
	}

	@Override
	public List<Estado> listar() {
		return this.session.createCriteria(Estado.class).list();
	}

}
