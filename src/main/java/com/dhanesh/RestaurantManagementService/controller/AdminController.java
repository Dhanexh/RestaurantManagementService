package com.dhanesh.RestaurantManagementService.controller;

import com.dhanesh.RestaurantManagementService.model.Admin;
import com.dhanesh.RestaurantManagementService.model.Dto.SignInInput;
import com.dhanesh.RestaurantManagementService.model.Dto.SignUpOutput;
import com.dhanesh.RestaurantManagementService.model.FoodItem;
import com.dhanesh.RestaurantManagementService.service.AdminService;
import com.dhanesh.RestaurantManagementService.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@Validated
@RestController
public class AdminController {


    @Autowired
    AdminService adminService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("admin/signup")
    public SignUpOutput signUpAdmin(@RequestBody Admin admin) throws NoSuchAlgorithmException {

        return adminService.signUpAdmin(admin);
    }

    @PostMapping("admin/signIn")
    public String sigInAdmin(@RequestBody @Valid SignInInput signInInput)
    {
        return adminService.signInAdmin(signInInput);
    }

    @DeleteMapping("admin/signOut")
    public String sigOutAdmin(String email, String token) {
        if (authenticationService.authenticate(email, token)) {
            return adminService.sigOutAdmin(email);
        } else {
            return "Sign out not allowed for non authenticated admin.";
        }
    }
    @PostMapping("admin/fooditem")
    public String addFoodItem(FoodItem foodList, String email){
        return adminService.addFoodItem(foodList, email);
    }



}
