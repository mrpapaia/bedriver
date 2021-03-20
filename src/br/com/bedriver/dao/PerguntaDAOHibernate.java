package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.bedriver.dao.intefaces.PerguntaDAO;
import br.com.bedriver.model.Pergunta;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.util.HibernateUtil;

public class PerguntaDAOHibernate implements PerguntaDAO {
	private Session session;

	public void setSession(Session session) {

		this.session = session;
	}

	@Override
	public void salvar(Pergunta pergunta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Pergunta pergunta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Pergunta pergunta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pergunta carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pergunta> listar() {
		List<Pergunta> p = this.session.createCriteria(Pergunta.class).list();
		System.out.println("TAMANHO LISTA NO DAO PERGUNTAS: " + p.size());
		return p;
	}

}
