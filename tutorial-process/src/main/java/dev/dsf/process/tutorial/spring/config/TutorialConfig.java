package dev.dsf.process.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.documentation.ProcessDocumentation;
import dev.dsf.process.tutorial.service.DicTask;

@Configurable
public class TutorialConfig {
	@Autowired
	private ProcessPluginApi api;

	@Bean
	@Scope("prototype")
	// @ProcessDocumentation(description = "DIC Example Task")
	public DicTask dicTask() {
		return new DicTask(api);

	}
}
