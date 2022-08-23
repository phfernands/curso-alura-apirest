package br.com.alura.forum.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
	    	.authorizeRequests()
	        .antMatchers(HttpMethod.GET, "/topicos").permitAll()
	        .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
	        .antMatchers(HttpMethod.POST, "/auth").permitAll()
	        .anyRequest().authenticated()
	        .and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	
        return http.build();
    }
    
    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    protected PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
