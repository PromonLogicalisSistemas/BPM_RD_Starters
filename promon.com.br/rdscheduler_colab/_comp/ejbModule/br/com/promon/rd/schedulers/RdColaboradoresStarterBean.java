package br.com.promon.rd.schedulers;

import java.util.Calendar;
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
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_Colaboradores_Starter'") }, mappedName = "JobQueue")

public class RdColaboradoresStarterBean extends MDBJobImplementation {

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

			Date data = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int month = cal.get(Calendar.MONTH);

			if (month == 0) {
				month = 11;
			} else {
				month = month - 1;
			}

			cal.set(cal.get(Calendar.YEAR), month, 1);

			logger.info("Data referencia utilizada: " + cal.getTime().toString());

			ColaboradoresLookupServiceReq.startColaboradores(cal.getTime(), false);

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
