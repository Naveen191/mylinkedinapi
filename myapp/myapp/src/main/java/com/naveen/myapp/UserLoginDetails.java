package com.naveen.myapp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@RequiredArgsConstructor
public class UserLoginDetails {
    String userName;
    String password;
}
