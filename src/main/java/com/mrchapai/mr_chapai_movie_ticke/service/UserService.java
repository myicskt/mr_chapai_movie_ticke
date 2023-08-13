package com.mrchapai.mr_chapai_movie_ticke.service;

import com.mrchapai.mr_chapai_movie_ticke.entity.User;
import com.mrchapai.mr_chapai_movie_ticke.exceptionHandler.ResourceDataNotMatch;
import com.mrchapai.mr_chapai_movie_ticke.exceptionHandler.ResourceNotFound;
import com.mrchapai.mr_chapai_movie_ticke.ropository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

 public User saveUser1(User usr) {
     return userRepository.save(usr);
 }

    public User saveUser(User usr) {
        User newUser =usr;
        if (newUser.getUserName()!= null && newUser.getName()!= null && newUser.getPassword()!= null) {
            userRepository.save(usr);
        } else {
            throw new ResourceDataNotMatch("data could not empty");
        }
        return newUser;
    }


    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No Data Found"));
        // return userRepository.findById(id).get(); Why this get() method neet to remove Opeional Obj
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User usr) {
        //User existingUser = userRepository.findById(usr.getId()).orElseThrow();
        User existingUser = new User();
        Optional<User> byId = userRepository.findById(usr.getId());
       if( byId.isPresent()){
           existingUser.setId(byId.get().getId());
           existingUser.setUserName(byId.get().getUserName());
           existingUser.setUserName(byId.get().getPassword());
           userRepository.save(existingUser);
           //
       }
       else {
           throw new ResourceDataNotMatch("Data Not found for id");
       }

        //Optional<User> byId1 = userRepository.findById(byId);
        return usr;

    }


}
