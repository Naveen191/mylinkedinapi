package com.naveen.myapp.posts;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    IPostService postService;


    @PostMapping("/myapp/posts/list")
    public ResponseEntity<List<Post>> getAllPostsByUser(@RequestBody UserLoginDetails userLoginDetails) {
        try {
            return new ResponseEntity<List<Post>>(postService.getAllPostsByUser(userLoginDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Post>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("myapp/posts/add")

    public ResponseEntity<Post> addPostbyUser(@RequestBody UserLoginDetails userLoginDetails, @RequestBody Post post){
        try{
            return new ResponseEntity<Post>(postService.addPostByUser(userLoginDetails,post),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Post> (HttpStatus.BAD_REQUEST);
        }
    }

}


