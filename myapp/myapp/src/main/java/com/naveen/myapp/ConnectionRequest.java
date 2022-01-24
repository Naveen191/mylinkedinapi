package com.naveen.myapp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ConnectionRequest {
    UserLoginDetails user1LoginDetails;
    UserLoginDetails user2LoginDetails;
}
