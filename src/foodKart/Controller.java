package foodKart;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Controller {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Res_Owner> resList = new ArrayList<Res_Owner>();
	static ArrayList<Orders> orderList = new ArrayList<Orders>();
	
	public static void main(String[] args) {
		poppulateData();
//		for(Customer c: customerList){
//			System.out.println(c.toString());
//		}
		System.out.println("-----FoodKart-----");
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			int choice = 0;
			System.out.println("Welcome to Swimato!!!");
			System.out.println("1.Customer Login");
			System.out.println("2.Restaurant Owner Login");
			System.out.println("3.Admin Login");
			System.out.println("4.Create new customer");
			System.out.println("5.Create new restaurant");
			System.out.println("6.Exit");
			System.out.println("Enter Your Choice Here: ");
			choice=sc.nextInt();
			
			switch(choice) {
				case 1:{
					customerLogin();
					break;
				}
				case 2:{
					restaurantOwnerLogin();
					break;
				}
				case 3:{
					adminLogin();
					break;
				}
				case 4:{
					createNewCustomer();
					break;
				}
				case 5:{
					createNewRestaurant();
					break;
				}
				case 6:{
					System.out.println("ThankYou");
					loop=false;
					break;
				}	
				default:{
					System.out.println("Invalid Input!!!");
				}
			}
		}
		sc.close();
	}
	
	private static void poppulateData() {
		Customer c1 = new Customer(1,"Nithruvan","123456",'M',"7904685500",11); 
		Customer c2 = new Customer(2,"Mohan","654321",'M',"9865115700",12);
		Customer c3 = new Customer(3,"Kartickeyan","98765",'M',"9876543210",21);
		Customer c4 = new Customer(4,"Karthik","123456",'M',"8767897654",22);
		
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);
		
		//pincodes are stored in arrayList for ease of access when customer orders food
		//pincodes can be easily updated if they are stored in arrayList
		ArrayList<Integer> pin1 = new ArrayList<Integer>();
		ArrayList<Integer> pin2 = new ArrayList<Integer>();
		ArrayList<Integer> pin3 = new ArrayList<Integer>();
		ArrayList<Integer> pin4 = new ArrayList<Integer>();
		pin1.add(11);
		pin1.add(21); //res 1 can server 11 and 21
		pin2.add(11);
		pin2.add(22);//res 2 can server 11 and 22
		pin3.add(12);
		pin3.add(21);//res 3 can server 12 and 21
		pin4.add(22);
		pin4.add(12);//res 4 can server 22 and 12
		Res_Owner r1 = new Res_Owner("Annapoorna","veg",pin1,"Sambhar Idly",80,5);
		Res_Owner r2 = new Res_Owner("HMR","bestbiriyani",pin2,"Mutton Biriyani",320,7);
		Res_Owner r3 = new Res_Owner("Bhurma Bhai","noolparota",pin3,"Pichu Pota Chicken",220,4);
		Res_Owner r4 = new Res_Owner("Valarmathi Mess","salna",pin1,"Kari Dosai",180,6);
		
		resList.add(r1);
		resList.add(r2);
		resList.add(r3);
		resList.add(r4);
	}
	
	private static void customerLogin() {
		Scanner sc = new Scanner(System.in);
		String name="";
		String password="";
		Customer currCustomer = new Customer();
		int curCusId=0;
		
		System.out.println("-----Customer Login Page-----\n");
		try {
			System.out.println("Enter your Name: ");
			name=sc.nextLine();
			System.out.println("Enter your Password: ");
			password=sc.nextLine();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		boolean found=false;
		for(Customer c:customerList) { // looping inside the customerList ArrayList to check whether the given credentials match or not
			if(c.getName().equals(name) && c.getPassword().equals(password)) {
				currCustomer = c; // storing a clone of the valid customer in currCustomer for further access
				curCusId=c.getId(); 
				System.out.println("You are successfully loged in..!");
				found=true; // flag updated
				break;
			}
		}
		if(!found) {
			System.out.println("Invalid Username or Password!!!");
			System.out.println();
			return;
		}else {
			System.out.println("Customer id: "+ curCusId);
			
		}
		System.out.println("Logout");
		sc.nextLine();
}
	
	private static void restaurantOwnerLogin() {
		Scanner sc = new Scanner(System.in);
		String resName = "";
		String password = "";
		Res_Owner currRess = new Res_Owner();
		boolean found=false;
		System.out.println("-----Restaurant Owner Login Page-----\n");
		try {
			System.out.println("Enter the Restaurant name: ");
			resName= sc.nextLine();
			System.out.println("Enter the password: ");
			password= sc.nextLine();
		}catch(Exception e) {
			System.out.println(e);
		}
		for(Res_Owner r:resList) {
			if(r.getRestaurant_name().equals(resName) && r.getPassword().equals(password)) {
				currRess = r;
				System.out.println("You are successfully loged in..!\n");
				found=true;
				break;
			}
		}
		if(!found) {
			System.out.println("Invalid Restaurant Name or Password!!!");
			return;
		}
		else {
			System.out.println("Edit Quantity or Update Pincode\n");
		}
		System.out.println("Logout");
		sc.nextLine();
	}
	
	public static boolean isValidName(String name) {
		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
	
	private static void createNewCustomer() {
		Scanner sc = new Scanner(System.in);
		String name="";
		String password = "";
		String tempPw ="";
		char gender='f';
		int pincode = 0;
		String phno = "";
		
		System.out.println("Welcome New Customer!!!\n");
		try {
			System.out.println("Enter your Name:(Cant accept anything other than alphabets) ");
			name = sc.nextLine();
			if(!isValidName(name)) {
				System.out.println("Not a valid name \n");
				createNewCustomer();
			}
			System.out.println("Enter your Password: ");
			password = sc.nextLine();
			System.out.println("Re-enter your Password: ");
			tempPw = sc.nextLine();
			if(!password.equals(tempPw)) {
				System.out.println("Password didnt match!!\n");
				createNewCustomer();
			}
			System.out.println("Enter your Gender:((M/m)(F/f)(O/o)) ");
			gender=sc.next().charAt(0);
			System.out.println("Enter your Pincode: ");
			pincode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your Phone Number:(if already registered, enter a new phno!!) ");
			phno = sc.nextLine();
			for(Customer c : customerList) { //for checking whether the phno is already registered
				if(c.getPhNo().equals(phno)) {
					System.out.println("You are already a customer\nPlease register with a new number\n");
					createNewCustomer();
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		Customer newCustomer = new Customer(++Customer.cust_id,name,password,gender,phno,pincode);
		customerList.add(newCustomer);
		System.out.println("Your Username is: "+name);
		System.out.println("Your Password is:"+password);
		for(Customer c:customerList) {
			System.out.println(c.toString());
		}
		System.out.println("Logout");
		sc.nextLine();
	}
	
	private static void createNewRestaurant() {
		System.out.println("You are in admin Login");
	}
	
	private static void adminLogin() {
		System.out.println("You are in admin Login");
	}
}
