package spring_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http
//		.authorizeHttpRequests()
//		.requestMatchers("/v1/api/homeTest")
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin();
//		return httpSecurity.build();

		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers("/v1/testt")
				.hasRole("NORMAL")
//				.permitAll()
				.requestMatchers("/v1/crss")
				.hasRole("ADMIN")
//				.authenticated()
				)
		        .formLogin(withDefaults());
		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUser = User
				.withUsername("ze1")
				.password(passwordEncoder().encode("pas"))
				.roles("NORMAL")
				.build();

		UserDetails adminUser = User
				.withUsername("ad1")
				.password(passwordEncoder().encode("pas"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(normalUser,adminUser);
	}

}
