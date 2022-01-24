package com.naveen.myapp.connections;

import com.naveen.myapp.ConnectionRequest;
import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.User;

import java.util.List;

public interface IConnectionService {

    List<User> getAllConnectionsByUser(UserLoginDetails userLoginDetails) throws Exception;

    void addConnection(String connectionRequest) throws Exception;
}
