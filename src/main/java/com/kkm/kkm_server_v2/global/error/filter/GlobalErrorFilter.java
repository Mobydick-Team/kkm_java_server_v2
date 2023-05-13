package com.kkm.kkm_server_v2.global.error.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkm.kkm_server_v2.global.error.ErrorResponse;
import com.kkm.kkm_server_v2.global.error.exception.ErrorCode;
import com.kkm.kkm_server_v2.global.error.exception.ErrorProperty;
import com.kkm.kkm_server_v2.global.error.exception.KkmException;
import com.kkm.kkm_server_v2.global.security.jwt.exception.ExpiredTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredTokenException e) {
            setErrorResponse(e.getErrorProperty(), response);
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        } catch (KkmException e) {
            setErrorResponse(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof KkmException) {
                setErrorResponse(((KkmException) e.getCause()).getErrorProperty(), response);
            } else {
                e.printStackTrace();
                setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }
}
