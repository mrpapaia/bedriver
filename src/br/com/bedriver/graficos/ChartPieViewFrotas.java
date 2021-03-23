package br.com.bedriver.graficos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.*;

import br.com.bedriver.model.FrotaVeiculo;
import br.com.bedriver.rn.FrotaRN;

@ManagedBean(name="chartPieViewFrotas")
public class ChartPieViewFrotas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PieChartModel pieModel;
    
    @PostConstruct
    public void init() {
    	createPieModelFrotas();
    }
    
    private void createPieModelFrotas() {
    	
        pieModel = new PieChartModel();
        
        Map<String, Number> dados = new HashMap<>();
        
        FrotaRN frotaRN = new FrotaRN();
        List<FrotaVeiculo> listaFrotas = frotaRN.listar();
        HashMap<String, Integer> qtdVeiculos = new HashMap<>();
        
        for(FrotaVeiculo f : listaFrotas) {
        	String uf = f.getCidade().getEstado().getUf();
        	Integer qtdVeiculo = qtdVeiculos.get(uf);
        	if(qtdVeiculo == null){
        		qtdVeiculo = 0;
        	}
        	qtdVeiculos.put(uf, qtdVeiculo + f.getQtdVeiculos());
        }
        
        for(String estado : qtdVeiculos.keySet()) {
        	dados.put(estado, qtdVeiculos.get(estado));
        }

        pieModel.setData(dados);
        pieModel.setTitle("Porcentagem de Veículos por Estado");
        pieModel.setLegendCols(4);
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