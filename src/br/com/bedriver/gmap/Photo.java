package br.com.bedriver.gmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
	@JsonProperty("height")
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	int height;

	@JsonProperty("html_attributions")
	public List<String> getHtml_attributions() {
		return this.html_attributions;
	}

	public void setHtml_attributions(List<String> html_attributions) {
		this.html_attributions = html_attributions;
	}

	List<String> html_attributions;

	@JsonProperty("photo_reference")
	public String getPhoto_reference() {
		return this.photo_reference;
	}

	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}

	String photo_reference;

	@JsonProperty("width")
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	int width;

	@Override
	public String toString() {
		return "Photo [height=" + height + ", html_attributions=" + html_attributions + ", photo_reference="
				+ photo_reference + ", width=" + width + "]";
	}

}
