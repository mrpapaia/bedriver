package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.FrotaDAO;
import br.com.bedriver.model.Frota;

public class FrotaDAOHibernate implements FrotaDAO {

	private Session session;

	public void setSession(Session session) {
		
		this.session = session;
	}

	@Override
	public void salvar(Frota frota) {
		//this.session.save(frota);
	}

	@Override
	public void atualizar(Frota frota) {

	}

	@Override
	public void excluir(Frota frota) {
		//this.session.delete(frota);
	}

	@Override
	public Frota carregar(Integer codigo) {
		return null;
		//return (Frota) this.session.get(Frota.class, codigo);
	}

	@Override
	public List<Frota> listar() {
		return this.session.createCriteria(Frota.class).list();
	}

}
