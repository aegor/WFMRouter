package ru.beeper.wfm.router;

// import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableAdminServer
@ConfigurationPropertiesScan("ru.beeper.wfm.router.configuration")
public class WFMRouter {

	private static final Logger log = LoggerFactory.getLogger(WFMRouter.class);

	public static void main(String[] args) {
		SpringApplication.run(WFMRouter.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		// Egor Simple stub to run commands after context initialization, but before starting servlet container
		// I likes that
		return args -> {

		};
	}
}
