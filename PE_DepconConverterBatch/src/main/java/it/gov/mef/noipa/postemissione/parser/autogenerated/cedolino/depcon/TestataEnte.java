//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.05 at 04:07:18 PM CET 
//


package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.depcon;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TestataEnte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestataEnte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneEnte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indirizzoEnte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestataEnte", propOrder = {
    "recordId",
    "descrizioneEnte",
    "indirizzoEnte"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class TestataEnte {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String recordId;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String descrizioneEnte;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected String indirizzoEnte;

    /**
     * Gets the value of the recordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getRecordId() {
        return recordId;
    }

    /**
     * Sets the value of the recordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRecordId(String value) {
        this.recordId = value;
    }

    /**
     * Gets the value of the descrizioneEnte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getDescrizioneEnte() {
        return descrizioneEnte;
    }

    /**
     * Sets the value of the descrizioneEnte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setDescrizioneEnte(String value) {
        this.descrizioneEnte = value;
    }

    /**
     * Gets the value of the indirizzoEnte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String getIndirizzoEnte() {
        return indirizzoEnte;
    }

    /**
     * Sets the value of the indirizzoEnte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setIndirizzoEnte(String value) {
        this.indirizzoEnte = value;
    }

}