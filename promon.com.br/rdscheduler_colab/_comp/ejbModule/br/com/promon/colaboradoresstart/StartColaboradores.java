
package br.com.promon.colaboradoresstart;

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
 *         &lt;element name="dat_refer" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="log_ativos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "datRefer", "logAtivos" })
@XmlRootElement(name = "StartColaboradores")
public class StartColaboradores {

	@XmlElement(name = "dat_refer")
	@XmlSchemaType(name = "date")
	protected Date datRefer;
	@XmlElement(name = "log_ativos", defaultValue = "true")
	protected Boolean logAtivos;

	/**
	 * Obtem o valor da propriedade datRefer.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
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

	/**
	 * Obtem o valor da propriedade logAtivos.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isLogAtivos() {
		return logAtivos;
	}

	/**
	 * Define o valor da propriedade logAtivos.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setLogAtivos(Boolean value) {
		this.logAtivos = value;
	}

}
