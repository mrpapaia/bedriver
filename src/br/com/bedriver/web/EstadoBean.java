package br.com.bedriver.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.bedriver.model.Estado;
import br.com.bedriver.rn.EstadoRN;
import br.com.bedriver.web.api.EstadoREST;
@ManagedBean(name = "estadoBean")
@RequestScoped
public class EstadoBean {

	private static final Logger logger = LogManager.getLogger(EstadoBean.class);
	
    public List<EstadoREST> getEstadosREST() {
    	
    	RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<EstadoREST>> rateResponse =
                restTemplate.exchange("https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<EstadoREST>>() {
                    });
        
        List<EstadoREST> estadosREST = rateResponse.getBody();
        
        logger.info("Requisição REST realizada em https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome");

        return estadosREST;
    }
}
