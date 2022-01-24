package com.naveen.myapp.posts;

import com.naveen.myapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value = "select p from post p where user.userName = :userName",nativeQuery = true)
    List<Post> findAllPostsByUserName(@Param("userName") String userName);


}
