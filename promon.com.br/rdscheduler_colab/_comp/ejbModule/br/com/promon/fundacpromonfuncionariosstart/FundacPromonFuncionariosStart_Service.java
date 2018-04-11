package br.com.promon.fundacpromonfuncionariosstart;

/**
 * Service implementation of {FundacPromonFuncionariosStart} (generated by SAP WSDL to Java generator).
 */
@javax.xml.ws.WebServiceClient(name = "FundacPromonFuncionariosStart", targetNamespace = "http://promon.com.br/FundacPromonFuncionariosStart/", wsdlLocation = "META-INF/wsdl/br/com/promon/fundacpromonfuncionariosstart/FundacPromonFuncionariosStarter/FundacPromonFuncionariosStarter.wsdl")
public class FundacPromonFuncionariosStart_Service extends javax.xml.ws.Service {

  private final static java.net.URL FUNDACPROMONFUNCIONARIOSSTART_SERVICE_WSDL_LOCATION = null;
  /**
   * Default service constructor.
   */
  public FundacPromonFuncionariosStart_Service() throws java.net.MalformedURLException {
    super(FUNDACPROMONFUNCIONARIOSSTART_SERVICE_WSDL_LOCATION, new javax.xml.namespace.QName("http://promon.com.br/FundacPromonFuncionariosStart/", "FundacPromonFuncionariosStart"));
  }
  public FundacPromonFuncionariosStart_Service(java.net.URL wsdlLocation, javax.xml.namespace.QName serviceName) {
    super(wsdlLocation, serviceName);
  }
  /**
   * Get method for webservice port [FundacPromonFuncionariosStartSOAP].
   */
  @javax.xml.ws.WebEndpoint(name = "FundacPromonFuncionariosStartSOAP")
  public br.com.promon.fundacpromonfuncionariosstart.FundacPromonFuncionariosStart getFundacPromonFuncionariosStartSOAP() {
    javax.xml.namespace.QName portName = new javax.xml.namespace.QName("http://promon.com.br/FundacPromonFuncionariosStart/","FundacPromonFuncionariosStartSOAP");
    return (br.com.promon.fundacpromonfuncionariosstart.FundacPromonFuncionariosStart) super.getPort(portName,br.com.promon.fundacpromonfuncionariosstart.FundacPromonFuncionariosStart.class);
  }
}
