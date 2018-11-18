package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List <OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
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
		for(OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " ");
		sb.append("(" + client.getBirthDate() + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items ) {
			sb.append(item.getProduct().getName() + ", $");
			sb.append(String.format("%.2f", item.getProduct().getPrice()) + ",");
			sb.append(" Quantity: ");
			sb.append(item.getQuantity() + ",");
			sb.append(" Subtotal: $");
			sb.append(String.format("%.2f", item.subTotal()) + "\n");
			
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
