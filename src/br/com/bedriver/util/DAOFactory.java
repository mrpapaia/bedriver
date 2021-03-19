package br.com.bedriver.util;

import br.com.bedriver.dao.CondutorDAOHibernate;
import br.com.bedriver.dao.EstadoDAOHibernate;
import br.com.bedriver.dao.FrotaDAOHibernate;
import br.com.bedriver.dao.InfracaoDAOHIbernate;
import br.com.bedriver.dao.PerguntaDAOHibernate;
import br.com.bedriver.dao.SimuladoDAOHibernate;
import br.com.bedriver.dao.UsuarioDAOHibernate;
import br.com.bedriver.dao.UsuarioSimuladoDAOHibernate;
import br.com.bedriver.dao.intefaces.CondutorDAO;
import br.com.bedriver.dao.intefaces.EstadoDAO;
import br.com.bedriver.dao.intefaces.FrotaDAO;
import br.com.bedriver.dao.intefaces.InfracaoDAO;
import br.com.bedriver.dao.intefaces.PerguntaDAO;
import br.com.bedriver.dao.intefaces.SimuladoDAO;
import br.com.bedriver.dao.intefaces.UsuarioDAO;
import br.com.bedriver.dao.intefaces.UsuarioSimuladoDAO;


public class DAOFactory {

	public static FrotaDAO criarFrotaDAO() {
		FrotaDAOHibernate frotaDAO = new FrotaDAOHibernate();
		frotaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return frotaDAO;
	}
	
	public static CondutorDAO criarCondutorDAO() {
		CondutorDAOHibernate condutorDAO = new CondutorDAOHibernate();
		condutorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return condutorDAO;
	}
	
	public static InfracaoDAO criarInfracaoDAO() {
		InfracaoDAOHIbernate infracaoDAO = new InfracaoDAOHIbernate();
		infracaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());		
		return infracaoDAO;
	}
	
	// Factory Usu�rio
	
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	
	public static UsuarioSimuladoDAO criarUsuarioSimuladoDAO() {
		UsuarioSimuladoDAOHibernate usuarioSimuladoDAO = new UsuarioSimuladoDAOHibernate();
		usuarioSimuladoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioSimuladoDAO;
	}
	
	public static EstadoDAO criarEstadoDAO() {
		EstadoDAOHibernate estadoDAO = new EstadoDAOHibernate();
		estadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estadoDAO;
	}
	
	public static SimuladoDAO criarSimuladoDAO() {
		SimuladoDAOHibernate simuladoDAO = new SimuladoDAOHibernate();
		simuladoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return simuladoDAO;
	}
	
	public static PerguntaDAO criarPerguntaDAO() {
		PerguntaDAOHibernate perguntaDAO = new PerguntaDAOHibernate();
		perguntaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return perguntaDAO;
	}
}