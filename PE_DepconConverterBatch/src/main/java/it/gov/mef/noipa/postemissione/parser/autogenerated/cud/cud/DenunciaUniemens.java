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
 * <p>Java class for DenunciaUniemens complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DenunciaUniemens">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mesi_tutti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mesi_esclusi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DenunciaUniemens", propOrder = {
    "mesiTutti",
    "mesiEsclusi"
})
public class DenunciaUniemens {

    @XmlElement(name = "mesi_tutti")
    protected String mesiTutti;
    @XmlElement(name = "mesi_esclusi")
    protected String mesiEsclusi;

    /**
     * Gets the value of the mesiTutti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesiTutti() {
        return mesiTutti;
    }

    /**
     * Sets the value of the mesiTutti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesiTutti(String value) {
        this.mesiTutti = value;
    }

    /**
     * Gets the value of the mesiEsclusi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesiEsclusi() {
        return mesiEsclusi;
    }

    /**
     * Sets the value of the mesiEsclusi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesiEsclusi(String value) {
        this.mesiEsclusi = value;
    }

}
