package com.kkm.kkm_server_v2.global.security.access;

import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.domain.enums.UserStatus;
import com.kkm.kkm_server_v2.global.security.SecurityConfig;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager {

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
                throw new AccessDeniedException("Access is denied");
            }
            UserStatus userStatus = getUserStatus(authentication);
            if (userStatus != UserStatus.ACTIVATE) {
                throw new AccessDeniedException("Access is denied"); // 접근 거부
            }

            return; // 접근 허용
        }

        throw new AccessDeniedException("Access is denied"); // 접근 거부
    }

    private UserStatus getUserStatus(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        User user = (User) principal;
        return user.getStatus();

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
