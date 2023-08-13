package com.mrchapai.mr_chapai_movie_ticke.controller;

import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import com.mrchapai.mr_chapai_movie_ticke.exceptionHandler.ControllerExceptionHandler;
import com.mrchapai.mr_chapai_movie_ticke.exceptionHandler.ResourceNotFound;
import com.mrchapai.mr_chapai_movie_ticke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

@GetMapping("/")
public String homePage(){
    return "shubash Dai";
}



    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable ("id") int id){
                return userService.getUser(id);
    }


    @PostMapping("/addUser")
    public User  addUser(@RequestBody User usr){
         return userService.saveUser(usr);
    }


   @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
       userService.deleteUser(id);
  }

    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam int id){
        userService.deleteUser(id);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User urs){
        return userService.updateUser(urs);
    }
}
