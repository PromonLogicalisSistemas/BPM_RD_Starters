package br.com.promon.rd.schedulers;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.horasdiferenciadasstart.HorasDiferenciadasStart;
import br.com.promon.horasdiferenciadasstart.HorasDiferenciadasStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_HorasDiferenciadas_Starter'") }, mappedName = "JobQueue")

public class RdHorasDiferenciadasStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 594073191820560068L;

	@WebServiceRef(name = "HorasDiferenciadasStart")
	HorasDiferenciadasStart_Service HorasDiferenciadasLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Horas Diferenciadas...");

		try {
			HorasDiferenciadasStart HorasDiferenciadasLookupServiceReq = HorasDiferenciadasLookupService
					.getPort(HorasDiferenciadasStart.class);

			Date data = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);

			if (month == 0) {
				month = 11;
				year--;
			} else {
				month = month - 1;
			}

			cal.set(year, month, 1);

			logger.info("Data referencia utilizada: " + cal.getTime().toString());

			HorasDiferenciadasLookupServiceReq.startHorasDiferenciadas(BigInteger.valueOf(month + 1), BigInteger.valueOf(year));

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
