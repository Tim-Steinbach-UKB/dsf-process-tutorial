package dev.dsf.process.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.documentation.ProcessDocumentation;
import dev.dsf.process.tutorial.service.DicTask;

@Configurable
@Scope("prototype")
public class TutorialConfig {
	@SuppressWarnings("unused")
	@Autowired
	private ProcessPluginApi api;

	@ProcessDocumentation(description = "DIC Example Task")
	private DicTask dicTask;
}
