package cyl.straw.ap.iuser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@Deprecated
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //如果密码没加前缀"{bcrypt}"，则需要注入加密方法
//@Bean
//public PasswordEncoder passwordEncoder(){
//    return new BCryptPasswordEncoder();
//}
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{bcrypt}$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y")
//                .authorities("a_delete","a_update","u_list","u_info")
//                .and()
//                .withUser("mook")
//                .password("{bcrypt}$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y")
//                .authorities("u_list","u_info");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置验证授权
        http.authorizeRequests()
                .antMatchers("/test/admin/delete").hasAuthority("a_delete")
                .antMatchers("/test/admin/update").hasAuthority("a_update")
                .antMatchers("/test/user/list").hasAuthority("u_list")
                .antMatchers("/test/user/info").hasAuthority("u_info")
                .anyRequest().authenticated();
        //启用登录表单
        http.formLogin();
        //关闭跨域攻击
        http.csrf().disable();
    }
}
