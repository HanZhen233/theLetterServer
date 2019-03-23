package com.hanzhen.theletterserver.configuration;

import com.hanzhen.theletterserver.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean//即返回上边创建的UserService类对象
    UserDetailsService customUserService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return   new MyPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService())//就返回的对象，进行密码验证
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/","/addUser")
                .permitAll()
//                .antMatchers("/manage/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().
                loginProcessingUrl("/login").
                usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/logined")//成功后跳转界面
                .and()
                .logout().logoutUrl("/logout")//登出默认api
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .and()
                .logout().permitAll()
                .and().csrf().disable();
    }
}
