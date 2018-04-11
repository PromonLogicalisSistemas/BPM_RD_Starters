
package br.com.promon.horasxcoletoresstart;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.promon.horasxcoletoresstart package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.promon.horasxcoletoresstart
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StartHorasXColetores }
     * 
     */
    public StartHorasXColetores createStartHorasXColetores() {
        return new StartHorasXColetores();
    }

    /**
     * Create an instance of {@link StartHorasXColetoresResponse }
     * 
     */
    public StartHorasXColetoresResponse createStartHorasXColetoresResponse() {
        return new StartHorasXColetoresResponse();
    }

}
