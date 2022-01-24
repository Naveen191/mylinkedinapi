package com.naveen.myapp.posts;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;
public interface IPostService {
    List<Post> getAllPostsByUser(UserLoginDetails userLoginDetails) throws Exception;
    Post addPostByUser(UserLoginDetails userLoginDetails,Post post) throws Exception;
}
