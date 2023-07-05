package com.kkm.kkm_server_v2.global.security.access;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.enums.UserStatus;
import com.kkm.kkm_server_v2.domain.user.exception.UserNotFoundException;
import com.kkm.kkm_server_v2.domain.user.exception.error.UserIsDeactivateException;
import com.kkm.kkm_server_v2.global.security.SecurityConfig;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAccessDecisionManager implements org.springframework.security.access.AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }

        for (ConfigAttribute attribute : configAttributes) {
            if (!supports(attribute)) {
                continue;
            }

            if (authentication == null) {
                throw UserNotFoundException.EXCEPTION;
            }
            UserStatus userStatus = getUserStatus(authentication);
            if (userStatus != UserStatus.ACTIVE) {
                throw UserIsDeactivateException.EXCEPTION;
            }

            return; // 접근 허용
        }

        throw UserNotFoundException.EXCEPTION;// 접근 거부
    }

    private UserStatus getUserStatus(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            User user = (User) principal;
            return user.getStatus();
        }
        throw UserNotFoundException.EXCEPTION;
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute instanceof SecurityConfig;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
