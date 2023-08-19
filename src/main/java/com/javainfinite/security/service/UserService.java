package com.javainfinite.security.service;

import com.javainfinite.security.model.User;
import com.javainfinite.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User finByUserPassword(String sname, String pass){
        User user = userRepository.findBySnameAndPassword(sname, getSHA256(pass));
        return user;
    }

    public String getSHA256(String input){
        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }
    public Optional<User> findById(Long id) {
    	return userRepository.findById(id);
    }
    
    public User getDetails(String username) {
        return userRepository.findBySname(username);
    }

    public User registerStudent(User user) {
        user.setSrole("ROLE_GRADUATE");
        return userRepository.save(user);
    }

    public User registerCollaborator(User user) {
        user.setSrole("ROLE_COLLABORATOR");
        return userRepository.save(user);
    }

}
