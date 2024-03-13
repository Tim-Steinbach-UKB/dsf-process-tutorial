package dev.dsf.process.tutorial.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;

public class DicTask extends AbstractServiceDelegate {
	private static Logger LOGGER = LoggerFactory.getLogger(DicTask.class);

	public DicTask(ProcessPluginApi api) {
		super(api);
	}

	@Override
	protected void doExecute(DelegateExecution execution, Variables variables) {
		LOGGER.info("Hello Dic from organization '{}'",variables.getStartTask().getRestriction().getRecipientFirstRep().getIdentifier().getId());
	}
}
