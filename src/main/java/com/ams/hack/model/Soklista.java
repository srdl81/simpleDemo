
package com.ams.hack.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "listnamn",
    "totalt_antal_platsannonser",
    "totalt_antal_ledigajobb",
    "sokdata"
})
public class Soklista {

    @JsonProperty("listnamn")
    private String listnamn;
    @JsonProperty("totalt_antal_platsannonser")
    private Integer totaltAntalPlatsannonser;
    @JsonProperty("totalt_antal_ledigajobb")
    private Integer totaltAntalLedigajobb;
    @JsonProperty("sokdata")
    private List<Sokdatum> sokdata = new ArrayList<Sokdatum>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The listnamn
     */
    @JsonProperty("listnamn")
    public String getListnamn() {
        return listnamn;
    }

    /**
     * 
     * @param listnamn
     *     The listnamn
     */
    @JsonProperty("listnamn")
    public void setListnamn(String listnamn) {
        this.listnamn = listnamn;
    }

    /**
     * 
     * @return
     *     The totaltAntalPlatsannonser
     */
    @JsonProperty("totalt_antal_platsannonser")
    public Integer getTotaltAntalPlatsannonser() {
        return totaltAntalPlatsannonser;
    }

    /**
     * 
     * @param totaltAntalPlatsannonser
     *     The totalt_antal_platsannonser
     */
    @JsonProperty("totalt_antal_platsannonser")
    public void setTotaltAntalPlatsannonser(Integer totaltAntalPlatsannonser) {
        this.totaltAntalPlatsannonser = totaltAntalPlatsannonser;
    }

    /**
     * 
     * @return
     *     The totaltAntalLedigajobb
     */
    @JsonProperty("totalt_antal_ledigajobb")
    public Integer getTotaltAntalLedigajobb() {
        return totaltAntalLedigajobb;
    }

    /**
     * 
     * @param totaltAntalLedigajobb
     *     The totalt_antal_ledigajobb
     */
    @JsonProperty("totalt_antal_ledigajobb")
    public void setTotaltAntalLedigajobb(Integer totaltAntalLedigajobb) {
        this.totaltAntalLedigajobb = totaltAntalLedigajobb;
    }

    /**
     * 
     * @return
     *     The sokdata
     */
    @JsonProperty("sokdata")
    public List<Sokdatum> getSokdata() {
        return sokdata;
    }

    /**
     * 
     * @param sokdata
     *     The sokdata
     */
    @JsonProperty("sokdata")
    public void setSokdata(List<Sokdatum> sokdata) {
        this.sokdata = sokdata;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
