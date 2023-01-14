package com.kkm.kkm_server_v2.global.security.service;

import com.kkm.kkm_server_v2.domian.user.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String k_id) throws UsernameNotFoundException{
        return (UserDetails) userRepository.findByKId(k_id)
                .orElseThrow(() ->new UsernameNotFoundException("사용자가 없음"));
    }
}
