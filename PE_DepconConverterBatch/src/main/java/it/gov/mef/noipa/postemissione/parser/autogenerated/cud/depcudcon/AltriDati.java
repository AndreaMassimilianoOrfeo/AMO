//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.05 at 04:07:17 PM CET 
//


package it.gov.mef.noipa.postemissione.parser.autogenerated.cud.depcudcon;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AltriDati complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AltriDati">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordDFN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dettaglio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maggioreRitenuta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="casiParticolari" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AltriDati", propOrder = {
    "recordDFN",
    "dettaglio",
    "recordDFO",
    "maggioreRitenuta",
    "casiParticolari"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class AltriDati {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFN;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String dettaglio;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFO;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String maggioreRitenuta;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String casiParticolari;

    /**
     * Gets the value of the recordDFN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFN() {
        return recordDFN;
    }

    /**
     * Sets the value of the recordDFN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFN(String value) {
        this.recordDFN = value;
    }

    /**
     * Gets the value of the dettaglio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDettaglio() {
        return dettaglio;
    }

    /**
     * Sets the value of the dettaglio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDettaglio(String value) {
        this.dettaglio = value;
    }

    /**
     * Gets the value of the recordDFO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFO() {
        return recordDFO;
    }

    /**
     * Sets the value of the recordDFO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFO(String value) {
        this.recordDFO = value;
    }

    /**
     * Gets the value of the maggioreRitenuta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getMaggioreRitenuta() {
        return maggioreRitenuta;
    }

    /**
     * Sets the value of the maggioreRitenuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setMaggioreRitenuta(String value) {
        this.maggioreRitenuta = value;
    }

    /**
     * Gets the value of the casiParticolari property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getCasiParticolari() {
        return casiParticolari;
    }

    /**
     * Sets the value of the casiParticolari property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCasiParticolari(String value) {
        this.casiParticolari = value;
    }

}
