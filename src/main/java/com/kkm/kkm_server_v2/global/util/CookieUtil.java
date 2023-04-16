package com.kkm.kkm_server_v2.global.util;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookieUtil {
    public ResponseCookie createCookie(String name, String token, Long time) {
        return ResponseCookie.from(name, token)
                .httpOnly(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(time)
                .build();
    }

    public Cookie getCookie(HttpServletRequest req, String name) {
        final Cookie[] cookies = req.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
}
