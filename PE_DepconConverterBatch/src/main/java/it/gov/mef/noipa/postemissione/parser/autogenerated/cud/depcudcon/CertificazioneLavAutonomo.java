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
 * <p>Java class for CertificazioneLavAutonomo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificazioneLavAutonomo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordCL1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipologiaReddituale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordCL2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ammontareLordo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imponibile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordCL3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ritenuteTitAcconto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificazioneLavAutonomo", propOrder = {
    "recordCL1",
    "tipologiaReddituale",
    "recordCL2",
    "ammontareLordo",
    "imponibile",
    "recordCL3",
    "ritenuteTitAcconto"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class CertificazioneLavAutonomo {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordCL1;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String tipologiaReddituale;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordCL2;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String ammontareLordo;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String imponibile;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordCL3;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String ritenuteTitAcconto;

    /**
     * Gets the value of the recordCL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordCL1() {
        return recordCL1;
    }

    /**
     * Sets the value of the recordCL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordCL1(String value) {
        this.recordCL1 = value;
    }

    /**
     * Gets the value of the tipologiaReddituale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getTipologiaReddituale() {
        return tipologiaReddituale;
    }

    /**
     * Sets the value of the tipologiaReddituale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setTipologiaReddituale(String value) {
        this.tipologiaReddituale = value;
    }

    /**
     * Gets the value of the recordCL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordCL2() {
        return recordCL2;
    }

    /**
     * Sets the value of the recordCL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordCL2(String value) {
        this.recordCL2 = value;
    }

    /**
     * Gets the value of the ammontareLordo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getAmmontareLordo() {
        return ammontareLordo;
    }

    /**
     * Sets the value of the ammontareLordo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setAmmontareLordo(String value) {
        this.ammontareLordo = value;
    }

    /**
     * Gets the value of the imponibile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getImponibile() {
        return imponibile;
    }

    /**
     * Sets the value of the imponibile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setImponibile(String value) {
        this.imponibile = value;
    }

    /**
     * Gets the value of the recordCL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordCL3() {
        return recordCL3;
    }

    /**
     * Sets the value of the recordCL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordCL3(String value) {
        this.recordCL3 = value;
    }

    /**
     * Gets the value of the ritenuteTitAcconto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRitenuteTitAcconto() {
        return ritenuteTitAcconto;
    }

    /**
     * Sets the value of the ritenuteTitAcconto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRitenuteTitAcconto(String value) {
        this.ritenuteTitAcconto = value;
    }

}
