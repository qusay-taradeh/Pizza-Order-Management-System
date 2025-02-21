package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {

	int numberOfToppings = 0;

	@Override
	public void start(Stage stage) {
		GridPane pane = new GridPane(); // this the pane contains all elements in the program
		ArrayList<PizzaOrder> orders = new ArrayList<>();

		Label customerName = new Label("Customer Name : ");
		pane.add(customerName, 0, 0);
		TextField customerNameText = new TextField();
		pane.add(customerNameText, 1, 0);

		Label orderType = new Label("Order Type : ");
		pane.add(orderType, 0, 1);
		RadioButton deliveryButton = new RadioButton("Delivery");
		RadioButton seatedButton = new RadioButton("Seated");
		RadioButton toGoButton = new RadioButton("ToGo");
		ToggleGroup types = new ToggleGroup();
		deliveryButton.setToggleGroup(types);
		seatedButton.setToggleGroup(types);
		toGoButton.setToggleGroup(types);

		VBox box = new VBox(5); // box contains type of order buttons. 
		box.getChildren().addAll(deliveryButton, seatedButton, toGoButton);
		pane.add(box, 1, 1);

		VBox deliveryBox, seatedBox; // deliveryBox contains attributes in Delivery class, seatedBox contains attributes in Seated class
		deliveryBox = new VBox(5);
		seatedBox = new VBox(5);
		Label tripRate = new Label("Trip Rate :");
		TextField tripRateField = new TextField();
		Label zone = new Label("Zone : ");
		TextField zoneField = new TextField();
		deliveryBox.getChildren().addAll(tripRate, tripRateField, zone, zoneField);
		pane.add(deliveryBox, 2, 1);

		Label serviceCharge = new Label("Service Charge : ");
		TextField serviceChargeField = new TextField();
		Label numberOfPeople = new Label("Number Of People : ");
		TextField numberOfPeopleField = new TextField();
		seatedBox.getChildren().addAll(serviceCharge, serviceChargeField, numberOfPeople, numberOfPeopleField);
		pane.add(seatedBox, 2, 1);

		Label pizzaSize = new Label("Pizza Size : ");
		pane.add(pizzaSize, 0, 2);
		RadioButton smallSize = new RadioButton("SMALL");
		RadioButton mediumSize = new RadioButton("MEDIUM");
		RadioButton largeSize = new RadioButton("LARG");
		ToggleGroup selected = new ToggleGroup(); // Toggle Group to hide or view selected button
		smallSize.setToggleGroup(selected);
		mediumSize.setToggleGroup(selected);
		largeSize.setToggleGroup(selected);
		smallSize.setSelected(true);
		pane.add(smallSize, 1, 2);
		pane.add(mediumSize, 2, 2);
		pane.add(largeSize, 3, 2);

		Label listOfToppingsLabel = new Label("List Of Toppings : ");
		pane.add(listOfToppingsLabel, 0, 3);
		VBox listBox = new VBox();
		String[] listOfToppings = { "Mushroom", "Onions", "Olives", "Tomato", "Green Peppers", "Extra cheese" };
		CheckBox chbox1 = new CheckBox(listOfToppings[0]); // chbox from 1 to 6 are choices in toppings list.
		CheckBox chbox2 = new CheckBox(listOfToppings[1]);
		CheckBox chbox3 = new CheckBox(listOfToppings[2]);
		CheckBox chbox4 = new CheckBox(listOfToppings[3]);
		CheckBox chbox5 = new CheckBox(listOfToppings[4]);
		CheckBox chbox6 = new CheckBox(listOfToppings[5]);
		listBox.getChildren().addAll(chbox1, chbox2, chbox3, chbox4, chbox5, chbox6);
		listBox.setSpacing(15);
		pane.add(listBox, 1, 3);

		Label toppingPrice = new Label("Topping Price : ");
		pane.add(toppingPrice, 0, 4);
		TextField toppingPriceText = new TextField("10");
		pane.add(toppingPriceText, 1, 4);

		Label orderPrice = new Label("Order Price : ");
		pane.add(orderPrice, 0, 5);
		TextField orderPriceText = new TextField("0");
		orderPriceText.setEditable(false);
		pane.add(orderPriceText, 1, 5);

		Button processOrder = new Button("Process Order");
		pane.add(processOrder, 0, 6);
		Button printOrders = new Button("Print Orders");
		pane.add(printOrders, 1, 6);
		Button reset = new Button("Reset");
		pane.add(reset, 2, 6);

		TextArea area = new TextArea();
		area.setMinHeight(50);
		area.setMinWidth(50);
		area.setMaxHeight(400);
		area.setMaxWidth(400);
		area.setEditable(false);

		deliveryBox.setVisible(false);
		seatedBox.setVisible(false);

		
		// actions when button clicked..
		toGoButton.setOnAction(e -> {
			deliveryBox.setVisible(false);
			seatedBox.setVisible(false);
		});

		deliveryButton.setOnAction(e -> {
			seatedBox.setVisible(false);
			if (deliveryBox.isVisible() == false)
				deliveryBox.setVisible(true);
			else
				deliveryBox.setVisible(true);

		});

		seatedButton.setOnAction(e -> {
			deliveryBox.setVisible(false);
			if (seatedBox.isVisible() == false)
				seatedBox.setVisible(true);
			else
				seatedBox.setVisible(true);
		});

		//Process order button
		processOrder.setOnAction(e -> {
			if (deliveryButton.isSelected() == true) {
				if (chbox1.isSelected())
					numberOfToppings++;
				if (chbox2.isSelected())
					numberOfToppings++;
				if (chbox3.isSelected())
					numberOfToppings++;
				if (chbox4.isSelected())
					numberOfToppings++;
				if (chbox5.isSelected())
					numberOfToppings++;
				if (chbox6.isSelected())
					numberOfToppings++;

				Delivery delivery = new Delivery();
				delivery.setCustomerName(customerNameText.getText());
				if (smallSize.isSelected() == true)
					delivery.setPizzaSize(Integer.parseInt("1"));
				else if (mediumSize.isSelected() == true)
					delivery.setPizzaSize(Integer.parseInt("2"));
				else if (largeSize.isSelected() == true)
					delivery.setPizzaSize(Integer.parseInt("3"));
				delivery.setToppingPrice(Double.parseDouble(toppingPriceText.getText()));
				delivery.setNumberOfToppings(numberOfToppings);
				delivery.setTripRate(Integer.parseInt(tripRateField.getText()));
				delivery.setZone(Integer.parseInt(zoneField.getText()));
				orderPriceText.setText(Double.toString(delivery.calculateOrderPrice()));
				orders.add(delivery);
				numberOfToppings = 0;

			} else if (seatedButton.isSelected() == true) {
				if (chbox1.isSelected())
					numberOfToppings++;
				if (chbox2.isSelected())
					numberOfToppings++;
				if (chbox3.isSelected())
					numberOfToppings++;
				if (chbox4.isSelected())
					numberOfToppings++;
				if (chbox5.isSelected())
					numberOfToppings++;
				if (chbox6.isSelected())
					numberOfToppings++;

				Seated seated = new Seated();
				seated.setCustomerName(customerNameText.getText());
				if (smallSize.isSelected() == true)
					seated.setPizzaSize(Integer.parseInt("1"));
				else if (mediumSize.isSelected() == true)
					seated.setPizzaSize(Integer.parseInt("2"));
				else if (largeSize.isSelected() == true)
					seated.setPizzaSize(Integer.parseInt("3"));
				seated.setToppingPrice(Double.parseDouble(toppingPriceText.getText()));
				seated.setNumberOfToppings(numberOfToppings);
				seated.setNumberOfPeople(Integer.parseInt(numberOfPeopleField.getText()));
				seated.setServiceCharge(Double.parseDouble(serviceChargeField.getText()));
				orderPriceText.setText(Double.toString(seated.calculateOrderPrice()));
				orders.add(seated);
				numberOfToppings = 0;

			} else if (toGoButton.isSelected() == true) {
				if (chbox1.isSelected()) // block checks toppings selected.
					numberOfToppings++;
				if (chbox2.isSelected())
					numberOfToppings++;
				if (chbox3.isSelected())
					numberOfToppings++;
				if (chbox4.isSelected())
					numberOfToppings++;
				if (chbox5.isSelected())
					numberOfToppings++;
				if (chbox6.isSelected())
					numberOfToppings++;

				ToGo toGo = new ToGo();
				toGo.setCustomerName(customerNameText.getText());
				if (smallSize.isSelected() == true)
					toGo.setPizzaSize(Integer.parseInt("1"));
				else if (mediumSize.isSelected() == true)
					toGo.setPizzaSize(Integer.parseInt("2"));
				else if (largeSize.isSelected() == true)
					toGo.setPizzaSize(Integer.parseInt("3"));
				toGo.setToppingPrice(Double.parseDouble(toppingPriceText.getText()));
				toGo.setNumberOfToppings(numberOfToppings);
				orderPriceText.setText(Double.toString(toGo.calculateOrderPrice()));
				orders.add(toGo);
				numberOfToppings = 0;
			}

		});

		// Print Orders button
		printOrders.setOnAction(e -> {
			Stage printerStage = new Stage();
			GridPane printerPane = new GridPane();
			sortOrders(orders); // sorting the orders.

			String information = ""; // String contains orders information.
			for (int i = 0; i < orders.size(); i++)
				information += orders.get(i).printOrderInfo();
			area.setText("Customer Name |" + " Order Price\n" + information);
			printerPane.add(area, 0, 0);
			printerPane.setAlignment(Pos.CENTER);
			printerStage.setScene(new Scene(printerPane, 500, 500));
			printerStage.setTitle("Orders Information");
			printerStage.show();
		});

		// Reset button
		reset.setOnAction(e -> {
			customerNameText.setText(null);
			numberOfPeopleField.setText(null);
			orderPriceText.setText("0");
			serviceChargeField.setText(null);
			toppingPriceText.setText("10");
			tripRateField.setText(null);
			zoneField.setText(null);
			area.setText(null);
			deliveryBox.setVisible(false);
			seatedBox.setVisible(false);
			chbox1.setSelected(false);
			chbox2.setSelected(false);
			chbox3.setSelected(false);
			chbox4.setSelected(false);
			chbox5.setSelected(false);
			chbox6.setSelected(false);
			deliveryButton.setSelected(false);
			seatedButton.setSelected(false);
			toGoButton.setSelected(false);
			smallSize.setSelected(true);
			orders.removeAll(orders);
		});

		pane.setPadding(new Insets(30, 30, 30, 30));
		pane.setAlignment(Pos.CENTER);

		pane.setVgap(20);
		pane.setHgap(20);

		Scene scene = new Scene(pane, 1260, 720);
		stage.setTitle("Pizza Order");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
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
