package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.FrotaDAO;
import br.com.bedriver.model.FrotaVeiculo;


public class FrotaDAOHibernate implements FrotaDAO {

	private Session session;

	public void setSession(Session session) {
		
		this.session = session;
	}

	@Override
	public void salvar(FrotaVeiculo frota) {
		//this.session.save(frota);
	}

	@Override
	public void atualizar(FrotaVeiculo frota) {

	}

	@Override
	public void excluir(FrotaVeiculo frota) {
		//this.session.delete(frota);
	}

	@Override
	public FrotaVeiculo carregar(Integer codigo) {
		return null;
		//return (Frota) this.session.get(Frota.class, codigo);
	}

	@Override
	public List<FrotaVeiculo> listar() {
		return this.session.createCriteria(FrotaVeiculo.class).list();
	}

}
