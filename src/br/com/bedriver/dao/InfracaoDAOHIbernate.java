package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.InfracaoDAO;
import br.com.bedriver.model.Infracoe;


public class InfracaoDAOHIbernate implements InfracaoDAO{
	private Session session;

	public void setSession(Session session) {
		
		this.session = session;
	}
	@Override
	public void salvar(Infracoe infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Infracoe infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Infracoe infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Infracoe carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Infracoe> listar() {
		return this.session.createCriteria(Infracoe.class).list();
	}




}
