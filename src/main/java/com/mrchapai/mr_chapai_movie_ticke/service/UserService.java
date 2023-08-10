package com.mrchapai.mr_chapai_movie_ticke.service;


import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import com.mrchapai.mr_chapai_movie_ticke.ropository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User usr) {
        return userRepository.save(usr);
    }

    public User getUser(int id){
        return userRepository.findById(id).get();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User usr){
        User existingUser = userRepository.findById(usr.getId()).get();
        existingUser.setName(usr.getName());
        existingUser.setUserName(usr.getUserName());
        existingUser.setPassword(usr.getPassword());
        return userRepository.save(existingUser);

    }



}
