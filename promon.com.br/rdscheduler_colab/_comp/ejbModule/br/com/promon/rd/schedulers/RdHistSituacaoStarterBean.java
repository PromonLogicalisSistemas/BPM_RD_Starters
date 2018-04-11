package br.com.promon.rd.schedulers;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.histsituacaostart.HistSituacaoStart;
import br.com.promon.histsituacaostart.HistSituacaoStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_HistSituacao_Starter'") }, mappedName = "JobQueue")

public class RdHistSituacaoStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "HistSituacaoStart")
	HistSituacaoStart_Service HistSituacaoLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM HistSituacao...");

		try {
			HistSituacaoStart HistSituacaoLookupServiceReq = HistSituacaoLookupService
					.getPort(HistSituacaoStart.class);

			HistSituacaoLookupServiceReq.startHistSituacao("");

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
