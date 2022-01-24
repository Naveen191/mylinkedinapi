package com.naveen.myapp.connections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naveen.myapp.ConnectionRequest;
import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.exceptions.InvalidLoginDetailsException;
import com.naveen.myapp.models.Connection;
import com.naveen.myapp.models.User;
import com.naveen.myapp.signup.SignupRepository;
import com.naveen.myapp.validators.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConnectionServiceImpl implements IConnectionService{
    
    @Autowired
    UserLoginValidator userLoginValidator;
    @Autowired
    ConnectionRepository connectionRepository;

    @Autowired
    SignupRepository signupRepository;
    public List<User> getAllConnectionsByUser(UserLoginDetails userLoginDetails) throws Exception {

        if(userLoginValidator.isValidLogin(userLoginDetails)) {
            return connectionRepository.findAllConnectsByUserId(userLoginDetails.getUserName());
        }
        else throw new InvalidLoginDetailsException("invalidLoginDetails");
        }

        public void addConnection(String connectionRequest) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            ConnectionRequest newconnectionRequest = mapper.readValue(connectionRequest,ConnectionRequest.class);
        if(userLoginValidator.isValidLogin(newconnectionRequest.getUser1LoginDetails()) && userLoginValidator.isValidLogin(newconnectionRequest.getUser2LoginDetails())){
            String userName1 = newconnectionRequest.getUser1LoginDetails().getUserName();
            String userName2 = newconnectionRequest.getUser2LoginDetails().getUserName();
            User user1 = signupRepository.findUserByUserName(userName1);
            User user2 = signupRepository.findUserByUserName(userName2);
            connectionRepository.save(new Connection(user1,user2));
            connectionRepository.save(new Connection(user2,user1));
        }
        else throw new InvalidLoginDetailsException("invalidinput");
        }

    }

