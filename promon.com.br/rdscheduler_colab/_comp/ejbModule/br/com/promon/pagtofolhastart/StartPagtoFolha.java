
package br.com.promon.pagtofolhastart;

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
 *         &lt;element name="num_mes_ref" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="num_ano_ref" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlRootElement(name = "StartPagtoFolha")
public class StartPagtoFolha {

    @XmlElement(name = "num_mes_ref")
    protected int numMesRef;
    @XmlElement(name = "num_ano_ref")
    protected int numAnoRef;

    /**
     * Obtem o valor da propriedade numMesRef.
     * 
     */
    public int getNumMesRef() {
        return numMesRef;
    }

    /**
     * Define o valor da propriedade numMesRef.
     * 
     */
    public void setNumMesRef(int value) {
        this.numMesRef = value;
    }

    /**
     * Obtem o valor da propriedade numAnoRef.
     * 
     */
    public int getNumAnoRef() {
        return numAnoRef;
    }

    /**
     * Define o valor da propriedade numAnoRef.
     * 
     */
    public void setNumAnoRef(int value) {
        this.numAnoRef = value;
    }

}
