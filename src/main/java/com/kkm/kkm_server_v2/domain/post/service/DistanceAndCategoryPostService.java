package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.location.domain.Location;
import com.kkm.kkm_server_v2.domain.location.facade.LocationFacade;
import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.enums.PostCategory;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
import com.kkm.kkm_server_v2.domain.user.domain.User;
import com.kkm.kkm_server_v2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistanceAndCategoryPostService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final LocationFacade locationFacade;

    @Transactional
    public PostListResponse execute(int page, int size, PostCategory category, int distance) {
        User user = userFacade.getCurrentUser(false);
        Location location = locationFacade.findBySelectedAndUserLocation(user);
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "pullDate");
        Page<Post> list = postRepository.findByDistanceAndCategory(location.getLongitude(), location.getLatitude(), distance, category, pageable);

        return PostListResponse.builder()
                .currentPage(list.getNumber() + 1)
                .hasMorePage(list.getTotalPages() > list.getNumber() + 1)
                .list(list.stream().map(PostResponse::of).collect(Collectors.toList()))
                .build();

    }
}
