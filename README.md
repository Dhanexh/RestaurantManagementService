# Restaurant Management System

This is a basic guide for a Restaurant Management System developed using Spring Boot. The system has three types of users: Admin, Normal User, and Visitor. The system allows CRUD (Create, Read, Update, Delete) operations for the following entities: User, FoodItem, and Order.

## User Entity

The User entity represents the three types of users in the system. 

**Attributes:**
- `username` (String): The username of the user.
- `password` (String): The password of the user.
- `email` (String): The email address of the user. For Admin users, the email must be of the form `something@admin.com`. Validation is applied to enforce this rule.

## FoodItem Entity

The FoodItem entity represents the various food items available in the restaurant.

**Attributes:**
- `title` (String): The title of the food item.
- `description` (String): A description of the food item.
- `price` (Double): The price of the food item.
- `dummyImageUrl` (String): A hyperlink to a dummy image for the food item. This is optional and is used for Intermediate Level.

## Order Entity

The Order entity represents the orders placed by Normal Users.

**Attributes:**
- `orderID` (Long): An ID for the order.
- `foodItemID` (Long): The ID of the FoodItem in the order.
- `quantity` (int): The quantity of the food item ordered.
- `userID` (Long): The ID of the user who placed the order.
- `status` (String): The status of the order, which can be "created," "dispatched," or "delivered." 

## User Roles

- **Admin User**: Admin users have special privileges, such as the ability to create food items, see all users, etc. They are identified by their email address ending in `@admin.com`.

- **Normal User**: Normal users have access to general features and can place orders.

- **Visitor User**: Visitors can view the restaurant's offerings but cannot place orders or access certain features.

## Basic Level Features

- User authentication (Sign-in and Sign-up).
- Role-based access control (Admin, Normal User, and Visitor).
- Create, Read, Update, and Delete operations for User, FoodItem, and Order entities.
