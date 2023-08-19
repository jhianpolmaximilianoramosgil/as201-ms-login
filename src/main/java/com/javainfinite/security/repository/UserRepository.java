package com.javainfinite.security.repository;

import com.javainfinite.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findBySname(String username);

    User findBySnameAndPassword(String username, String password);

//     @Query("SELECT * FROM usuarios WHERE username=:username and password=:pass")
//     User findByPassword(@Param("username") String username, @Param("pass") String pass);
}