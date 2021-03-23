package br.com.bedriver.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.*;

import br.com.bedriver.gmap.AutoEscola;
import br.com.bedriver.gmap.Result;

@ManagedBean(name = "autoescolaBean")
@ViewScoped
public class AutoEscolaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AutoEscola rateResponse;
	private MapModel simpleModel;
	private LatLng coordIni;
	private String cidade;
	private String fotoRef;
	private String geo = "49.817491999999992, 15.4729620";
	private Marker marker;

	private static final Logger logger = LogManager.getLogger(EstadoBean.class);

	public void getAutoEscola(String nome) {

		RestTemplate restTemplate = new RestTemplate();

		rateResponse = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/place/textsearch/json?input=Auto%Escolas%em%" + nome
						+ "&inputtype=textquery&fields=name,geometry&key=AIzaSyBVvrkOP2LWY3QF4noU1I081zQelL0JXGA",
				AutoEscola.class);

		logger.info(
				"Requisi��o REST realizada em https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome");

		simpleModel = new DefaultMapModel();
		geo = rateResponse.getResults().get(0).getGeometry().getLocation().getLat() + ","
				+ rateResponse.getResults().get(0).getGeometry().getLocation().getLng();

		for (Result autoEscola : rateResponse.getResults()) {
			LatLng coord = new LatLng(autoEscola.getGeometry().getLocation().getLat(),
					autoEscola.getGeometry().getLocation().getLng());

			simpleModel.addOverlay(new Marker(coord, autoEscola.getName(), autoEscola));
			// simpleModel.addOverlay(new Marker(coord, autoEscola.getName()));
		}
		// return rateResponse;
	}

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		
		getAutoEscola("ipameri");
		geo = rateResponse.getResults().get(0).getGeometry().getLocation().getLat() + ","
				+ rateResponse.getResults().get(0).getGeometry().getLocation().getLng();

		for (Result autoEscola : rateResponse.getResults()) {
			LatLng coord = new LatLng(autoEscola.getGeometry().getLocation().getLat(),
					autoEscola.getGeometry().getLocation().getLng());
			Marker a = new Marker(coord, autoEscola.getName());

			simpleModel.addOverlay(a);
		}
		
		 
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public LatLng getCoordIni() {
		return coordIni;
	}

	public void setCoordIni(LatLng coordIni) {
		this.coordIni = coordIni;
	}

	public String getCidade() {
		
		return cidade;
	}

	public void setCidade(String cidade) {
		
		this.cidade = cidade;
	}



	public void onMarkerSelect(OverlaySelectEvent event) {
 
		marker = (Marker) event.getOverlay();
		fotoRef = ((Result) marker.getData()).getPhotos().get(0).getPhoto_reference();
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));

	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public String getFotoRef() {
		return fotoRef;
	}

	public void setFotoRef(String fotoRef) {
		this.fotoRef = fotoRef;
	}

}
