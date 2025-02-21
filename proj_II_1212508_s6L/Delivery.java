package application;
/* Delivery class that extend PizzaOrder */
public class Delivery extends PizzaOrder {

	private double tripRate; // tripRate : delivery trip rate
	private int zone; // zone : delivery zone

	/* Default constructor */
	public Delivery() {
		super();
		this.tripRate = 0;
		this.zone = 0;
	}

	/* NonDefault constructor */
	public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate,
			int zone) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}

	/* gets delivery's trip rate */
	public double getTripRate() {
		return tripRate;
	}

	/* sets delivery's trip rate */
	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	/* gets delivery's zone */
	public int getZone() {
		return zone;
	}

	/* sets delivery's zone */
	public void setZone(int zone) {
		this.zone = zone;
	}

	/* Method calculate order's price with delivery */
	@Override
	public double calculateOrderPrice() {
		return super.calculateOrderPrice() + ((tripRate / 100) * super.calculateOrderPrice() * zone);
	}

	/* toString method return values of attributes of Delivery class */
	@Override
	public String toString() {
		return super.toString() + "\nTrip Rate = " + tripRate + "\nZone = " + zone + "\nOrderPrice = "
				+ calculateOrderPrice();
	}

}
