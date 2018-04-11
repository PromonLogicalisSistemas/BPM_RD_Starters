
package br.com.promon.escalasstart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="mes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ano" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "mes",
    "ano"
})
@XmlRootElement(name = "StartEscalas")
public class StartEscalas {

    protected int mes;
    protected int ano;

    /**
     * Obtem o valor da propriedade mes.
     * 
     */
    public int getMes() {
        return mes;
    }

    /**
     * Define o valor da propriedade mes.
     * 
     */
    public void setMes(int value) {
        this.mes = value;
    }

    /**
     * Obtem o valor da propriedade ano.
     * 
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o valor da propriedade ano.
     * 
     */
    public void setAno(int value) {
        this.ano = value;
    }

}
