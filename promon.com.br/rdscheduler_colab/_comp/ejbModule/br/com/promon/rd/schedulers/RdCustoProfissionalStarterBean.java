package br.com.promon.rd.schedulers;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.custoprofissionalstart.CustoProfissionalStart;
import br.com.promon.custoprofissionalstart.CustoProfissionalStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_CustoProfissional_Starter'") }, mappedName = "JobQueue")

public class RdCustoProfissionalStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "CustoProfissionalStart")
	CustoProfissionalStart_Service CustoProfissionalLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Custo Profissional...");

		try {
			CustoProfissionalStart CustoProfissionalLookupServiceReq = CustoProfissionalLookupService
					.getPort(CustoProfissionalStart.class);

			logger.info("Data referencia utilizada: " + new Date().toString());

			CustoProfissionalLookupServiceReq.startCustoProfissional(new Date());

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
