package br.com.bedriver.util;

import br.com.bedriver.dao.FrotaDAOHibernate;
import br.com.bedriver.dao.intefaces.FrotaDAO;


public class DAOFactory {

	public static FrotaDAO criarFrotaDAO() {
		FrotaDAOHibernate frotaDAO = new FrotaDAOHibernate();
		frotaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return frotaDAO;
	}

}