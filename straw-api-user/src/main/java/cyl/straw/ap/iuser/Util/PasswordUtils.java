package cyl.straw.ap.iuser.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 处理密码加密相关任务的工具类
 */
public class PasswordUtils {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(String rawPassword){
        String encodePassword = passwordEncoder.encode(rawPassword);
        return encodePassword;
    }
}
