package com.naveen.myapp.connections;

import com.naveen.myapp.ConnectionRequest;
import com.naveen.myapp.UserLoginDetails;
import com.naveen.myapp.models.Connection;
import com.naveen.myapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnectionController {
    @Autowired
    IConnectionService connectionService;
    @PostMapping("/myapp/connections")
    public ResponseEntity<List<User>> getAllConnectionsByUser(@RequestBody UserLoginDetails userLoginDetails) throws Exception {
        try{
        return new ResponseEntity<List<User>>(connectionService.getAllConnectionsByUser(userLoginDetails), HttpStatus.OK);}
        catch(Exception E){
            return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/myapp/connect")
    public ResponseEntity<Connection> addConnection(@RequestBody String connectionRequest){
        try{
            connectionService.addConnection(connectionRequest);

            return new ResponseEntity<Connection>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
