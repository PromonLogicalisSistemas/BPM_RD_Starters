package br.com.promon.rd.schedulers;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.colaboradoresstart.ColaboradoresStart;
import br.com.promon.colaboradoresstart.ColaboradoresStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_Colaboradores_CurrentDate_Starter'") }, mappedName = "JobQueue")

public class RdColaboradoresCurrentDateStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "ColaboradoresStart")
	ColaboradoresStart_Service ColaboradoresLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Colaboradores...");

		try {
			ColaboradoresStart ColaboradoresLookupServiceReq = ColaboradoresLookupService
					.getPort(ColaboradoresStart.class);

			logger.info("Data referencia utilizada: " + new Date().toString());

			ColaboradoresLookupServiceReq.startColaboradores(new Date(), false);

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
