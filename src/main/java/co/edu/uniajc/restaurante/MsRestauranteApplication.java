package co.edu.uniajc.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.edu.uniajc.restaurante.security.JWTAuthorizationFilter;
import co.edu.uniajc.restaurante.security.JwtAuthenticationEntryPoint;

@SpringBootApplication
public class MsRestauranteApplication {
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	public static void main(String[] args) {
		SpringApplication.run(MsRestauranteApplication.class, args);
	}
	
	@EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/token").permitAll()
                             
                .antMatchers(HttpMethod.POST, "/pedidosws/create").permitAll()
                .antMatchers(HttpMethod.GET, "/pedidosws/list").permitAll()
                .antMatchers(HttpMethod.PUT, "/pedidosws/update").permitAll()
                .antMatchers(HttpMethod.DELETE, "/pedidosws/delete").permitAll()
                
                .antMatchers(HttpMethod.POST, "/platosws/create").permitAll()
                .antMatchers(HttpMethod.GET, "/platosws/list").permitAll()
                .antMatchers(HttpMethod.PUT, "/platosws/update").permitAll()
                .antMatchers(HttpMethod.DELETE, "/platosws/delete").permitAll()
                
                .antMatchers(HttpMethod.POST, "/tipousuariows/create").permitAll()
                .antMatchers(HttpMethod.GET, "/tipousuariows/list").permitAll()
                .antMatchers(HttpMethod.PUT, "/tipousuariows/update").permitAll()
                .antMatchers(HttpMethod.DELETE, "/tipousuariows/delete").permitAll()
                
                .antMatchers(HttpMethod.GET, "/usuariows/list").permitAll()
                .antMatchers(HttpMethod.POST, "/usuariows/create").permitAll()
                .antMatchers(HttpMethod.PUT, "/usuariows/update").permitAll()
                .antMatchers(HttpMethod.DELETE, "/usuariows/delete").permitAll()
                               
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            
            http.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
                
        }
        

    }

}
