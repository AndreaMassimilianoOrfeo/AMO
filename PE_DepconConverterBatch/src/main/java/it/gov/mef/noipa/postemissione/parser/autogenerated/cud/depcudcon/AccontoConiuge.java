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
 * <p>Java class for AccontoConiuge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccontoConiuge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordDF9" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primoAccontoIRPEFTrat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondoAccontoIRPEF" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accontoIrpefSospesi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accontoAddComunaleIrpef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accontoAddComunaleIrpefSospesa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primaRataAccCedSecca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondaRataAccCedSecca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccontoConiuge", propOrder = {
    "recordDF9",
    "primoAccontoIRPEFTrat",
    "recordDFA",
    "secondoAccontoIRPEF",
    "accontoIrpefSospesi",
    "recordDFB",
    "accontoAddComunaleIrpef",
    "accontoAddComunaleIrpefSospesa",
    "recordDFC",
    "primaRataAccCedSecca",
    "secondaRataAccCedSecca"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class AccontoConiuge {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDF9;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String primoAccontoIRPEFTrat;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFA;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String secondoAccontoIRPEF;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String accontoIrpefSospesi;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFB;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String accontoAddComunaleIrpef;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String accontoAddComunaleIrpefSospesa;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFC;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String primaRataAccCedSecca;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String secondaRataAccCedSecca;

    /**
     * Gets the value of the recordDF9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDF9() {
        return recordDF9;
    }

    /**
     * Sets the value of the recordDF9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDF9(String value) {
        this.recordDF9 = value;
    }

    /**
     * Gets the value of the primoAccontoIRPEFTrat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getPrimoAccontoIRPEFTrat() {
        return primoAccontoIRPEFTrat;
    }

    /**
     * Sets the value of the primoAccontoIRPEFTrat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setPrimoAccontoIRPEFTrat(String value) {
        this.primoAccontoIRPEFTrat = value;
    }

    /**
     * Gets the value of the recordDFA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFA() {
        return recordDFA;
    }

    /**
     * Sets the value of the recordDFA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFA(String value) {
        this.recordDFA = value;
    }

    /**
     * Gets the value of the secondoAccontoIRPEF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getSecondoAccontoIRPEF() {
        return secondoAccontoIRPEF;
    }

    /**
     * Sets the value of the secondoAccontoIRPEF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setSecondoAccontoIRPEF(String value) {
        this.secondoAccontoIRPEF = value;
    }

    /**
     * Gets the value of the accontoIrpefSospesi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getAccontoIrpefSospesi() {
        return accontoIrpefSospesi;
    }

    /**
     * Sets the value of the accontoIrpefSospesi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setAccontoIrpefSospesi(String value) {
        this.accontoIrpefSospesi = value;
    }

    /**
     * Gets the value of the recordDFB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFB() {
        return recordDFB;
    }

    /**
     * Sets the value of the recordDFB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFB(String value) {
        this.recordDFB = value;
    }

    /**
     * Gets the value of the accontoAddComunaleIrpef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getAccontoAddComunaleIrpef() {
        return accontoAddComunaleIrpef;
    }

    /**
     * Sets the value of the accontoAddComunaleIrpef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setAccontoAddComunaleIrpef(String value) {
        this.accontoAddComunaleIrpef = value;
    }

    /**
     * Gets the value of the accontoAddComunaleIrpefSospesa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getAccontoAddComunaleIrpefSospesa() {
        return accontoAddComunaleIrpefSospesa;
    }

    /**
     * Sets the value of the accontoAddComunaleIrpefSospesa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setAccontoAddComunaleIrpefSospesa(String value) {
        this.accontoAddComunaleIrpefSospesa = value;
    }

    /**
     * Gets the value of the recordDFC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFC() {
        return recordDFC;
    }

    /**
     * Sets the value of the recordDFC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFC(String value) {
        this.recordDFC = value;
    }

    /**
     * Gets the value of the primaRataAccCedSecca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getPrimaRataAccCedSecca() {
        return primaRataAccCedSecca;
    }

    /**
     * Sets the value of the primaRataAccCedSecca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setPrimaRataAccCedSecca(String value) {
        this.primaRataAccCedSecca = value;
    }

    /**
     * Gets the value of the secondaRataAccCedSecca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getSecondaRataAccCedSecca() {
        return secondaRataAccCedSecca;
    }

    /**
     * Sets the value of the secondaRataAccCedSecca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setSecondaRataAccCedSecca(String value) {
        this.secondaRataAccCedSecca = value;
    }

}
