
package br.com.promon.retornoapontamentostart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datRefer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datRefer"
})
@XmlRootElement(name = "StartRetornoApontamento")
public class StartRetornoApontamento {

    @XmlElement(required = true)
    protected String datRefer;

    /**
     * Obtem o valor da propriedade datRefer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatRefer() {
        return datRefer;
    }

    /**
     * Define o valor da propriedade datRefer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatRefer(String value) {
        this.datRefer = value;
    }

}
