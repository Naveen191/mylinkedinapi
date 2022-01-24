package com.naveen.myapp.posts;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Post;
import com.naveen.myapp.validators.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    UserLoginValidator userLoginValidator;
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPostsByUser(UserLoginDetails userLoginDetails) throws Exception {

        if(userLoginValidator.isValidLogin(userLoginDetails)) {
            return postRepository.findAllPostsByUserName(userLoginDetails.getUserName());
        }
        else throw new Exception("invalidLoginDetails");
    }

    public Post addPostByUser(UserLoginDetails userLoginDetails,Post post) throws Exception {
        if(userLoginValidator.isValidLogin(userLoginDetails)) {
            return postRepository.save(post);
        }
        else  throw new Exception("invalid LoginDetails");
    }
}

