package co.edu.uniajc.restaurante;

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import co.edu.uniajc.restaurante.dto.LoginDTO;
import co.edu.uniajc.restaurante.service.AuthService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

	@LocalServerPort
	int randomServerPort;

	@Autowired
	AuthService authServ;

	@Test
	void testPostLogin() throws URISyntaxException {

		LoginDTO login = new LoginDTO();
		login.setCorreo("linda@gmail.com");
		login.setPassword("987");
		String token = authServ.login(login.getCorreo(), login.getPassword());
		assertNotNull(token);

	}

}
