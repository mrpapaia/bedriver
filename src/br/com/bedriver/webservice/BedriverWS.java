package br.com.bedriver.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.rn.UsuarioSimuladoRN;


@WebService
public class BedriverWS {
	@WebMethod
	@WebResult(name = "historico")
    @ResponseWrapper(localName = "hist")
    @RequestWrapper(localName = "listaNotas")
	public List<Historico> historico(@WebParam(name = "email") String email, @WebParam(name = "de") Date de,
			@WebParam(name = "ate") Date ate) {
		UsuarioSimuladoRN usuarioSimuladoRN = new UsuarioSimuladoRN();
		UsuarioRN usuarioRN = new UsuarioRN();
		List<Historico> retorno = new ArrayList<Historico>();
		Historico historicoItem = null;

		Usuario usuarioPesquisado = usuarioRN.buscarPorLogin(email);
		List<UsuarioSimulado> lista =usuarioSimuladoRN.listar(usuarioPesquisado, de, ate);
		for (UsuarioSimulado usuarioSimulado : lista) {
			historicoItem = new Historico();
			historicoItem.setDataRealizado(usuarioSimulado.getDataRealizado());
			historicoItem.setNome((usuarioSimulado.getUsuario().getNome()));
			historicoItem.setNota(usuarioSimulado.getNota());
			retorno.add(historicoItem);
		}
		return retorno;
	}
}
