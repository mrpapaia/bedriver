package br.com.bedriver.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.bedriver.dao.intefaces.UsuarioSimuladoDAO;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.util.HibernateUtil;


public class UsuarioSimuladoDAOHibernate implements UsuarioSimuladoDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(UsuarioSimulado UsuarioSimulado) {
		this.session.saveOrUpdate(UsuarioSimulado);
	}

	public void excluir(UsuarioSimulado UsuarioSimulado) {
		this.session.delete(UsuarioSimulado);
	}

	public UsuarioSimulado carregar(Integer UsuarioSimulado) {
		return (UsuarioSimulado) this.session.get(UsuarioSimulado.class, UsuarioSimulado);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioSimulado> listar(Usuario usuario, Date dataInicio, Date dataFim) {
		//Session session1 = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = this.session.createCriteria(UsuarioSimulado.class);
		System.out.println("sdadasddasdasdasdasdasdasdasdasdasdasdasd");
		if (dataInicio != null && dataFim != null) {
			criteria.add(Restrictions.between("dataRealizado", dataInicio, dataFim));
		} else if (dataInicio != null) {
			criteria.add(Restrictions.ge("dataRealizado", dataInicio));
		} else if (dataFim != null) {
			criteria.add(Restrictions.le("dataRealizado", dataFim));
		}

		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.addOrder(Order.asc("dataRealizado"));
		return criteria.list();
	}

	@Override
	public void atualizar(UsuarioSimulado simulado) {
		// TODO Auto-generated method stub
		
	}



}
