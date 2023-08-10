package com.mrchapai.mr_chapai_movie_ticke.service;


import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import com.mrchapai.mr_chapai_movie_ticke.ropository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User usr) {
        return userRepository.save(usr);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Sucessfully Deleted user : "+id;
    }




}
