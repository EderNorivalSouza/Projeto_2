package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("ss/MM/yyyy HH:mm:ss");
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItem>getItems(){
		return items;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public double total() {
		double sum = 0.0;
		for (OrderItem item:items) {
			sum += item.SubTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment)+"\n");
		sb.append("Order Status: ");
		sb.append(status +"\n");
		sb.append("Client: ");
		sb.append(client+"\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item+"\n");
		}
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();
	}
}
