# Pizza Order Management System

A complete Java application for managing pizza orders that supports three order types (ToGo, Delivery, and Seated) and provides both a console-based driver and a JavaFX graphical user interface.

## Summary

This project implements a pizza ordering system using object-oriented design in Java. The application includes the following classes:

- **PizzaOrder**: Implements the `Comparable` interface and holds common attributes such as customer name, order date, pizza size, number of toppings, and topping price. It also provides methods for calculating the order price and printing order information.
- **Delivery**: Extends `PizzaOrder` and adds attributes for trip rate and delivery zone. It overrides the `toString()` and `calculateOrderPrice()` methods to include additional delivery charges.
- **ToGo**: Extends `PizzaOrder` with no additional attributes.
- **Seated**: Extends `PizzaOrder` and adds attributes for service charge and number of people. It overrides the `toString()` and `calculateOrderPrice()` methods to include a service charge.
- **Driver**: Contains the `main` method which:
  - Creates an `ArrayList<PizzaOrder>` (named `orders`) and adds five orders (two Delivery, one ToGo, and two Seated) using the constructors with the attribute order:
    - `PizzaOrder(customerName, pizzaSize, numberOfToppings, toppingPrice)`
    - `Delivery(customerName, pizzaSize, numberOfToppings, toppingPrice, tripRate, zone)`
    - `ToGo(customerName, pizzaSize, numberOfToppings, toppingPrice)`
    - `Seated(customerName, pizzaSize, numberOfToppings, toppingPrice, serviceCharge, numberOfPeople)`
  - Sorts the orders based on their calculated price.
  - Prints the sorted orders’ customer names and order prices.
  - Calculates and prints the total sum of all order prices.
  - Prints a full report (all properties and the order price) for the second Delivery order.
  - Provides two utility methods:
    - `sortOrders(ArrayList<PizzaOrder> orders)`
    - `calculateTotalOrdersPrice(ArrayList<PizzaOrder> orders)`

Additionally, the project includes a JavaFX GUI that allows the user to configure a pizza order. The interface features:

- **Input Controls**:
  - A `TextField` for the customer's name.
  - A `ComboBox` or set of `RadioButtons` to select the order type (ToGo, Delivery, or Seated).
  - A selection for pizza size (1 = SMALL, 2 = MEDIUM, 3 = LARGE) with a default of SMALL.
  - A list (using `CheckBox` controls) of toppings (e.g., Onions, Olives, Green Peppers) with a default topping price (10.0) and no toppings selected by default.
  - A display field for the calculated order price (default 0.0).

- **Dynamic Fields**:
  - When **Delivery** is selected, fields for `tripRate` (double) and `zone` (int) appear.
  - When **Seated** is selected, fields for `serviceCharge` (double) and `numberOfPeople` (int) are shown instead.
  - For **ToGo** orders, the additional fields are hidden.

- **Action Buttons**:
  - **ProcessOrder**: Creates an appropriate pizza order object (ToGo, Delivery, or Seated) from the entered data, calculates the order price, displays it on the GUI, and adds the order to an `orders` list.
  - **PrintOrders**: Sorts and displays a list of customer names and order prices from the `orders` list in a new stage.
  - **Reset**: Resets all fields and controls to their default values and clears the `orders` list.

## Usage

### Console Version

1. Run the `Driver` class.
2. The program automatically creates five orders (as described above).
3. It sorts and prints the customer names and order prices.
4. It then prints the total sum of all order prices.
5. Finally, it outputs a detailed report for the second Delivery order.

### JavaFX GUI Version

1. Run the JavaFX application (the main GUI class in the project).
2. Fill in the customer's name, select the order type, choose the pizza size, and pick desired toppings.
3. For Delivery or Seated orders, fill in the additional fields that appear.
4. Click **ProcessOrder** to calculate and display the order price and add the order to the system.
5. Click **PrintOrders** to view all current orders in a separate window.
6. Click **Reset** to clear the form and start over.

## Author

Qusay Taradeh
