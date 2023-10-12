package com.dhanesh.RestaurantManagementService.service;

import com.dhanesh.RestaurantManagementService.model.FoodItem;
import com.dhanesh.RestaurantManagementService.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    IFoodRepo ifoodrepo;
    public List<FoodItem> getall() {
        return ifoodrepo.findAll();

    }
}
