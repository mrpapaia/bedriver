package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bedriver.dao.intefaces.SimuladoDAO;
import br.com.bedriver.model.Simulado;

public class SimuladoDAOHibernate implements SimuladoDAO {
	private Session session;

	public void setSession(Session session) {

		this.session = session;
	}

	@Override
	public void salvar(Simulado simulado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Simulado simulado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Simulado simulado) {
		// TODO Auto-generated method stub

	}

	@Override
	public Simulado carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Simulado> listar() {
		return this.session.createCriteria(Simulado.class).list();
	}

	@Override
	public Simulado buscar(int idSimulado) {
		Criteria criteria = this.session.createCriteria(Simulado.class);
		criteria.add(Restrictions.eq("id", idSimulado));
		return (Simulado) criteria.uniqueResult();
	}
}
