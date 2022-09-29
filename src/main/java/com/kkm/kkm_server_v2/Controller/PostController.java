package com.kkm.kkm_server_v2.Controller;

import com.kkm.kkm_server_v2.Domain.PostTbl;
import com.kkm.kkm_server_v2.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;




    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long Post(PostTbl post) throws Exception {
        PostTbl newPost = postRepository.save(post);
        return newPost.getPost_id();

    }
    @RequestMapping(value = "/post1", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public PostTbl getPost(@RequestBody PostTbl post) throws Exception{
        return postRepository.save(post);
    }
}
