package br.com.bedriver.graficos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.*;

import br.com.bedriver.model.Condutor;
import br.com.bedriver.rn.CondutorRN;

@ManagedBean(name="chartPieView")
public class ChartPieView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PieChartModel pieModel;
    
    @PostConstruct
    public void init() {
        createPieModel();
    }
    
    private void createPieModel() {
    	
        pieModel = new PieChartModel();
        
        Map<String, Number> dados = new HashMap<>();
        
        CondutorRN condutorRN = new CondutorRN();
        List<Condutor> listaCondutores = condutorRN.listar();
        
        Integer qtdMasculino = 0;
        Integer qtdFeminino = 0;
        
        for(Condutor c : listaCondutores) {
        	switch (c.getSexo()) {
				case "M": qtdMasculino += c.getQtd_habilitados(); break;
				case "F": qtdFeminino  += c.getQtd_habilitados(); break;
        	}
        }
        
        dados.put("Masculino", qtdMasculino);
        dados.put("Feminino", qtdFeminino);
        
        pieModel.setData(dados);
        pieModel.setSeriesColors("FF6384, 36A2EB");
        pieModel.setTitle("Sexo dos Condutores");
        pieModel.setShowDataLabels(true);
        pieModel.setDataLabelFormatString("%d %%");
        pieModel.setLegendPosition("w");
    }
   
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}