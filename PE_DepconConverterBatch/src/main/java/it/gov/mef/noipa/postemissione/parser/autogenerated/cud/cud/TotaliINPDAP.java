//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.05 at 04:07:19 PM CET 
//


package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotaliINPDAP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotaliINPDAP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totale_imponibile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totale_contributi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotaliINPDAP", propOrder = {
    "totaleImponibile",
    "totaleContributi"
})
public class TotaliINPDAP {

    @XmlElement(name = "totale_imponibile")
    protected String totaleImponibile;
    @XmlElement(name = "totale_contributi")
    protected String totaleContributi;

    /**
     * Gets the value of the totaleImponibile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotaleImponibile() {
        return totaleImponibile;
    }

    /**
     * Sets the value of the totaleImponibile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotaleImponibile(String value) {
        this.totaleImponibile = value;
    }

    /**
     * Gets the value of the totaleContributi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotaleContributi() {
        return totaleContributi;
    }

    /**
     * Sets the value of the totaleContributi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotaleContributi(String value) {
        this.totaleContributi = value;
    }

}
