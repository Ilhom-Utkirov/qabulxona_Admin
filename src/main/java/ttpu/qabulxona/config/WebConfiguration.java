package ttpu.qabulxona.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ttpu.qabulxona.constants.UserRoles;
import ttpu.qabulxona.service.CustomSuccessHandler;

import javax.annotation.Resource;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Resource()
    private UserDetailsService userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Autowired
    CustomSuccessHandler customSuccessHandler;

    private static PasswordEncoder encoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .headers()
                .cacheControl();
        http

                .authorizeRequests()
                .antMatchers("/appeals/list").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
                .antMatchers("/appeal/save").permitAll()
                .antMatchers("/appeals/details").permitAll()
                .antMatchers("/error/**").permitAll();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        if (encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }
        return encoder;
    }
}
