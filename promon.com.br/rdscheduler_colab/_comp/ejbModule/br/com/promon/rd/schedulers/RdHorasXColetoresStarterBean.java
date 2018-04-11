package br.com.promon.rd.schedulers;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.horasxcoletoresstart.HorasXColetoresStart;
import br.com.promon.horasxcoletoresstart.HorasXColetoresStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_HorasXColetores_Starter'") }, mappedName = "JobQueue")

public class RdHorasXColetoresStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "HorasXColetoresStart")
	HorasXColetoresStart_Service HorasXColetoresLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM HorasXColetores...");

		try {
			HorasXColetoresStart HorasXColetoresLookupServiceReq = HorasXColetoresLookupService
					.getPort(HorasXColetoresStart.class);

			// Calendar cal = Calendar.getInstance();
			// cal.setTime(new Date());
			// int month = cal.get(Calendar.MONTH) + 1;
			// int year = cal.get(Calendar.YEAR);

			HorasXColetoresLookupServiceReq.startHorasXColetores("data_inicio", "data_fim");

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
