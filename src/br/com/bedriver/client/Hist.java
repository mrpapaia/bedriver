package br.com.bedriver.client;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "hist", namespace = "http://webservice.bedriver.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hist {
	@XmlElement
	public List<Historico> getHistorico() {
		return this.Historico;
	}

	public void setHistorico(List<Historico> Historico) {
		this.Historico = Historico;
	}

	List<Historico> Historico;

	public String getNs2() {
		return this.Ns2;
	}

	public void setNs2(String Ns2) {
		this.Ns2 = Ns2;
	}

	String Ns2;

	public String getText() {
		return this.Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}

	String Text;

	@Override
	public String toString() {
		return "Hist [Historico=" + Historico + ", Ns2=" + Ns2 + ", Text=" + Text + "]";
	}
	
}
