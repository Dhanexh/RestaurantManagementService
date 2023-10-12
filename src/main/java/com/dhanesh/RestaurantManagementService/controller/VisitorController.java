package com.dhanesh.RestaurantManagementService.controller;

import com.dhanesh.RestaurantManagementService.model.FoodItem;
import com.dhanesh.RestaurantManagementService.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class VisitorController {
    @Autowired
    FoodItemService foodservice;
    @GetMapping()
    public List<FoodItem> getall(){
        return foodservice.getall();
    }
}
