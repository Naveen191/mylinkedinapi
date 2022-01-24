package com.naveen.myapp.signup;

import com.naveen.myapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private ISignupService signupService;

    @PostMapping("/myapp/signup")
    public ResponseEntity<User> signupUser(@RequestBody User user) throws Exception {

        try {
            signupService.registerUser(user);
            return new ResponseEntity<User>(HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }

    }
}
