package br.com.bedriver.graficos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.bedriver.model.CondutoresHab;
import br.com.bedriver.rn.CondutorRN;

@ManagedBean(name="chartBarViewCondutores")
public class ChartBarViewCondutores implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BarChartModel barModel;
    
    @PostConstruct
    public void init() {
    	createBarModelCondutores();
    }
    
    private void createBarModelCondutores() {
    	
    	barModel = new BarChartModel();

        CondutorRN condutorRN = new CondutorRN();
        List<CondutoresHab> listaCondutores = condutorRN.listar();
        
        Map<Object, Number> qtdCat = new HashMap<>();

        for(CondutoresHab c : listaCondutores) {
        	String catAtual = c.getCategoriaCnh().getId();
    		if(qtdCat.get(catAtual) == null) {
    			qtdCat.put(catAtual, 0);
    		}
    		qtdCat.put(catAtual, 
    				Integer.valueOf(qtdCat.get(catAtual).intValue() + c.getQtdHabilitados()));
        }
        
    	ChartSeries serie = new ChartSeries();
    	serie.setData(qtdCat);
    	barModel.addSeries(serie);
       
        barModel.setTitle("Quantidade de CNH's");
    }

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}