package ru.beeper.wfm.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.beeper.wfm.router.configuration.Servers;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.beeper.wfm.router.configuration")
public class WFMRouter {

	private static final Logger log = LoggerFactory.getLogger(WFMRouter.class);

	public static void main(String[] args) {
		SpringApplication.run(WFMRouter.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, Servers props) throws Exception {
		System.out.println("running");
		return args -> {

		};
	}
}
