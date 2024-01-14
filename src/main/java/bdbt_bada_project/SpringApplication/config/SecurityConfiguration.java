package bdbt_bada_project.SpringApplication.config;//package bdbt_bada_project.SpringApplication.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("administrator")
                .password("administrator")
                .roles("ADMINISTRATOR")
                .and()
                .withUser("trener")
                .password("trener")
                .roles("TRENER")
                .and()
                .withUser("zawodnik")
                .password("zawodnik")
                .roles("ZAWODNIK");


    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/mainAdmin").access("hasRole('ADMINISTRATOR')")
                .antMatchers("/mainTrainer").access("hasRole('TRENER')")
                .antMatchers("/mainPlayer").access("hasRole('ZAWODNIK')")



                .antMatchers("/disciplines").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK' )")
                .antMatchers("/disciplines/edit/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")
                .antMatchers("/disciplines/delete/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")
                .antMatchers("/disciplines/add").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")

                .antMatchers("/addresses").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/addresses/edit/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/addresses/delete/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/addresses/add").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")


                .antMatchers("/places").access("hasAnyRole('ADMINISTRATOR')")
                .antMatchers("/places/edit/*").access("hasAnyRole('ADMINISTRATOR')")
                .antMatchers("/places/delete/*").access("hasAnyRole('ADMINISTRATOR')")
                .antMatchers("/places/add").access("hasAnyRole('ADMINISTRATOR')")

                .antMatchers("/trainers").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")
                .antMatchers("/trainers/edit/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")
                .antMatchers("/trainers/delete/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")
                .antMatchers("/trainers/add").access("hasAnyRole('ADMINISTRATOR', 'TRENER')")

                .antMatchers("/players").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/players/edit/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/players/delete/*").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")
                .antMatchers("/players/add").access("hasAnyRole('ADMINISTRATOR', 'TRENER', 'ZAWODNIK')")


                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}


