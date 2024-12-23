package tutorial.com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;


@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		Connection connection = null;

		SpringApplication.run(TutorialApplication.class, args);
	}

}
