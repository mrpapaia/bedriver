package br.com.bedriver.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.bedriver.dao.intefaces.InfracaoDAO;
import br.com.bedriver.model.Frota;
import br.com.bedriver.model.Infracao;

public class InfracaoDAOHIbernate implements InfracaoDAO{
	private Session session;

	public void setSession(Session session) {
		
		this.session = session;
	}
	@Override
	public void salvar(Infracao infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Infracao infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Infracao infracao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Infracao carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Infracao> listar() {
		return this.session.createCriteria(Infracao.class).list();
	}




}
