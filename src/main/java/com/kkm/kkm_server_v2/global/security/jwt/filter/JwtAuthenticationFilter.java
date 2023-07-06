package com.kkm.kkm_server_v2.global.security.jwt.filter;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.enums.UserStatus;
import com.kkm.kkm_server_v2.domain.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.global.security.auth.AuthDetailsService;
import com.kkm.kkm_server_v2.global.security.jwt.JwtTokenProvider;
import com.kkm.kkm_server_v2.global.security.jwt.JwtValidateService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthDetailsService authDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtValidateService jwtValidateService;
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = jwtTokenProvider.resolveToken(request);
        if (accessToken != null) {
            String userId = jwtValidateService.getUserId(accessToken);
            setAuthentication(userId, request);
            validateUserStatus(userId);
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String userId, HttpServletRequest request) throws ExpiredJwtException {
        UserDetails userDetails = authDetailsService.loadUserByUsername(userId);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private void validateUserStatus(String userId) {
        User user = userFacade.findUserByUserId(userId);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastActivity = user.getModifiedDateTime();
        System.out.println("lastActivity = " + lastActivity);
        if (user.getStatus() == UserStatus.DEACTIVATED) {
            if (lastActivity != null && ChronoUnit.DAYS.between(lastActivity, now) >= 30) {
                user.updateStatus(UserStatus.DELETED);
                userRepository.save(user);
                throw UserNotFoundException.EXCEPTION;
            }
        } else if (user.getStatus() == UserStatus.DELETED) {
            throw UserNotFoundException.EXCEPTION;
        }
    }
}
