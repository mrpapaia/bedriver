package br.com.bedriver.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.event.data.PageEvent;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import br.com.bedriver.model.Pergunta;
import br.com.bedriver.rn.PerguntaRN;
import br.com.bedriver.rn.SimuladoRN;

@ManagedBean(name = "perguntaBean")
@SessionScoped
public class PerguntaBean {
	private Pergunta pergunta = new Pergunta();
	private List<Pergunta> lista;
	private List<String> alternativas;
	private int indexPergunta;
	private Integer[] resultados;
	private int idSimuladoAtual;

	public List<Pergunta> getLista(int idSimuladoEscolhido) {

		if (this.lista == null || idSimuladoEscolhido != idSimuladoAtual) {
			System.out.println("VAZIO");
			SimuladoRN simuladoRN = new SimuladoRN();
			this.lista = simuladoRN.buscar(idSimuladoEscolhido).getPerguntas();
			resultados = new Integer[lista.size()];
		}

		this.idSimuladoAtual = idSimuladoEscolhido;

		return this.lista;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta p) {
		this.pergunta = p;
	}

	public int getIndexPergunta() {
		return indexPergunta;
	}

	public void setIndexPergunta(int indexPergunta) {
		this.indexPergunta = indexPergunta;
	}

	public List<String> getAlternativas(Pergunta pergunta) {

		this.pergunta = pergunta;
		String[] alternativa = pergunta.getAlternativas().split(";");
		alternativas = Arrays.asList(alternativa);
		
		System.out.println("RESP SALVA: " + resultados[lista.indexOf(pergunta)]);
		
		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public void getTeste(AjaxBehaviorEvent event) {
		
		try {

			SelectOneRadio sor = (SelectOneRadio) event.getComponent();

			int indexPergunta = lista.indexOf(pergunta);
			int resposta = pergunta.getResposta();
			int selecionado = alternativas.indexOf(sor.getSubmittedValue().toString());

			resultados[indexPergunta] = selecionado;
			System.out.println("pergunta id: " + indexPergunta + 
					" alternativa: " + selecionado + 
					" resposta: " + resposta + 
					" acertou? " + (selecionado == resposta));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("exeção");
		}

	}

}
