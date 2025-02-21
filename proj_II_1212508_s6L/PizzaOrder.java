package application;
import java.util.Date;

/* Pizza Order class  */
public abstract class PizzaOrder implements Comparable<PizzaOrder> {

	private String customerName; // customerName : customer's name
	private Date dateOrdered; // dateOrdered : order's date
	private int pizzaSize; // pizzaSize : pizza's size
	public final static int SMALL = 1; // SMALL : pizza's size
	public final static int MEDIUM = 2; // MEDIUM : pizza's size
	public final static int LARGE = 3; // LARGE : pizza's size
	private int numberOfToppings; // numberOfToppings : toppings's number
	private double toppingPrice; // toppingPrice : topping's price

	/* Default constructor */
	public PizzaOrder() {
		this.pizzaSize = 0;
		this.customerName = "None";
		this.numberOfToppings = 0;
		this.toppingPrice = 0;
		this.dateOrdered = new Date();
	}

	/* NonDefault constructor */
	public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		this.customerName = customerName;
		while (true) // loop tests valid size of pizza and filled it
			if (pizzaSize == SMALL) {
				this.pizzaSize = SMALL;
				break;
			} else if (pizzaSize == MEDIUM) {
				this.pizzaSize = MEDIUM;
				break;
			} else if (pizzaSize == LARGE) {
				this.pizzaSize = LARGE;
				break;
			} else
				System.out.println("Enter valid number of pizza size please!");
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
		this.dateOrdered = new Date();
	}

	/* gets customer's name */
	public String getCustomerName() {
		return customerName;
	}

	/* sets customer's name */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/* gets order's date */
	public Date getDateOrdered() {
		return dateOrdered;
	}

	/* sets order's date */
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	/* gets pizza size */
	public String getPizzaSize() {
		if (pizzaSize == SMALL)
			return "small";
		else if (pizzaSize == MEDIUM)
			return "medium";
		else
			return "large";
	}

	/* gets pizza size */
	public void setPizzaSize(int pizzaSize) {
		while (true) // loop tests valid size of pizza and filled it
			if (pizzaSize == SMALL) {
				this.pizzaSize = SMALL;
				break;
			} else if (pizzaSize == MEDIUM) {
				this.pizzaSize = MEDIUM;
				break;
			} else if (pizzaSize == LARGE) {
				this.pizzaSize = LARGE;
				break;
			} else
				System.out.println("Enter valid number of pizza size please!");
	}

	/* gets toppings's number */
	public int getNumberOfToppings() {
		return numberOfToppings;
	}

	/* gets toppings's number */
	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}

	/* gets topping's price */
	public double getToppingPrice() {
		return toppingPrice;
	}

	/* sets topping's price */
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	/* comparable method */
	@Override
	public int compareTo(PizzaOrder o) {
		if (calculateOrderPrice() < o.calculateOrderPrice())
			return -1;
		else if (calculateOrderPrice() > o.calculateOrderPrice())
			return 1;
		else
			return 0;
	}

	/* Method calculate order's price */
	public double calculateOrderPrice() {
		return (numberOfToppings * toppingPrice) * pizzaSize;
	}

	/*
	 * Method prints order's information include : customer's name and the
	 * calculated order price
	 */
	public String printOrderInfo() {
		return (customerName + "     "+ Math.round(calculateOrderPrice())+"\n");
	}

	/* toString method return values of attributes of PizzaOrder class */
	@Override
	public String toString() {
		return "\nCustomer Name = " + customerName + "\nDate Ordered = " + dateOrdered + "\nPizza Size = "
				+ getPizzaSize() + "\nNumber Of Toppings = " + numberOfToppings + "\nTopping Price = " + toppingPrice;
	}

}
