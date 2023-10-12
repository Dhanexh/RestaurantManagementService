package com.dhanesh.RestaurantManagementService.service;

import com.dhanesh.RestaurantManagementService.model.Admin;
import com.dhanesh.RestaurantManagementService.model.AuthenticationToken;
import com.dhanesh.RestaurantManagementService.model.Dto.SignInInput;
import com.dhanesh.RestaurantManagementService.model.Dto.SignUpOutput;
import com.dhanesh.RestaurantManagementService.model.FoodItem;
import com.dhanesh.RestaurantManagementService.repository.IAdminRepo;
import com.dhanesh.RestaurantManagementService.repository.IFoodRepo;
import com.dhanesh.RestaurantManagementService.service.HashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    IFoodRepo ifoodRepo;

    @Autowired
    AuthenticationService authenticationService;

    public SignUpOutput signUpAdmin(Admin admin) throws NoSuchAlgorithmException {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = admin.getAdminEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }


        Admin existingAdmin = adminRepo.findFirstByAdminEmail(newEmail);

        if (existingAdmin != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }


        String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());


        admin.setAdminPassword(encryptedPassword);
        adminRepo.save(admin);

        return new SignUpOutput(signUpStatus, "Admin registered successfully!!!");
    }




    public String signInAdmin(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }


        Admin existingAdmin = adminRepo.findFirstByAdminEmail(signInEmail);

        if(existingAdmin == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }


        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingAdmin.getAdminPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and admin id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingAdmin);
                authenticationService.saveAuthToken(authToken);

            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

        return signInStatusMessage;
    }


    public String sigOutAdmin(String email) {

        Admin admin = adminRepo.findFirstByAdminEmail(email);
        AuthenticationToken token = authenticationService.findFirstByAdmin(admin);
        authenticationService.removeToken(token);
        return "Admin Signed out successfully";
    }

    public String addFoodItem(FoodItem foodList, String email) {
        Admin admin = adminRepo.findFirstByAdminEmail(email);
        AuthenticationToken token = authenticationService.findFirstByAdmin(admin);
        if(token != null){
            ifoodRepo.save(foodList);
            return   "foodList update successfully";
        }
        else{
            return "not a admin";
        }
    }
}
