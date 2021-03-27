package br.com.bedriver.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "radioView")
public class RadioView {

    private String console;
    private String city; 
    private String city2; 
    private List<String> cities;
    private String color;

    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Resposta A");
        cities.add("Resposta B");
        cities.add("Resposta C");
        cities.add("Resposta D");
        cities.add("Resposta E");
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getCities() {
        return cities;
    }
}