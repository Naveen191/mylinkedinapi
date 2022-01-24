package com.naveen.myapp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.*;


@Getter
@Setter

@RequiredArgsConstructor
@Component
public class Feed {

    private String userName;

    List<Post> feedList;

}
