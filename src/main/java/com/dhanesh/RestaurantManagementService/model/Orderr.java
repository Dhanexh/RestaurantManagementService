package com.dhanesh.RestaurantManagementService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long orderQuantity;
    private OrderStatus  orderStatus;




    @ManyToOne
    User user;

    @OneToMany
    List<FoodItem> foodItem;

}
