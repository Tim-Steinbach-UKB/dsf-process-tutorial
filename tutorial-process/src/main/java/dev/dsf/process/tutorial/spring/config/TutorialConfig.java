package dev.dsf.process.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.documentation.ProcessDocumentation;
import dev.dsf.process.tutorial.ConstantsTutorial;
import dev.dsf.process.tutorial.service.DicTask;

@Configuration
public class TutorialConfig {
	@Autowired
	private ProcessPluginApi api;

	@Value("${dev.dsf.process.tutorial.service.loggingEnabled:false}")
	@ProcessDocumentation(description = "Set to true to enable logging", required = false, processNames = ConstantsTutorial.PROCESS_NAME_FULL_DIC)
	private boolean loggingEnabled;

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DicTask dicTask() {
		return new DicTask(api, loggingEnabled);
	}

}