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
 * <p>Java class for DetrazioniCrediti complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetrazioniCrediti">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordDFD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="impostaLorda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detrCarichiFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detrFamNumerose" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="credNonRicFamNumerose" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFF" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detrLavDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detrCanoniLocazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditoNonRicCanoniLoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totaleDetrazioni" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFH" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codiceBonus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bonusErogato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bonusNonErogato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetrazioniCrediti", propOrder = {
    "recordDFD",
    "impostaLorda",
    "detrCarichiFamiglia",
    "recordDFE",
    "detrFamNumerose",
    "credNonRicFamNumerose",
    "recordDFF",
    "detrLavDip",
    "detrCanoniLocazione",
    "recordDFG",
    "creditoNonRicCanoniLoc",
    "totaleDetrazioni",
    "recordDFH",
    "codiceBonus",
    "bonusErogato",
    "bonusNonErogato"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class DetrazioniCrediti {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFD;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String impostaLorda;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String detrCarichiFamiglia;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFE;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String detrFamNumerose;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String credNonRicFamNumerose;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFF;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String detrLavDip;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String detrCanoniLocazione;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFG;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String creditoNonRicCanoniLoc;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String totaleDetrazioni;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFH;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String codiceBonus;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String bonusErogato;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String bonusNonErogato;

    /**
     * Gets the value of the recordDFD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFD() {
        return recordDFD;
    }

    /**
     * Sets the value of the recordDFD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFD(String value) {
        this.recordDFD = value;
    }

    /**
     * Gets the value of the impostaLorda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getImpostaLorda() {
        return impostaLorda;
    }

    /**
     * Sets the value of the impostaLorda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setImpostaLorda(String value) {
        this.impostaLorda = value;
    }

    /**
     * Gets the value of the detrCarichiFamiglia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDetrCarichiFamiglia() {
        return detrCarichiFamiglia;
    }

    /**
     * Sets the value of the detrCarichiFamiglia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDetrCarichiFamiglia(String value) {
        this.detrCarichiFamiglia = value;
    }

    /**
     * Gets the value of the recordDFE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFE() {
        return recordDFE;
    }

    /**
     * Sets the value of the recordDFE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFE(String value) {
        this.recordDFE = value;
    }

    /**
     * Gets the value of the detrFamNumerose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDetrFamNumerose() {
        return detrFamNumerose;
    }

    /**
     * Sets the value of the detrFamNumerose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDetrFamNumerose(String value) {
        this.detrFamNumerose = value;
    }

    /**
     * Gets the value of the credNonRicFamNumerose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getCredNonRicFamNumerose() {
        return credNonRicFamNumerose;
    }

    /**
     * Sets the value of the credNonRicFamNumerose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCredNonRicFamNumerose(String value) {
        this.credNonRicFamNumerose = value;
    }

    /**
     * Gets the value of the recordDFF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFF() {
        return recordDFF;
    }

    /**
     * Sets the value of the recordDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFF(String value) {
        this.recordDFF = value;
    }

    /**
     * Gets the value of the detrLavDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDetrLavDip() {
        return detrLavDip;
    }

    /**
     * Sets the value of the detrLavDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDetrLavDip(String value) {
        this.detrLavDip = value;
    }

    /**
     * Gets the value of the detrCanoniLocazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDetrCanoniLocazione() {
        return detrCanoniLocazione;
    }

    /**
     * Sets the value of the detrCanoniLocazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDetrCanoniLocazione(String value) {
        this.detrCanoniLocazione = value;
    }

    /**
     * Gets the value of the recordDFG property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFG() {
        return recordDFG;
    }

    /**
     * Sets the value of the recordDFG property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFG(String value) {
        this.recordDFG = value;
    }

    /**
     * Gets the value of the creditoNonRicCanoniLoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getCreditoNonRicCanoniLoc() {
        return creditoNonRicCanoniLoc;
    }

    /**
     * Sets the value of the creditoNonRicCanoniLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCreditoNonRicCanoniLoc(String value) {
        this.creditoNonRicCanoniLoc = value;
    }

    /**
     * Gets the value of the totaleDetrazioni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getTotaleDetrazioni() {
        return totaleDetrazioni;
    }

    /**
     * Sets the value of the totaleDetrazioni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setTotaleDetrazioni(String value) {
        this.totaleDetrazioni = value;
    }

    /**
     * Gets the value of the recordDFH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFH() {
        return recordDFH;
    }

    /**
     * Sets the value of the recordDFH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFH(String value) {
        this.recordDFH = value;
    }

    /**
     * Gets the value of the codiceBonus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getCodiceBonus() {
        return codiceBonus;
    }

    /**
     * Sets the value of the codiceBonus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCodiceBonus(String value) {
        this.codiceBonus = value;
    }

    /**
     * Gets the value of the bonusErogato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getBonusErogato() {
        return bonusErogato;
    }

    /**
     * Sets the value of the bonusErogato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setBonusErogato(String value) {
        this.bonusErogato = value;
    }

    /**
     * Gets the value of the bonusNonErogato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getBonusNonErogato() {
        return bonusNonErogato;
    }

    /**
     * Sets the value of the bonusNonErogato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setBonusNonErogato(String value) {
        this.bonusNonErogato = value;
    }

}
