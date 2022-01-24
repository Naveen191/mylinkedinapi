package com.naveen.myapp.signup;

import com.naveen.myapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SignupRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);
    User findUserByEmail(String email);
    List<User> findAllByFirstName(String firstName);
    boolean existsUserByUserName(String userName);
}
