package com.dhanesh.RestaurantManagementService.repository;

import com.dhanesh.RestaurantManagementService.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<FoodItem,Long> {

}
