package com.naveen.myapp.connections;

import com.naveen.myapp.models.Connection;
import com.naveen.myapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConnectionRepository extends JpaRepository<Connection,Integer> {

    @Query(value = "Select p.connect from Connection p where p.user.userName=:userName")
    List<User> findAllConnectsByUserName(@Param("userName") String userName);
    @Query("select p.connect from Connection p where p.user=:user_id")
    List<User> findAllConnectsByUserId(@Param("user_id") String user_id);

}
