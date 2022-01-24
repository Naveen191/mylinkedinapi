/*package com.naveen.myapp.signup;

import com.naveen.myapp.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SignupDaoImpl implements ISignupDao{
    @PersistenceContext
    EntityManager entityManager;
/*
    @Query(value = "SELECT * FROM User a WHERE a.userName= "+user.g,
            nativeQuery=true)
    public boolean ifUserExists(User user){

    }

    public User returnIfUserExists(String userName) {
        User userCreated = null;
        try {
            userCreated = (User) entityManager.createQuery("Select a from User a where a.userName=:userName")
                    .setParameter("userName", userName).getSingleResult();
            return userCreated;
        } catch (NoResultException e) {
            return userCreated;
        }
    }

  //  @Override
    public User registerUser(User user) {
    }}
        */
