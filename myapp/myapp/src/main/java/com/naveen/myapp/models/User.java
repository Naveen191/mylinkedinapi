package com.naveen.myapp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
    @Setter
    @RequiredArgsConstructor
    @Table
    @Entity(name = "user")
    public class User {
        @Id
        @GeneratedValue
        @Column(name = "id")
        private int id;

        @Column(name = "userName")
        private String userName;
        @Column(name = "firstName")
        private String firstName;
        @Column(name = "lastName")
        private String lastName;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;

    }


