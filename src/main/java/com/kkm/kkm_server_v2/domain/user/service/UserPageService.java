package com.kkm.kkm_server_v2.domain.user.service;

import com.kkm.kkm_server_v2.domain.jjam.service.IsJjammedService;
import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.exception.NotUserPageException;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.user.presentation.dto.response.UserPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserPageService {
    private final UserFacade userFacade;
    private final LocationFacade locationFacade;
    private final IsJjammedService isJjammedService;


    @Transactional
    public UserPageResponse execute(Long id) {
        User me = userFacade.getCurrentUser(false);
        User user = userFacade.findById(id);
        Location location = locationFacade.findBySelectedAndUserLocation(user);
        if (me.getId().equals(user.getId())) {
            throw NotUserPageException.EXCEPTION;
        }
        return UserPageResponse.of(user, new PostListResponse((
                user.getPostList().stream().map(post ->
                        PostResponse.of(post, isJjammedService.execute(me, post))
                ).collect(Collectors.toList())
        )), location.getAddress());
    }
}
