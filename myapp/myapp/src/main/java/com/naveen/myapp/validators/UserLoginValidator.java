package com.naveen.myapp.validators;

import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.signup.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserLoginValidator {
//    @Autowired
    IEncrypter encrypter;
    @Autowired
    SignupRepository signupRepository;
    public boolean isValidLogin(UserLoginDetails userLoginDetails) throws Exception {
        return (encrypter.decrypt(signupRepository.findUserByUserName(userLoginDetails.getUserName()).getPassword()).equals(userLoginDetails.getPassword()));
    }
}
