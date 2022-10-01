//package com.kkm.kkm_server_v2.Controller;
//
//import com.kkm.kkm_server_v2.Domain.Post;
//import com.kkm.kkm_server_v2.Repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@Controller
//public class PostController {
//@Autowired
//    private final PostRepository postRepository;
//
//
//
//
//    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    public long Post(Post post) throws Exception {
//        Post newPost = postRepository.save(post);
//        return newPost.getPost_id();
//
//    }
//
//}
