package foodKart;
public class Orders {
	private int cust_id;
	private String cust_name;
	private String res_name;
	private String item_name;
	private int quantity;
	private int total_price;
	
	public Orders() {
		
	}
	public Orders(int cust_id, String cust_name, String res_name, String item_name, int quantity, int total_price) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.res_name = res_name;
		this.item_name = item_name;
		this.quantity = quantity;
		this.total_price = total_price;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "Orders [cust_id=" + cust_id + ", cust_name=" + cust_name + ", res_name=" + res_name + ", item_name="
				+ item_name + ", quantity=" + quantity + ", total_price=" + total_price + "]";
	}
	
	
}