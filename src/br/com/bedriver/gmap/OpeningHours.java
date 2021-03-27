package br.com.bedriver.gmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHours {
	@JsonProperty("open_now")
	public boolean getOpen_now() {
		return this.open_now;
	}

	public void setOpen_now(boolean open_now) {
		this.open_now = open_now;
	}

	boolean open_now;

	@Override
	public String toString() {
		return "OpeningHours [open_now=" + open_now + "]";
	}

}
