package br.com.bedriver.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.data.PageEvent;
import org.springframework.util.SystemPropertyUtils;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import br.com.bedriver.model.Pergunta;
import br.com.bedriver.model.Usuario;
import br.com.bedriver.model.UsuarioSimulado;
import br.com.bedriver.rn.PerguntaRN;
import br.com.bedriver.rn.SimuladoRN;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.rn.UsuarioSimuladoRN;

@ManagedBean(name = "perguntaBean")
@ViewScoped
public class PerguntaBean {
	
	private Pergunta pergunta = new Pergunta();
	private List<Pergunta> lista;
	private List<String> alternativas;
	private int indexPergunta;
	private int[] resultados;
	private int idSimuladoAtual;
	private String alternativaSalva;

	public List<Pergunta> getLista(int idSimuladoEscolhido) {

		if (this.lista == null || idSimuladoEscolhido != idSimuladoAtual) {
			System.out.println("VAZIO");
			SimuladoRN simuladoRN = new SimuladoRN();
			this.lista = simuladoRN.buscar(idSimuladoEscolhido).getPerguntas();
			resultados = new int[lista.size()];
		}

		this.idSimuladoAtual = idSimuladoEscolhido;

		return this.lista;
	}
	
	public String getAlternativaSalva() {
		int saveResp = resultados[indexPergunta];
		alternativaSalva = (saveResp != 0) ? alternativas.get(saveResp-1) : "";
		return alternativaSalva;
	}

	public void setAlternativaSalva(String alternativaSalva) {
		this.alternativaSalva = alternativaSalva;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta p) {
		this.pergunta = p;
	}

	public int getIndexPergunta(Pergunta p) {
		System.out.println("etra aq msm");
		this.indexPergunta = this.lista.indexOf(p);
		this.pergunta = p;
		return indexPergunta + 1;
	}

	public void setIndexPergunta(int indexPergunta) {
		this.indexPergunta = indexPergunta;
	}

	public List<String> getAlternativas() {

		String[] alternativa = this.pergunta.getAlternativas().split(";");
		alternativas = Arrays.asList(alternativa);

		System.out.println("RESP SALVA: " + resultados[indexPergunta]);

		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public void getTeste(AjaxBehaviorEvent event) {

		try {

			SelectOneRadio sor = (SelectOneRadio) event.getComponent();

			int resposta = pergunta.getResposta();
			int selecionado = alternativas.indexOf(sor.getSubmittedValue().toString());

			resultados[indexPergunta] = selecionado + 1;

			System.out.println("pergunta id: " + indexPergunta + " alternativa: " + selecionado + " resposta: "
					+ resposta + " acertou? " + (selecionado == resposta));

		} catch (IndexOutOfBoundsException e) {
			System.out.println("exeção");
		}

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

	public String finalizarSimulado() {

		UsuarioSimulado usuarioSimulado = new UsuarioSimulado();
		SimuladoRN simuladoRN = new SimuladoRN();

		int nota = 0;

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(
					"Pergunta: " + (i+1) + " Marcada: " + resultados[i] + " Resposta: " + (lista.get(i).getResposta() + 1)
							+ " Acertou? " + (resultados[i] == lista.get(i).getResposta() + 1 ? "Sim" : "N�o"));
			
			if (resultados[i] == lista.get(i).getResposta() + 1) {
				nota += 1;
			}
		}

		usuarioSimulado.setUsuario(getUsuarioLogado());
		usuarioSimulado.setSimulado(simuladoRN.buscar(idSimuladoAtual));
		usuarioSimulado.setNota(nota);
		usuarioSimulado.setDataRealizado(new Date());

		UsuarioSimuladoRN rn = new UsuarioSimuladoRN();
		rn.salvar(usuarioSimulado);

		return "/public/histsimulado.xhtml";

	}

}
