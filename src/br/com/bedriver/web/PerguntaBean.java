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

@ManagedBean(name = "perguntaBean")
@SessionScoped
public class PerguntaBean {
	private Pergunta pergunta = new Pergunta();
	private List<Pergunta> lista;
	private List<String> alternativas;
	private int indexPergunta;
	private String aux;
	//private HashMap<Integer, Integer> resultados = new HashMap<>();
	private Integer []resultados = new Integer[30];
	
	public List<Pergunta> getLista() {

		if (this.lista == null) {
			System.out.println("VAZIO");
			
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

	public List<String> getAlternativas(Pergunta pergunta) {
		this.pergunta = pergunta;
		System.out.println("as: "+lista.indexOf(pergunta));
		String[] alternativa = pergunta.getAlternativas().split(";");

		alternativas = Arrays.asList(alternativa);
		
		//Integer altSave = resultados.get(pergunta.getId()-1);

		//System.out.println("Valor altSave: " + altSave);
	try {
		System.out.println("lista: "+ resultados[pergunta.getId()-1]);
	}catch(IndexOutOfBoundsException e){
		System.out.println("Segue o baile");
	}
			
		

		return  alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void getTeste(AjaxBehaviorEvent event){
		try {SelectOneRadio sor = (SelectOneRadio)event.getComponent();
		
		int idPergunta = pergunta.getId();
		int resposta = pergunta.getResposta();
		int selecionado = alternativas.indexOf(sor.getSubmittedValue().toString());
		
		
	//resultados.put(idPergunta-1, selecionado);
		resultados[idPergunta-1]=selecionado;
		System.out.println("pergunta id: " + idPergunta
				+ " alternativa: " + selecionado 
				+ " resposta: " + resposta 
				+ " acertou? " + (selecionado == resposta));}catch (IndexOutOfBoundsException e) {
			System.out.println("exeção");
		}
		
	}

}
