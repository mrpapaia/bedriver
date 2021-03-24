package br.com.bedriver.gmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Viewport {
	@JsonProperty("northeast")
	public Northeast getNortheast() {
		return this.northeast;
	}

	public void setNortheast(Northeast northeast) {
		this.northeast = northeast;
	}

	Northeast northeast;

	@JsonProperty("southwest")
	public Southwest getSouthwest() {
		return this.southwest;
	}

	public void setSouthwest(Southwest southwest) {
		this.southwest = southwest;
	}

	Southwest southwest;

	@Override
	public String toString() {
		return "Viewport [northeast=" + northeast + ", southwest=" + southwest + "]";
	}

}
