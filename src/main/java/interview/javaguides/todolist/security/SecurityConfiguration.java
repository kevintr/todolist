package interview.javaguides.todolist.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration
  extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	

	@Autowired
	private UserDetailsService userService;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(bCryptPasswordEncoder);
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)
      throws Exception {
        httpSecurity.authorizeRequests()
          .antMatchers("/h2-console/**")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
  		  .and();
        
        httpSecurity.csrf()
          .ignoringAntMatchers("/h2-console/**");
        httpSecurity.headers()
          .frameOptions()
          .sameOrigin();
    }
}