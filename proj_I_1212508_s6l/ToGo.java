/* ToGo class that extend PizzaOrder */
public class ToGo extends PizzaOrder {

	/* Default constructor */
	public ToGo() {
		super();
	}

	/* NonDefault constructor */
	public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
	}

	@Override
	public String toString() {
		return super.toString() + "\nOrder Price = " + super.calculateOrderPrice();
	}

}
