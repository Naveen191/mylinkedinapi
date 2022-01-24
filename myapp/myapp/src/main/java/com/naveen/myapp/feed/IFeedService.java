package com.naveen.myapp.feed;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IFeedService {

    List<Post> getFeedByUser(UserLoginDetails userLoginDetails) throws Exception;
}
