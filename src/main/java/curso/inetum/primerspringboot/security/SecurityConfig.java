package curso.inetum.primerspringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Configuration
@EnableWebSecurity
@Data
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDeatilSErviceMio userDeail;
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.authorizeRequests().antMatchers("/api").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/api/empleados").access("ROLE_ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().usernameParameter("usuario").passwordParameter("clave");
		http.formLogin().loginPage("/login").loginProcessingUrl("/autenticar").defaultSuccessUrl("/acceso").failureUrl("/login?error=usuario no existe");
		http.logout().logoutSuccessUrl("/login?error=esperamos verte pronto").logoutUrl("/logout");
		http.csrf().disable();
		http.cors();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserDeail()).passwordEncoder(getEncoder());
		
	}
	
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder(4);
	}


}
