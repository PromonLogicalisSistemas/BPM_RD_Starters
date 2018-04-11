package br.com.promon.rd.schedulers;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.enviaapontamentostart.EnviaApontamentoStart;
import br.com.promon.enviaapontamentostart.EnviaApontamentoStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_EnviaApontamentos_Starter'") }, mappedName = "JobQueue")

public class RdEnviaApontamentosStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = -3239547341736131061L;

	@WebServiceRef(name = "EnviaApontamentStart")
	EnviaApontamentoStart_Service EnviaApontamentoLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Envio Apontamentos...");

		try {
			EnviaApontamentoStart EnviaApontamentoLookupServiceReq = EnviaApontamentoLookupService
					.getPort(EnviaApontamentoStart.class);

			LocalDate hoje = LocalDate.now();
			LocalDate inicio = null;
			LocalDate fim = hoje.minusDays(1);

			if (hoje.getDayOfMonth() == 1) {
				if (hoje.getMonth() == Month.JANUARY) {
					inicio = LocalDate.of(hoje.getYear() - 1, Month.DECEMBER, 1);
				} else {
					inicio = LocalDate.of(hoje.getYear(), hoje.getMonthValue() - 1, 1);
				}
			} else {
				inicio = LocalDate.of(hoje.getYear(), hoje.getMonthValue(), 1);
			}

			logger.info(String.format("Periodo referencia utilizado: de %s a %s", inicio, fim));

			EnviaApontamentoLookupServiceReq.startEnviaApontamento(inicio.toString(), fim.toString());

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
