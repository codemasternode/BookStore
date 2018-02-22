package com.bookstore.reeesst.controllers;


import com.bookstore.reeesst.enties.User;
import com.bookstore.reeesst.helpers.ApiRespone;
import com.bookstore.reeesst.helpers.ApiRespone.Status;
import com.bookstore.reeesst.helpers.ApiRespone.ApiError;
import com.bookstore.reeesst.repositories.UserRepo;
import com.bookstore.reeesst.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @RequestMapping("/getUser/{username}")
    public User getUser(@PathVariable String username){
        return userRepo.findByUsername(username);
    }

    @RequestMapping("/checkUsername/{username}")
    public ApiRespone checkUsername(@PathVariable String username){
        User user = userRepo.findByUsername(username);
        if(user == null) {
            return new ApiRespone(Status.Ok,null);
        }else {
            return new ApiRespone(Status.Error,new ApiError("User error","This user existing now!!!!"));
        }
    }

    @RequestMapping("/checkEmail/{username}")
    public ApiRespone checkEmail(@PathVariable String email){
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return new ApiRespone(Status.Ok,null);
        }else {
            return new ApiRespone(Status.Error,new ApiError("User error","This user existing now!!!!"));
        }
    }



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ApiRespone registryUser(@RequestBody User user){
        User userGettingByUsername = userRepo.findByUsername(user.getUsername());
        User userGettingByEmail = userRepo.findByEmail(user.getEmail());
        if (userGettingByUsername == null && userGettingByEmail == null) {
            userService.insert(user);
            return new ApiRespone(Status.Ok,null);
        }else if(userGettingByUsername != null){
            return new ApiRespone(Status.Error,new ApiError("Client Error","User with this username is existing now!!!"));
        }else{
            return new ApiRespone(Status.Error,new ApiError("Client Error","User with this email is existing now!!!"));
        }
    }


}
