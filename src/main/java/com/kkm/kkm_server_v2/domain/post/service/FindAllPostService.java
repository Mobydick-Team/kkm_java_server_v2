package com.kkm.kkm_server_v2.domain.post.service;

import com.kkm.kkm_server_v2.domain.post.domain.Post;
import com.kkm.kkm_server_v2.domain.post.domain.repository.PostRepository;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostListResponse;
import com.kkm.kkm_server_v2.domain.post.presentation.dto.response.PostResponse;
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
public class FindAllPostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostListResponse execute(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "modifiedDateTime");
        Page<Post> list = postRepository.findAll(pageable);

        return PostListResponse.builder()
                .currentPage(list.getNumber() + 1)
                .hasMorePage(list.getTotalPages() > list.getNumber() + 1)
                .list(list.map(PostResponse::of).stream()
                        .collect(Collectors.toList()))
                .build();
    }

}