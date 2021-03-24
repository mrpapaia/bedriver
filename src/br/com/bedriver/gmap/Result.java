package br.com.bedriver.gmap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	@JsonProperty("business_status")
	public String getBusiness_status() {
		return this.business_status;
	}

	public void setBusiness_status(String business_status) {
		this.business_status = business_status;
	}

	String business_status;

	@JsonProperty("formatted_address")
	public String getFormatted_address() {
		return this.formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	String formatted_address;

	@JsonProperty("geometry")
	public Geometry getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	Geometry geometry;

	@JsonProperty("icon")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	String icon;

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	@JsonProperty("opening_hours")
	public OpeningHours getOpening_hours() {
		return this.opening_hours;
	}

	public void setOpening_hours(OpeningHours opening_hours) {
		this.opening_hours = opening_hours;
	}

	OpeningHours opening_hours;

	@JsonProperty("photos")
	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	List<Photo> photos;

	@JsonProperty("place_id")
	public String getPlace_id() {
		return this.place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	String place_id;

	@JsonProperty("plus_code")
	public PlusCode getPlus_code() {
		return this.plus_code;
	}

	public void setPlus_code(PlusCode plus_code) {
		this.plus_code = plus_code;
	}

	PlusCode plus_code;

	@JsonProperty("rating")
	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	double rating;

	@JsonProperty("reference")
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	String reference;

	@JsonProperty("types")
	public List<String> getTypes() {
		return this.types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	List<String> types;

	@JsonProperty("user_ratings_total")
	public int getUser_ratings_total() {
		return this.user_ratings_total;
	}

	public void setUser_ratings_total(int user_ratings_total) {
		this.user_ratings_total = user_ratings_total;
	}

	int user_ratings_total;

	@Override
	public String toString() {
		return "Result [business_status=" + business_status + ", formatted_address=" + formatted_address + ", geometry="
				+ geometry + ", icon=" + icon + ", name=" + name + ", opening_hours=" + opening_hours + ", photos="
				+ photos + ", place_id=" + place_id + ", plus_code=" + plus_code + ", rating=" + rating + ", reference="
				+ reference + ", types=" + types + ", user_ratings_total=" + user_ratings_total + "]";
	}

}
