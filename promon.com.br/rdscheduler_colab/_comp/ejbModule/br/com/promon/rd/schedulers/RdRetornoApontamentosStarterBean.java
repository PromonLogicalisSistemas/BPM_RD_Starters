package br.com.promon.rd.schedulers;

import java.time.LocalDate;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.xml.ws.WebServiceRef;

import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;

import br.com.promon.retornoapontamentostart.RetornoApontamentoStart;
import br.com.promon.retornoapontamentostart.RetornoApontamentoStart_Service;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JobQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition='RD_RetornoApontamentos_Starter'") }, mappedName = "JobQueue")

public class RdRetornoApontamentosStarterBean extends MDBJobImplementation {

	private static final long serialVersionUID = 1220039886740526892L;

	@WebServiceRef(name = "RetornoApontamentoStart")
	RetornoApontamentoStart_Service RetornoApontamentoLookupService;

	@Override
	public void onJob(JobContext ctx) throws Exception {
		Logger logger = ctx.getLogger();

		logger.info("Chamando servico de start BPM Retorno Apontamentos...");

		try {
			RetornoApontamentoStart RetornoApontamentoLookupServiceReq = RetornoApontamentoLookupService
					.getPort(RetornoApontamentoStart.class);
			LocalDate hoje = LocalDate.now();
			LocalDate dtRef = LocalDate.of(hoje.getYear(), hoje.getMonthValue(), 1);
			logger.info("Data referencia utilizada: " + dtRef);
			RetornoApontamentoLookupServiceReq.startRetornoApontamento(dtRef.toString());

			logger.info("BPM Iniciado");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
