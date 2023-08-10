package com.mrchapai.mr_chapai_movie_ticke.controller;

import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import com.mrchapai.mr_chapai_movie_ticke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User usr){
        return userService.saveUser(usr);
    }
    @DeleteMapping("/delete/{di}")
    public void userDelete(@PathVariable int id){
         userService.deleteUser(id);
    }


}
