package com.dhanesh.RestaurantManagementService.repository;

import com.dhanesh.RestaurantManagementService.model.Admin;
import com.dhanesh.RestaurantManagementService.model.AuthenticationToken;
import com.dhanesh.RestaurantManagementService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByAdmin(Admin admin);
}
