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
		Criteria criteria = this.session.createCriteria(UsuarioSimulado.class);
		System.out.println("sdadasddasdasdasdasdasdasdasdasdasdasdasd");
		if (dataInicio != null && dataFim != null) {
			criteria.add(Restrictions.between("data_realizado", dataInicio, dataFim));
		} else if (dataInicio != null) {
			criteria.add(Restrictions.ge("data_realizado", dataInicio));
		} else if (dataFim != null) {
			criteria.add(Restrictions.le("data_realizado", dataFim));
		}

		criteria.add(Restrictions.eq("id_usuario", usuario.getId()));
		criteria.addOrder(Order.asc("data_realizado"));
		return criteria.list();
	}

	@Override
	public void atualizar(UsuarioSimulado simulado) {
		// TODO Auto-generated method stub
		
	}



}
