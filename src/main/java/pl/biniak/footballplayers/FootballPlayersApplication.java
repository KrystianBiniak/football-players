package pl.biniak.footballplayers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class    FootballPlayersApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(FootballPlayersApplication.class, args);
		}
		catch (Throwable exception) {
			exception.printStackTrace();
		}
	}

}
