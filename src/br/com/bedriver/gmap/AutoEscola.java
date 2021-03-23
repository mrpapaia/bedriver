package br.com.bedriver.gmap; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
public class AutoEscola{
    @JsonProperty("html_attributions") 
    public List<Object> getHtml_attributions() { 
		 return this.html_attributions; } 
    public void setHtml_attributions(List<Object> html_attributions) { 
		 this.html_attributions = html_attributions; } 
    List<Object> html_attributions;
    @JsonProperty("next_page_token") 
    public String getNext_page_token() { 
		 return this.next_page_token; } 
    public void setNext_page_token(String next_page_token) { 
		 this.next_page_token = next_page_token; } 
    String next_page_token;
    @JsonProperty("results") 
    public List<Result> getResults() { 
		 return this.results; } 
    public void setResults(List<Result> results) { 
		 this.results = results; } 
    List<Result> results;
    @JsonProperty("status") 
    public String getStatus() { 
		 return this.status; } 
    public void setStatus(String status) { 
		 this.status = status; } 
    String status;
	@Override
	public String toString() {
		return "AutoEscola [html_attributions=" + html_attributions + ", next_page_token=" + next_page_token
				+ ", results=" + results + ", status=" + status + "]";
	}
    
    
}
