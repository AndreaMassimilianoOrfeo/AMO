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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RiepilogoRetribuzioneChoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RiepilogoRetribuzioneChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="competenzeFisse" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}CompetenzeFisse"/>
 *           &lt;element name="ritenute" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}Ritenute"/>
 *           &lt;element name="riemissionePerStorno" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}RiemissionePerStorno"/>
 *           &lt;element name="competenzeAccessorieConguagli" type="{http://postemissione.noipa.mef.gov.it/parser/autogenerated/cedolino/depcon}CompetenzeAccessorieConguagli"/>
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
@XmlType(name = "RiepilogoRetribuzioneChoice", propOrder = {
    "competenzeFisse",
    "ritenute",
    "riemissionePerStorno",
    "competenzeAccessorieConguagli"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class RiepilogoRetribuzioneChoice {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected CompetenzeFisse competenzeFisse;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected Ritenute ritenute;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected RiemissionePerStorno riemissionePerStorno;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected CompetenzeAccessorieConguagli competenzeAccessorieConguagli;

    /**
     * Gets the value of the competenzeFisse property.
     * 
     * @return
     *     possible object is
     *     {@link CompetenzeFisse }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public CompetenzeFisse getCompetenzeFisse() {
        return competenzeFisse;
    }

    /**
     * Sets the value of the competenzeFisse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetenzeFisse }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCompetenzeFisse(CompetenzeFisse value) {
        this.competenzeFisse = value;
    }

    /**
     * Gets the value of the ritenute property.
     * 
     * @return
     *     possible object is
     *     {@link Ritenute }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public Ritenute getRitenute() {
        return ritenute;
    }

    /**
     * Sets the value of the ritenute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ritenute }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRitenute(Ritenute value) {
        this.ritenute = value;
    }

    /**
     * Gets the value of the riemissionePerStorno property.
     * 
     * @return
     *     possible object is
     *     {@link RiemissionePerStorno }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public RiemissionePerStorno getRiemissionePerStorno() {
        return riemissionePerStorno;
    }

    /**
     * Sets the value of the riemissionePerStorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link RiemissionePerStorno }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setRiemissionePerStorno(RiemissionePerStorno value) {
        this.riemissionePerStorno = value;
    }

    /**
     * Gets the value of the competenzeAccessorieConguagli property.
     * 
     * @return
     *     possible object is
     *     {@link CompetenzeAccessorieConguagli }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public CompetenzeAccessorieConguagli getCompetenzeAccessorieConguagli() {
        return competenzeAccessorieConguagli;
    }

    /**
     * Sets the value of the competenzeAccessorieConguagli property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetenzeAccessorieConguagli }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2016-02-05T04:07:17+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setCompetenzeAccessorieConguagli(CompetenzeAccessorieConguagli value) {
        this.competenzeAccessorieConguagli = value;
    }

}
