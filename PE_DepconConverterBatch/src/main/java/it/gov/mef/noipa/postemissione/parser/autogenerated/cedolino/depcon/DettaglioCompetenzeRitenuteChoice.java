//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.05 at 04:07:18 PM CET 
//


package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino.depcon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DettaglioCompetenzeRitenuteChoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DettaglioCompetenzeRitenuteChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="dettaglioCompetenzaRitenuta" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}DettaglioCompetenzaRitenuta" maxOccurs="unbounded"/>
 *           &lt;element name="dettaglioAliquota" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}DettaglioAliquota" maxOccurs="unbounded"/>
 *           &lt;element name="dettaglioAliquotaRitenuta" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}DettaglioAliquotaRitenuta" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioCompetenzeRitenuteChoice", propOrder = {
    "dettaglioCompetenzaRitenuta",
    "dettaglioAliquota",
    "dettaglioAliquotaRitenuta"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class DettaglioCompetenzeRitenuteChoice {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected List<DettaglioCompetenzaRitenuta> dettaglioCompetenzaRitenuta;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected List<DettaglioAliquota> dettaglioAliquota;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected List<DettaglioAliquotaRitenuta> dettaglioAliquotaRitenuta;

    /**
     * Gets the value of the dettaglioCompetenzaRitenuta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioCompetenzaRitenuta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioCompetenzaRitenuta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioCompetenzaRitenuta }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public List<DettaglioCompetenzaRitenuta> getDettaglioCompetenzaRitenuta() {
        if (dettaglioCompetenzaRitenuta == null) {
            dettaglioCompetenzaRitenuta = new ArrayList<DettaglioCompetenzaRitenuta>();
        }
        return this.dettaglioCompetenzaRitenuta;
    }

    /**
     * Gets the value of the dettaglioAliquota property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioAliquota property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioAliquota().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioAliquota }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public List<DettaglioAliquota> getDettaglioAliquota() {
        if (dettaglioAliquota == null) {
            dettaglioAliquota = new ArrayList<DettaglioAliquota>();
        }
        return this.dettaglioAliquota;
    }

    /**
     * Gets the value of the dettaglioAliquotaRitenuta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioAliquotaRitenuta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioAliquotaRitenuta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioAliquotaRitenuta }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public List<DettaglioAliquotaRitenuta> getDettaglioAliquotaRitenuta() {
        if (dettaglioAliquotaRitenuta == null) {
            dettaglioAliquotaRitenuta = new ArrayList<DettaglioAliquotaRitenuta>();
        }
        return this.dettaglioAliquotaRitenuta;
    }

}
