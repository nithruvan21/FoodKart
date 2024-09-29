package foodKart;
import java.util.*;

public class Res_Owner {
	
	private String restaurant_name;
	private String password;
	public ArrayList<Integer>pincode=new ArrayList<Integer>();
	private String item_name;
	private int price;
	public int quantity;
	
	public Res_Owner() {
		
	}
	
	public Res_Owner(String restaurant_name, String password, ArrayList<Integer> pincode, String item_name, int price, int quantity) {
		super();
		this.restaurant_name = restaurant_name;
		this.password=password;
		this.pincode = pincode;
		this.item_name = item_name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Integer> getPincode() {
		return pincode;
	}
	public void setPincode(ArrayList<Integer> pincode) {
		this.pincode = pincode;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Res_Owner [restaurant_name=" + restaurant_name + ", pincode=" + pincode
				+ ", item_name=" + item_name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}