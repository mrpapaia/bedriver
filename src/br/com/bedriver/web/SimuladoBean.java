package br.com.bedriver.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

import br.com.bedriver.model.Simulado;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.rn.SimuladoRN;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.rn.UsuarioSimuladoRN;
import br.com.bedriver.util.RelatorioUtil;
import br.com.bedriver.util.UtilException;

@ManagedBean(name = "simuladoBean")
@RequestScoped
public class SimuladoBean {

	private StreamedContent arquivoRetorno;
	private Date dataInicialRelatorio;
	private Date dataFinalRelatorio;

	private Simulado simulado = new Simulado();
	private List<Simulado> lista;
	private Simulado simuladoEscolhido;
	private static final Logger logger = LogManager.getLogger(SimuladoBean.class);

	public String salvar() {
		SimuladoRN simuladoRN = new SimuladoRN();
		logger.info("Simulado finalizado e salvo");
		simuladoRN.salvar(this.simulado);
		return "/index";
	}

	public List<Simulado> getLista() {
		logger.info("Listando simulados");
		if (this.lista == null) {
			SimuladoRN simuladoRN = new SimuladoRN();
			this.lista = simuladoRN.listar();
		}
		return this.lista;
	}

	public Simulado getSimulado() {
		return simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public Simulado getSimuladoEscolhido() {
		return simuladoEscolhido;
	}

	public String setSimuladoEscolhido(Simulado simuladoEscolhido) {
		this.simuladoEscolhido = simuladoEscolhido;
		logger.info("Simulado iniciado");
		return "/restrito/pergunta.xhtml";
	}

	public List<UsuarioSimulado> simuladosRealizados() {
		Usuario u = getUsuarioLogado();
		UsuarioSimuladoRN usuarioSimuladoRN = new UsuarioSimuladoRN();
		logger.info("Simulado realizados pelo usuario:"+ u.getEmail());
		return usuarioSimuladoRN.listar(u, null, null);
	}

	public StreamedContent getArquivoRetorno() {
		System.out.println("entrou");
		FacesContext context = FacesContext.getCurrentInstance();

		Usuario u = getUsuarioLogado();
		String[] splitNome = u.getNome().split(" ");
		String nomeUser = (splitNome.length > 0) ? splitNome[0] : u.getNome();
		String nomeRelatorioJasper = "simuladorelatorio";
		String nomeRelatorioSaida = nomeUser.toLowerCase() + "_simulados";

		RelatorioUtil relatorioUtil = new RelatorioUtil();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String usuarioemail = u.getEmail();
		String datainicio = sdf.format(dataInicialRelatorio);
		String datafim = sdf.format(dataFinalRelatorio);

		

		HashMap parametrosRelatorio = new HashMap();
		parametrosRelatorio.put("usuarioemail", usuarioemail);
		parametrosRelatorio.put("datainicio", datainicio);
		parametrosRelatorio.put("datafim", datafim);

		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper,
					nomeRelatorioSaida, RelatorioUtil.RELATORIO_PDF);
			
			if (this.arquivoRetorno == null) {
				logger.error( new NullPointerException());				
			}
		
		} catch (UtilException e) {
			logger.error(e);
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		} catch (NullPointerException e) {
			
			logger.error(e);
			return null;
		}
		
		logger.info("Relatorio gerado pelo usuario: "+ u.getEmail());
		return this.arquivoRetorno;
	}

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (login != null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			Usuario usuario = usuarioRN.buscarPorLogin(login);
			return usuario;
		}
		return null;
	}

	public Date getDataInicialRelatorio() {
		return dataInicialRelatorio;
	}

	public void setDataInicialRelatorio(Date dataInicialRelatorio) {
		this.dataInicialRelatorio = dataInicialRelatorio;
	}

	public Date getDataFinalRelatorio() {
		return dataFinalRelatorio;
	}

	public void setDataFinalRelatorio(Date dataFinalRelatorio) {
		this.dataFinalRelatorio = dataFinalRelatorio;
	}

	public void setArquivoRetorno(StreamedContent arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}

}
