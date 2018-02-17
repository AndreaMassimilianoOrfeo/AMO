//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.05 at 04:07:18 PM CET 
//


package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.cedolino;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cedolino" type="{https://noipa.mef.gov.it/schema/Cedolino.xsd}CedolinoType" maxOccurs="10000"/>
 *       &lt;/sequence>
 *       &lt;attribute name="codice_sistema_emittente" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="data_produzione" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cedolino"
})
@XmlRootElement(name = "cedolini", namespace = "https://noipa.mef.gov.it/schema/Cedolino.xsd")
public class Cedolini {

    @XmlElement(required = true)
    protected List<CedolinoType> cedolino;
    @XmlAttribute(name = "codice_sistema_emittente", required = true)
    protected String codiceSistemaEmittente;
    @XmlAttribute(name = "data_produzione", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataProduzione;

    /**
     * Gets the value of the cedolino property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cedolino property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCedolino().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CedolinoType }
     * 
     * 
     */
    public List<CedolinoType> getCedolino() {
        if (cedolino == null) {
            cedolino = new ArrayList<CedolinoType>();
        }
        return this.cedolino;
    }

    /**
     * Gets the value of the codiceSistemaEmittente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSistemaEmittente() {
        return codiceSistemaEmittente;
    }

    /**
     * Sets the value of the codiceSistemaEmittente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSistemaEmittente(String value) {
        this.codiceSistemaEmittente = value;
    }

    /**
     * Gets the value of the dataProduzione property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataProduzione() {
        return dataProduzione;
    }

    /**
     * Sets the value of the dataProduzione property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataProduzione(XMLGregorianCalendar value) {
        this.dataProduzione = value;
    }

}