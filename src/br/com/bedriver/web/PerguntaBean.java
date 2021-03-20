package br.com.bedriver.web;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

@ManagedBean(name = "perguntaBean")
@RequestScoped
public class PerguntaBean {
	private Pergunta pergunta = new Pergunta();
	private List<Pergunta> lista;
	private List<String> alternativas;
	private int indexPergunta;
	private String aux;

	public List<Pergunta> getLista() {

		if (this.lista == null) {
			PerguntaRN perguntaRN = new PerguntaRN();
			this.lista = perguntaRN.listar();
		}
		return this.lista;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(int p) {
		if (this.lista == null) {
			PerguntaRN perguntaRN = new PerguntaRN();
			this.lista = perguntaRN.listar();
		}
		this.pergunta = this.lista.get(p);
	}

	public int getIndexPergunta() {
		return indexPergunta;
	}

	public void setIndexPergunta(int indexPergunta) {
		this.indexPergunta = indexPergunta;
	}

	public List<String> getAlternativas(String aux, Pergunta pergunta) {
		this.pergunta = pergunta;
		String[] alternativa = aux.split(";");

		alternativas = Arrays.asList(alternativa);

		return  alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void getTeste(AjaxBehaviorEvent event){
		SelectOneRadio sor = (SelectOneRadio)event.getComponent();
		
		int idPergunta = pergunta.getId();
		int resposta = pergunta.getResposta();
		int selecionado = alternativas.indexOf(sor.getSubmittedValue().toString());
		
		System.out.println("pergunta id: " + idPergunta
				+ " alternativa: " + selecionado 
				+ " resposta: " + resposta 
				+ " acertou? " + (selecionado == resposta));
	}

}
