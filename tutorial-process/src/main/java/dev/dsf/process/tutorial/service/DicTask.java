package dev.dsf.process.tutorial.service;

import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.documentation.ProcessDocumentation;
import dev.dsf.bpe.v1.variables.Variables;
import dev.dsf.process.tutorial.ConstantsTutorial;

public class DicTask extends AbstractServiceDelegate {
	private static Logger LOGGER = LoggerFactory.getLogger(DicTask.class);

	@Value("${dev.dsf.process.tutorial.service.loggingEnabled:false}")
	@ProcessDocumentation(description = "Set to true to enable logging", required = false, processNames = ConstantsTutorial.PROCESS_NAME_FULL_DIC)
	private boolean loggingEnabled;

	public DicTask(ProcessPluginApi api, boolean loggingEnabled) {
		super(api);
		this.loggingEnabled = loggingEnabled;
	}

	@Override
	protected void doExecute(DelegateExecution execution, Variables variables) {
		if (loggingEnabled) {
			LOGGER.info("Hello DIC from organization '{}'",
					variables.getStartTask().getRestriction().getRecipientFirstRep().getIdentifier().getValue());

			Optional<String> tutorialInputParameter = api.getTaskHelper().getFirstInputParameterStringValue(
					variables.getStartTask(), "http://dsf.dev/fhir/CodeSystem/tutorial", "Test");

			LOGGER.info("Input: '{}'", tutorialInputParameter.get());
		}
	}
}
