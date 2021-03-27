package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.CondutorDAO;

import br.com.bedriver.model.CondutoresHab;


public class CondutorDAOHibernate  implements CondutorDAO{
	private Session session;
	
	public void setSession(Session session) {
		
		this.session = session;
	}
	@Override
	public void salvar(CondutoresHab condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(CondutoresHab condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(CondutoresHab condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CondutoresHab carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CondutoresHab> listar() {
		return this.session.createCriteria(CondutoresHab.class).list();
	}

}
