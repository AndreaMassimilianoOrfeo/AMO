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
 * <p>Java class for PrevidenzaComplementare complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrevidenzaComplementare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordDFI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="previdenzaComp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contribPrevidenzaComp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordDFL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contribPrevCompNonDedotti" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TFRDesinatoFondo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrevidenzaComplementare", propOrder = {
    "recordDFI",
    "previdenzaComp",
    "contribPrevidenzaComp",
    "recordDFL",
    "contribPrevCompNonDedotti",
    "tfrDesinatoFondo"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class PrevidenzaComplementare {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFI;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String previdenzaComp;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String contribPrevidenzaComp;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordDFL;
    @XmlElement(required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String contribPrevCompNonDedotti;
    @XmlElement(name = "TFRDesinatoFondo", required = true, nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String tfrDesinatoFondo;

    /**
     * Gets the value of the recordDFI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFI() {
        return recordDFI;
    }

    /**
     * Sets the value of the recordDFI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFI(String value) {
        this.recordDFI = value;
    }

    /**
     * Gets the value of the previdenzaComp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getPrevidenzaComp() {
        return previdenzaComp;
    }

    /**
     * Sets the value of the previdenzaComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setPrevidenzaComp(String value) {
        this.previdenzaComp = value;
    }

    /**
     * Gets the value of the contribPrevidenzaComp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getContribPrevidenzaComp() {
        return contribPrevidenzaComp;
    }

    /**
     * Sets the value of the contribPrevidenzaComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setContribPrevidenzaComp(String value) {
        this.contribPrevidenzaComp = value;
    }

    /**
     * Gets the value of the recordDFL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordDFL() {
        return recordDFL;
    }

    /**
     * Sets the value of the recordDFL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordDFL(String value) {
        this.recordDFL = value;
    }

    /**
     * Gets the value of the contribPrevCompNonDedotti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getContribPrevCompNonDedotti() {
        return contribPrevCompNonDedotti;
    }

    /**
     * Sets the value of the contribPrevCompNonDedotti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setContribPrevCompNonDedotti(String value) {
        this.contribPrevCompNonDedotti = value;
    }

    /**
     * Gets the value of the tfrDesinatoFondo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getTFRDesinatoFondo() {
        return tfrDesinatoFondo;
    }

    /**
     * Sets the value of the tfrDesinatoFondo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setTFRDesinatoFondo(String value) {
        this.tfrDesinatoFondo = value;
    }

}