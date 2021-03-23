package br.com.bedriver.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestScoped
public class AutoEscolaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AutoEscola rateResponse;
	private MapModel simpleModel;
	private LatLng coordIni;
	private String cidade;
	private String address;
	private String geo = "49.817491999999992, 15.4729620";
	private static final Logger logger = LogManager.getLogger(EstadoBean.class);

	public AutoEscola getAutoEscola() {

		RestTemplate restTemplate = new RestTemplate();
		System.out.println("getAuto: " + cidade);
		rateResponse = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/place/textsearch/json?input=Auto%Escolas%em%" + cidade
						+ "&inputtype=textquery&fields=name,geometry&key=AIzaSyBVvrkOP2LWY3QF4noU1I081zQelL0JXGA",
				AutoEscola.class);

		logger.info(
				"Requisi��o REST realizada em https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome");

		return rateResponse;
	}
	
	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		System.out.println("INICIO");
		getAutoEscola();
		geo = rateResponse.getResults().get(0).getGeometry().getLocation().getLat() + ","
				+ rateResponse.getResults().get(0).getGeometry().getLocation().getLng();

		for (Result autoEscola : rateResponse.getResults()) {
			LatLng coord = new LatLng(autoEscola.getGeometry().getLocation().getLat(),
					autoEscola.getGeometry().getLocation().getLng());
			simpleModel.addOverlay(new Marker(coord, autoEscola.getName()));
		}
		// Shared coordinates
		/*
		 * LatLng coord1 = new LatLng(36.879466, 30.667648); LatLng coord2 = new
		 * LatLng(36.883707, 30.689216); LatLng coord3 = new LatLng(36.879703,
		 * 30.706707); LatLng coord4 = new LatLng(36.885233, 30.702323);
		 * 
		 * //Basic marker simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		 * simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		 * simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		 * simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
		 */
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
		System.out.println("get: "+ cidade);
		return cidade;
	}

	public void setCidade(String cidade) {
		System.out.println("set: "+ cidade);
		this.cidade = cidade;
	}

	public void updateMapCenter(ActionEvent ae) {
		System.out.println("click: " + cidade);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGeo() {
		System.out.println("GEO: " + geo);
		return geo;
	}

	public void setGeo(String geo) {

		this.geo = geo;
	}
}
