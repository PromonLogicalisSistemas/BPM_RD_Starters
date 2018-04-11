
package br.com.promon.horasdiferenciadasstart;

import java.math.BigInteger;
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
 *         &lt;element name="num_mes_ref" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="num_ano_ref" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
    "numMesRef",
    "numAnoRef"
})
@XmlRootElement(name = "StartHorasDiferenciadas")
public class StartHorasDiferenciadas {

    @XmlElement(name = "num_mes_ref", required = true)
    protected BigInteger numMesRef;
    @XmlElement(name = "num_ano_ref", required = true)
    protected BigInteger numAnoRef;

    /**
     * Obtem o valor da propriedade numMesRef.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumMesRef() {
        return numMesRef;
    }

    /**
     * Define o valor da propriedade numMesRef.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumMesRef(BigInteger value) {
        this.numMesRef = value;
    }

    /**
     * Obtem o valor da propriedade numAnoRef.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumAnoRef() {
        return numAnoRef;
    }

    /**
     * Define o valor da propriedade numAnoRef.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumAnoRef(BigInteger value) {
        this.numAnoRef = value;
    }

}
