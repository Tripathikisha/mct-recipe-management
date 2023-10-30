package com.Kishan.ReceipeManagementSystem.controller;

import com.Kishan.ReceipeManagementSystem.dto.SignInInput;
import com.Kishan.ReceipeManagementSystem.dto.SignInOutput;
import com.Kishan.ReceipeManagementSystem.dto.SignUpInput;
import com.Kishan.ReceipeManagementSystem.dto.SignUpOutput;
import com.Kishan.ReceipeManagementSystem.model.User;
import com.Kishan.ReceipeManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
