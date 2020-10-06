package cyl.straw.ap.iuser.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //许可所有请求
        http.authorizeRequests().anyRequest().permitAll();
        //关闭跨域攻击
        http.csrf().disable();
    }
}
