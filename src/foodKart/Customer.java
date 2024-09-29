package foodKart;
public class Customer {
	public static int cust_id=4;
	private int id;
	private String Name;
	private String password;
	private char Gender;
	private String phNo;
	private int pincode;
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String password, char gender, String phNo, int pincode) {
		super();
		this.id=id;
		Name = name;
		this.password = password;
		Gender = gender;
		this.phNo = phNo;
		this.pincode = pincode;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Customer [Name=" + Name + ", Gender=" + Gender + ", phNo=" + phNo + ", pincode=" + pincode + "]";
	}
	
	
}
