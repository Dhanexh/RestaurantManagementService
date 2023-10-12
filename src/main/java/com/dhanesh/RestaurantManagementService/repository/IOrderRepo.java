package com.dhanesh.RestaurantManagementService.repository;

import com.dhanesh.RestaurantManagementService.model.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Orderr,Long> {

}
