//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2015.12.15 at 06:18:33 PM CET
//
package it.gov.mef.noipa.postemissione.parser.autogenerated.cedolino;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for INSERT_DELETE_TYPE.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="INSERT_DELETE_TYPE"> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}string"> &lt;length value="1"/>
 * &lt;enumeration value="I"/> &lt;enumeration value="C"/> &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "INSERT_DELETE_TYPE")
@XmlEnum
public enum INSERTDELETETYPE {

	I,
	C;

	public String value() {
		return name();
	}

	public static INSERTDELETETYPE fromValue(String v) {
		return valueOf(v);
	}

}
