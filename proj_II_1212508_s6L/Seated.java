package application;
/* Seated class that extend PizzaOrder */
public class Seated extends PizzaOrder {

	private double serviceCharge; // serviceCharge : seated's service charge
	private int numberOfPeople; // numberOfPeople : seated's number of people

	/* Default constructor */
	public Seated() {
		super();
		this.serviceCharge = 0;
		this.numberOfPeople = 0;
	}

	/* NonDefault constructor */
	public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,
			int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}
	
	

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/* Method calculate order's price */
	public double calculateOrderPrice() {
		return super.calculateOrderPrice() + (serviceCharge * numberOfPeople);
	}

	/* toString method return values of attributes of Seated class */
	@Override
	public String toString() {
		return super.toString() + "\nService Charge = " + serviceCharge + "\nNumber Of People = " + numberOfPeople
				+ "\nOrder Price = " + calculateOrderPrice();
	}

}
