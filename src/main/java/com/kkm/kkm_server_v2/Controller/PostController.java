package com.kkm.kkm_server_v2.Controller;

import com.kkm.kkm_server_v2.Domain.Post;
import com.kkm.kkm_server_v2.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;




    @RequestMapping(value = "/posts", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Post Posts(Post post)throws Exception{
        Post newPost = postRepository.save(post);
        return newPost;

    }

}
