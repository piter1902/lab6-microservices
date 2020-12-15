package accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 *
 * @author Paul Chapman
 */
@SpringBootApplication
@EnableEurekaClient
public class AccountsServer {

  /**
   * Run the application using Spring Boot and an embedded servlet engine.
   *
   * @param args Program arguments - ignored.
   */
  public static void main(String[] args) {
    SpringApplication.run(AccountsServer.class, args);
  }


}
