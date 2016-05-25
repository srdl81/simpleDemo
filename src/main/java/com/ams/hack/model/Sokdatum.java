
package com.ams.hack.model;

import java.util.HashMap;
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
    "id",
    "namn",
    "antal_platsannonser",
    "antal_ledigajobb"
})
public class Sokdatum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("namn")
    private String namn;
    @JsonProperty("antal_platsannonser")
    private Integer antalPlatsannonser;
    @JsonProperty("antal_ledigajobb")
    private Integer antalLedigajobb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The namn
     */
    @JsonProperty("namn")
    public String getNamn() {
        return namn;
    }

    /**
     * 
     * @param namn
     *     The namn
     */
    @JsonProperty("namn")
    public void setNamn(String namn) {
        this.namn = namn;
    }

    /**
     * 
     * @return
     *     The antalPlatsannonser
     */
    @JsonProperty("antal_platsannonser")
    public Integer getAntalPlatsannonser() {
        return antalPlatsannonser;
    }

    /**
     * 
     * @param antalPlatsannonser
     *     The antal_platsannonser
     */
    @JsonProperty("antal_platsannonser")
    public void setAntalPlatsannonser(Integer antalPlatsannonser) {
        this.antalPlatsannonser = antalPlatsannonser;
    }

    /**
     * 
     * @return
     *     The antalLedigajobb
     */
    @JsonProperty("antal_ledigajobb")
    public Integer getAntalLedigajobb() {
        return antalLedigajobb;
    }

    /**
     * 
     * @param antalLedigajobb
     *     The antal_ledigajobb
     */
    @JsonProperty("antal_ledigajobb")
    public void setAntalLedigajobb(Integer antalLedigajobb) {
        this.antalLedigajobb = antalLedigajobb;
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
