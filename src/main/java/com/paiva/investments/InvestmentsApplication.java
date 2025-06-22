package com.paiva.investments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for running the Investments API application.
 * 
 * <p>
 * This class uses the default constructor without additional comments.
 * The main method starts the Spring Boot application.
 * </p>
 */
@SpringBootApplication
public class InvestmentsApplication {

	 /**
     * Main entry point of the application.
     *
     * @param args the command-line arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(InvestmentsApplication.class, args);
	}

}
