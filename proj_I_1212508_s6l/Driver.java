import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {

		ArrayList<PizzaOrder> orders = new ArrayList<>(5);

		Delivery[] delivery = new Delivery[2];
		delivery[0] = new Delivery("Suha", PizzaOrder.MEDIUM, 2, 5, 20, 2);
		delivery[1] = new Delivery("Aakif", PizzaOrder.SMALL, 10, 6.99, 50, 4);
		orders.add(delivery[0]);
		orders.add(delivery[1]);

		ToGo toGo = new ToGo("Amal", PizzaOrder.LARGE, 1, 13.99);
		orders.add(toGo);

		Seated[] seated = new Seated[2];
		seated[0] = new Seated("Basma", PizzaOrder.MEDIUM, 1, 9.99, 2, 1);
		seated[1] = new Seated("Aziz", PizzaOrder.SMALL, 6, 6.99, 4, 6);
		orders.add(seated[0]);
		orders.add(seated[1]);

		sortOrders(orders);

		for (int i = 0; i < orders.size(); i++)
			orders.get(i).printOrderInfo();

		System.out.printf("Total sum of Order Prices = %5.2f\n", calculateTotalOrdersPrice(orders));

		System.out.println(orders.get(1));

	}

	/* method sorts orders */
	public static void sortOrders(ArrayList<PizzaOrder> orders) {
		Collections.sort(orders);
	}

	/* method return calculated total orders price */
	public static double calculateTotalOrdersPrice(ArrayList<PizzaOrder> orders) {
		double sum = 0;
		for (int i = 0; i < orders.size(); i++)
			sum += orders.get(i).calculateOrderPrice();

		return sum;
	}

}
