package project.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity
public class WebSecurityConfig
{
@Bean
public SecurityFilterChain configure(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests()
.anyRequest().authenticated()
.and()
.formLogin()
.defaultSuccessUrl("/booklist", true)
.permitAll()
.and()
.httpBasic();
return http.build();
}

@Bean
public UserDetailsService userDetailsService() {
UserDetails user = User.withDefaultPasswordEncoder()
.username("user")
.password("password")
.roles("USER")
.build();
List<UserDetails> users = new ArrayList();
users.add(user);

user = User.withDefaultPasswordEncoder()
.username("admin")
.password("admin")
.roles("USER", "ADMIN")
.build();

users.add(user);
return new InMemoryUserDetailsManager(users);
}

}