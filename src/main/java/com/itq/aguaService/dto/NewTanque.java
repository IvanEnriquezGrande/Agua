//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.18 at 11:00:53 AM CDT 
//


package com.itq.aguaService.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zona"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="capacidad"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="tiempoLlenado"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zona",
    "capacidad",
    "tiempoLlenado"
})
@XmlRootElement(name = "newTanque")
public class NewTanque {

    protected int zona;
    protected int capacidad;
    protected int tiempoLlenado;

    /**
     * Gets the value of the zona property.
     * 
     */
    public int getZona() {
        return zona;
    }

    /**
     * Sets the value of the zona property.
     * 
     */
    public void setZona(int value) {
        this.zona = value;
    }

    /**
     * Gets the value of the capacidad property.
     * 
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Sets the value of the capacidad property.
     * 
     */
    public void setCapacidad(int value) {
        this.capacidad = value;
    }

    /**
     * Gets the value of the tiempoLlenado property.
     * 
     */
    public int getTiempoLlenado() {
        return tiempoLlenado;
    }

    /**
     * Sets the value of the tiempoLlenado property.
     * 
     */
    public void setTiempoLlenado(int value) {
        this.tiempoLlenado = value;
    }

}
