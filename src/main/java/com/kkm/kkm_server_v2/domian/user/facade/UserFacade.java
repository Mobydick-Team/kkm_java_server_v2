package com.kkm.kkm_server_v2.domian.user.facade;

import com.kkm.kkm_server_v2.domian.user.domain.User;
import com.kkm.kkm_server_v2.domian.user.domain.repository.UserRepository;
import com.kkm.kkm_server_v2.domian.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser(long id)throws Exception{
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
    public User findUserByUserId(String userId){
        return userRepository.findByUserId(userId)
                .orElseThrow( ()-> UserNotFoundException.EXCEPTION);
    }
    public Optional<User> isUserExist(String userId){
        return userRepository.findByUserId(userId);
    }
}
