package com.naveen.myapp.feed;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.connections.ConnectionRepository;
import com.naveen.myapp.models.Post;
import com.naveen.myapp.models.User;
import com.naveen.myapp.posts.PostRepository;
import com.naveen.myapp.validators.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FeedServiceImpl implements IFeedService{

    @Autowired
    UserLoginValidator userLoginValidator;

    @Autowired
    ConnectionRepository connectionRepository;
    @Autowired
    PostRepository postRepository;


    public List<Post> getFeedByUser(UserLoginDetails userLoginDetails) throws Exception {


    List<Post> feedList = new ArrayList<>();


        if(userLoginValidator.isValidLogin(userLoginDetails)) {

            List<User> connectionList = connectionRepository.findAllConnectsByUserId(userLoginDetails.getUserName());
            connectionList.forEach(connection->{
                feedList.addAll(postRepository.findAllPostsByUserName(connection.getUserName()));
            });

              return feedList;

        }
        else throw new Exception("invalidLoginDetails");
    }
}


