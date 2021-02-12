package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.CondutorDAO;
import br.com.bedriver.model.Condutor;
import br.com.bedriver.model.Frota;

public class CondutorDAOHibernate  implements CondutorDAO{
	private Session session;
	
	public void setSession(Session session) {
		
		this.session = session;
	}
	@Override
	public void salvar(Condutor condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Condutor condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Condutor condutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Condutor carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Condutor> listar() {
		return this.session.createCriteria(Condutor.class).list();
	}

}
