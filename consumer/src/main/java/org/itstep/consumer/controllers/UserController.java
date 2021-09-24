package org.itstep.consumer.controllers;

import org.itstep.consumer.models.User;
import org.itstep.consumer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public String loginUser(@RequestParam(name = "username") String userName,
                          @RequestParam(name = "pass") String pass){
        if(Objects.nonNull(service.getUserByUserName(userName))){
            return "redirect:/";
        }else{
            return "redirect:/register";
        }
    }

//
//    @GetMapping("/all")
//    public String getAllUsers(){
//        List<User> all = repository.findAll();
//        return new ResponseEntity<>(all, HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public Boolean loginUser(@RequestBody User user){
//        return true;
//    }
}
