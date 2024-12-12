package adamsjac.dev.runners;

import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import adamsjac.dev.runners.run.Location;
import adamsjac.dev.runners.run.Run;

@SpringBootApplication
public class RunnersApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(RunnersApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1, "first run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS),5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}

}
