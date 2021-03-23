package br.com.bedriver.gmap; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class PlusCode{
    @JsonProperty("compound_code") 
    public String getCompound_code() { 
		 return this.compound_code; } 
    public void setCompound_code(String compound_code) { 
		 this.compound_code = compound_code; } 
    String compound_code;
    @JsonProperty("global_code") 
    public String getGlobal_code() { 
		 return this.global_code; } 
    public void setGlobal_code(String global_code) { 
		 this.global_code = global_code; } 
    String global_code;
	@Override
	public String toString() {
		return "PlusCode [compound_code=" + compound_code + ", global_code=" + global_code + "]";
	}
    
    
}
