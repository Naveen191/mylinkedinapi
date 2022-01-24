package com.naveen.myapp.feed;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class FeedController {

    @Autowired
    IFeedService feedService;

    @PostMapping("/myapp/feed")
    public ResponseEntity<List<Post>> getFeedbyUser(@RequestBody UserLoginDetails userLoginDetails) throws Exception {
        try{
    return  new ResponseEntity<List<Post>>(feedService.getFeedByUser(userLoginDetails
    ), HttpStatus.OK)   ;}
        catch (Exception e){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


}
