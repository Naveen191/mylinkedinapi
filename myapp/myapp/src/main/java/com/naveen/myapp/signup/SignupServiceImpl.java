package com.naveen.myapp.signup;

import com.naveen.myapp.exceptions.UserAlreadyExistsException;
import com.naveen.myapp.validators.IEncrypter;
import com.naveen.myapp.models.User;
import com.naveen.myapp.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SignupServiceImpl implements ISignupService{



    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    IEncrypter encrypter;





    @Override
    public void registerUser(User user) throws Exception{

        user.setPassword(encrypter.encrypt(user.getPassword()));
       if (!signupRepository.existsUserByUserName(user.getUserName())) {
           signupRepository.save(user);
       }
       else throw new UserAlreadyExistsException("User Already Exists");


    }

}
