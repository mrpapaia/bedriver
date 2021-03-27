package br.com.bedriver.gmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
	@JsonProperty("location")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	Location location;

	@JsonProperty("viewport")
	public Viewport getViewport() {
		return this.viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	Viewport viewport;

	@Override
	public String toString() {
		return "Geometry [location=" + location + ", viewport=" + viewport + "]";
	}

}
