
package com.training.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personExtra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personExtra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extra1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extra2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personExtra", propOrder = {
    "extra1",
    "extra2"
})
public class PersonExtra {

    protected String extra1;
    protected String extra2;

    /**
     * Gets the value of the extra1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtra1() {
        return extra1;
    }

    /**
     * Sets the value of the extra1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtra1(String value) {
        this.extra1 = value;
    }

    /**
     * Gets the value of the extra2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtra2() {
        return extra2;
    }

    /**
     * Sets the value of the extra2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtra2(String value) {
        this.extra2 = value;
    }

}
