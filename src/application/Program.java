package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	void main() throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		IO.println("\033[1mEnter client data:\033[0m");
		IO.print("Name: ");
		String name = sc.nextLine();
		IO.print("Email: ");
		String email = sc.nextLine();
		IO.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		IO.println("\033[1mEnter order data:\033[0m");
		IO.print("Status: ");
		Date moment = new Date();
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		Order order = new Order(moment, orderStatus, client);
		
		IO.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=n; i++) {
			IO.println("\033[1mEnter #" + i + " item data:\033[0m");
			IO.print("Product name: ");
			String productName = sc.nextLine();
			IO.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(productName, price);
			
			IO.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		
		IO.println();
		IO.println("\033[1mORDER SUMMARY:\033[0m");
		IO.println(order);
		
		sc.close();
	}

}
