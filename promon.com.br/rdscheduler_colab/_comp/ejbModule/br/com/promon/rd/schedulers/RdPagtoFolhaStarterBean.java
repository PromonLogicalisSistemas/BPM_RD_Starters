package br.com.promon.rd.schedulers;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.pagtofolhastart.*;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_PagtoFolha_Starter'") }, mappedName = "JobQueue")

public class RdPagtoFolhaStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "PagtoFolhaStart")
	PagtoFolhaStart_Service PagtoFolhaLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Pagamento Folha com Mes e Ano atuais...");

		try {
			PagtoFolhaStart PagtoFolhaLookupServiceReq = PagtoFolhaLookupService.getPort(PagtoFolhaStart.class);

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);

			PagtoFolhaLookupServiceReq.startPagtoFolha(month, year);

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
