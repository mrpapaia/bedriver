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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.rn.UsuarioSimuladoRN;
import br.com.bedriver.web.UsuarioBean;


@WebService
public class BedriverWS {
	private static final Logger logger = LogManager.getLogger(BedriverWS.class);

	@WebMethod
	@WebResult(name = "historico")
    @ResponseWrapper(localName = "hist")
    @RequestWrapper(localName = "listaNotas")
	public List<Historico> historico(@WebParam(name = "email") String email, @WebParam(name = "de") Date de,
			@WebParam(name = "ate") Date ate) {
		logger.info("Busca realizada via WS, historico dos simulados realizados por: "+ email+", no periodo:"+de+
				"a "+ate);
		UsuarioSimuladoRN usuarioSimuladoRN = new UsuarioSimuladoRN();
		UsuarioRN usuarioRN = new UsuarioRN();
		List<Historico> retorno = new ArrayList<Historico>();
		Historico historicoItem = null;
		//System.out.println(email);
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
