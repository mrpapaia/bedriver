package br.com.bedriver.graficos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.*;

import br.com.bedriver.model.FrotaVeiculo;
import br.com.bedriver.model.Infracoe;
import br.com.bedriver.rn.FrotaRN;
import br.com.bedriver.rn.InfracaoRN;

@ManagedBean(name="chartPieViewInfracoes")
public class ChartPieViewInfracoes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PieChartModel pieModel;
    
    @PostConstruct
    public void init() {
    	createPieModelInfracoes();
    }
    
    private void createPieModelInfracoes() {
    	
        pieModel = new PieChartModel();
        
        Map<String, Number> dados = new HashMap<>();
        
        InfracaoRN infracaoRN = new InfracaoRN();
        List<Infracoe> listaInfracoes = infracaoRN.listar();
        HashMap<String, Integer> qtdInfracoes = new HashMap<>();
        
        for(Infracoe i : listaInfracoes) {
        	String uf = i.getEstado().getUf();
        	Integer qtdInfracao = qtdInfracoes.get(uf);
        	if(qtdInfracao == null){
        		qtdInfracao = 0;
        	}
        	qtdInfracoes.put(uf, qtdInfracao + i.getQuantidade());
        }
        
        for(String uf : qtdInfracoes.keySet()) {
        	dados.put(uf, qtdInfracoes.get(uf));
        }

        pieModel.setData(dados);
        pieModel.setTitle("Porcentagem de Infracões por Estado");
        pieModel.setLegendCols(6);
        pieModel.setShowDataLabels(true);
        pieModel.setDataLabelFormatString("%d %%");
        pieModel.setLegendPosition("e");
    }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}