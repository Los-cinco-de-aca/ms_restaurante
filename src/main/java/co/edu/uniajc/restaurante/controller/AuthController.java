package co.edu.uniajc.restaurante.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.restaurante.dto.LoginDTO;
import co.edu.uniajc.restaurante.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Authentication", tags = "Authentication")
@RestController
//@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	 AuthService authServ;
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PostMapping("/token")
    public String getToken(@RequestBody LoginDTO login){
       String token= authServ.login(login.getCorreo(),login.getPassword());
       if(StringUtils.isEmpty(token)){
           return "no token found!";
       }
       return token;
    }
	


}
