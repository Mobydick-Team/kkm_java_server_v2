package global.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Component
public class CookieUtil {
    public Cookie createCookie(String name, String token){
        Cookie cookie = new Cookie(name, token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        return cookie;
    }
}
