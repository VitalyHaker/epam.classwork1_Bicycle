package by.tc.classwork01.entity;

public class Order {

	private int order_id;
	private int user_id;
	private int bike_id;
	private String bike_name;
	private int price;
	private int term;
	private String status_payment;
	private int total_cost;

	public Order(int order_id, int user_id, int bike_id, String bike_name, int price, int term,
			String status_payment, int total_cost) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.bike_id = bike_id;
		this.bike_name = bike_name;
		this.price = price;
		this.term = term;
		this.status_payment = status_payment;
		this.total_cost = total_cost;
	}
	public Order(int user_id, int bike_id, String bike_name, int price, int term,
			String status_payment, int total_cost) {
		this.user_id = user_id;
		this.bike_id = bike_id;
		this.bike_name = bike_name;
		this.price = price;
		this.term = term;
		this.status_payment = status_payment;
		this.total_cost = total_cost;
	}
	
	public Order( String bike_name, int price, int term,
			String status_payment, int total_cost) {
		this.bike_name = bike_name;
		this.price = price;
		this.term = term;
		this.status_payment = status_payment;
		this.total_cost = total_cost;
	}

	public Order(int order_id) {
		this.order_id = order_id;
		this.user_id = 0;
		this.bike_id = 0;
		this.status_payment = "no pay";

	}

	public Order(int order_id, String status_payment) {
		this.order_id = order_id;
		this.status_payment = status_payment;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBike_id() {
		return bike_id;
	}

	public void setBike_id(int bike_id) {
		this.bike_id = bike_id;
	}

	public String getStatus_payment() {
		return status_payment;
	}

	public void SetStatus_payment(String status_payment) {
		this.status_payment = status_payment;
	}

	public void setBike_name(String bike_name) {
		this.bike_name = bike_name;
	}

	public String getBike_name() {
		return bike_name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setStatus_payment(String status_payment) {
		this.status_payment = status_payment;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

}
