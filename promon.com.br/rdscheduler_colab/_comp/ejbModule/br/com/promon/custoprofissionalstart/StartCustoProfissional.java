
package br.com.promon.custoprofissionalstart;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java de anonymous complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteudo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dat_refer" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "datRefer" })
@XmlRootElement(name = "StartCustoProfissional")
public class StartCustoProfissional {

	@XmlElement(name = "dat_refer", required = true)
	@XmlSchemaType(name = "date")
	protected Date datRefer;

	/**
	 * Obtem o valor da propriedade datRefer.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getDatRefer() {
		return datRefer;
	}

	/**
	 * Define o valor da propriedade datRefer.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDatRefer(Date value) {
		this.datRefer = value;
	}

}
