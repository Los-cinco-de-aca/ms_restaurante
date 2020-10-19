package co.edu.uniajc.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class MsRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRestauranteApplication.class, args);
	}

}
