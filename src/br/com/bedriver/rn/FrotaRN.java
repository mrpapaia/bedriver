package br.com.bedriver.rn;

import java.util.List;

import br.com.bedriver.dao.intefaces.FrotaDAO;
import br.com.bedriver.model.Frota;


public class FrotaRN {
	private FrotaDAO frotaDAO;
	
	public List<Frota> listar() {
		return this.frotaDAO.listar();
	}
}
