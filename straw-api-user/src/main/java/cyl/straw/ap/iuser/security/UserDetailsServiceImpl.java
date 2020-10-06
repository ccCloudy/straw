package cyl.straw.ap.iuser.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

//@Component
@Deprecated
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)){
            UserDetails userDetails = User.builder()
                    .username("admin")
                    .password("{bcrypt}$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y")
                    .authorities("a_update","a_delete","u_list","u_info")
                    .build();
            return userDetails;
        }
        if ("user".equals(username)){
            UserDetails userDetails = User.builder()
                    .username("user")
                    .password("{bcrypt}$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y")
                    .authorities("u_list","u_info")
                    .build();
            return userDetails;
        }
        return null;
    }
}
