package com.dhanesh.RestaurantManagementService.controller;

import com.dhanesh.RestaurantManagementService.model.Dto.SignInInput;
import com.dhanesh.RestaurantManagementService.model.Dto.SignUpOutput;
import com.dhanesh.RestaurantManagementService.model.Orderr;
import com.dhanesh.RestaurantManagementService.model.User;
import com.dhanesh.RestaurantManagementService.service.AuthenticationService;
import com.dhanesh.RestaurantManagementService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token) {
        if (authenticationService.authenticate(email, token)) {
            return userService.sigOutUser(email);
        } else {
            return "Sign out not allowed for non authenticated user.";
        }
    }

    @PostMapping("user/order")
    public String newOrder(String email , Orderr order){
        return  userService.newOrder(email,order);

    }
}
