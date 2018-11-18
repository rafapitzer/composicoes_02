package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static Date moment = new Date();
	private OrderStatus status;
	private Client client;
	private List <OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}

	public static Date getMoment() {
		return moment;
	}

	public static void setMoment(Date moment) {
		Order.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addOrderItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeOrderItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem c : items) {
			sum += c.subTotal();
		}
		return sum;
	}
}
