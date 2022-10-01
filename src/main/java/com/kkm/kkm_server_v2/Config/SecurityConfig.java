//package com.kkm.kkm_server_v2.Config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity // 기본적인 Web 보안 활성화
//public class SecurityConfig extends WebSecurityConfigurerAdapter { // 추가 설정
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http
//                .authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정
//                .antMatchers("/user/**").permitAll(); // /api/hello에 대한 요청은 인증없이 접근을 허용
//    }
//}