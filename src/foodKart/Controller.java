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
			System.out.println("6.View restaurants");
			System.out.println("7.Exit");
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
					viewRestaurants(1); // defaultly by rating
				}
				case 7:{
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
		Res_Owner r1 = new Res_Owner("Annapoorna","veg",pin1,"Sambhar Idly",80,5,4.0);
		Res_Owner r2 = new Res_Owner("HMR","bestbiriyani",pin2,"Mutton Biriyani",320,7,4.1);
		Res_Owner r3 = new Res_Owner("Bhurma Bhai","noolparota",pin3,"Pichu Pota Chicken",220,4,4.2);
		Res_Owner r4 = new Res_Owner("Valarmathi Mess","salna",pin1,"Kari Dosai",180,6,4.3);
		
		resList.add(r1);
		resList.add(r2);
		resList.add(r3);
		resList.add(r4);
	}

	private static void viewRestaurants(int ch){
		if(ch==1){
			System.out.println("Viewing restaurants based on rating");
			for(int i=0;i<resList.size()-1;i++){
				int maxRate = i;
				for(int j=i+1;j<resList.size();j++){
					if(resList.get(maxRate).getRating()<resList.get(j).getRating()){
						maxRate=j;
					}
					if (maxRate != i) {
						Res_Owner temp = resList.get(i);
						resList.set(i, resList.get(maxRate));
						resList.set(maxRate, temp);
					}
				}
			}
			for(Res_Owner res:resList){
				System.out.println("Rated: "+res.getRating());
				System.out.println(res);
				System.out.println();
			}
		}
		else if(ch==2){
			System.out.println("Viewing restaurants based on price");
			for(int i=0;i<resList.size()-1;i++){
				int maxRate = i;
				for(int j=i+1;j<resList.size();j++){
					if(resList.get(maxRate).getPrice()<resList.get(j).getPrice()){
						maxRate=j;
					}
					if (maxRate != i) {
						Res_Owner temp = resList.get(i);
						resList.set(i, resList.get(maxRate));
						resList.set(maxRate, temp);
					}
				}
			}
			for(Res_Owner res:resList){
				System.out.println(res);
			}
		}
	}
	
	
	private static void customerLogin() {
		Scanner sc = new Scanner(System.in);
		String name="";
		String password="";
		Customer currCustomer = new Customer();
		int curCusId=0;
		
		System.out.println("-----Customer Login Page-----");
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
			boolean loop=true;
			System.out.println("Hello "+currCustomer.getName()+"!!!");
			while(loop){
				System.out.println("1.View Restaurants");
				System.out.println("2.Order Food");
				System.out.println("3.Exit");
				int ch = sc.nextInt();
				switch (ch) {
					case 1:
						boolean looop=true;
						while(looop){
							System.out.println("1.View restaurants by rating");
							System.out.println("2.View restaurants by price");
							System.out.println("3.exit viewing portal");
							int chh=sc.nextInt();
							switch (chh) {
								case 1:
									viewRestaurants(1);
									break;
								case 2:
									viewRestaurants(2);
								case 3:
									looop=false;
								default:
									break;
							}
						}
						break;
					case 2:
						sc.nextLine();
						String foodName="";
						int foodQnt=0;
						Res_Owner currRes = new Res_Owner();
						try{
							System.out.println("Enter the food name: ");
							foodName = sc.nextLine();
							System.out.println("Enter the quantity");
							foodQnt = sc.nextInt();
						}catch(Exception e){
							System.out.println(e);
						}
						boolean foodFound=false;
						for(Res_Owner res: resList){
							if(res.getItem_name().equals(foodName)&&res.getQuantity()>=foodQnt){
								currRes=res;
								foodFound=true;
								break;
							}
							else{
								foodFound=false;
							}
						}
						if(!found){
							System.out.println("Food Not Found or not Available!!!");
						}
						else{
							System.out.println("GOT YOUR FOOD!!!");
							System.out.println("Are you sure you want to order???(1/0)");
							int sure = sc.nextInt();
							if(sure==1){
								double total_price = foodQnt*currRes.getPrice();
								currRes.setQuantity(currRes.getQuantity()-foodQnt);
								Orders newOrder = new Orders(++Orders.curr_order_id,currCustomer.getId(),currCustomer.getName(),currRes.getRestaurant_name(),currRes.getItem_name(),foodQnt,total_price);
								int o_id=newOrder.getOrder_id();
								orderList.add(newOrder);
								System.out.println("Do you want a reciept? (1/0)");
								int r= sc.nextInt();
								if(r==1){
									for(Orders o: orderList){
										if(o.getOrder_id()==o_id){
											System.out.println(o.toString());
											break;
										}
									}
								}
								System.out.println("Please enter your rating: (1-5)");
								int rat= sc.nextInt();
								
								currRes.setRating((currRes.getRating()+rat)/2); // average of the ratings
								System.out.println("Thank you for using Swimato.. Logging Out!!");
								loop=false;
							}
							else if(sure==0){
								System.out.println("order Cancelled :(");
							}
						}

						break;
					case 3:
						System.out.println("Press enter to Logout");
						sc.nextLine();
						loop=false;
					default:
						break;
				}
			}
			
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
				System.out.println("You are successfully logged in..!\n");
				found=true;
				break;
			}
		}
		if(!found) {
			System.out.println("Invalid Restaurant Name or Password!!!");
			return;
		}
		else {
			System.out.println("-----Add Quantity or Update Pincode-----\n");
			boolean loop=true;
			while(loop){
				System.out.println("1.Add quantity\n2.Update Pincode\n3.Logout");
				int ch=sc.nextInt();
				switch (ch) {
					case 1:
						System.out.println("Current Quantity: "+currRess.getQuantity());
						System.out.println("Please enter the new quantity: ");
						int newQn=sc.nextInt();
						currRess.setQuantity(newQn);
						System.out.println("Current Quantity After Updation: "+currRess.getQuantity());
						break;
					case 2:
						for(int pin:currRess.pincode){
							System.out.println("You can deliver at: "+pin);
						}
						boolean looop = true;
						while(looop){
							System.out.println("1.Add pincode\n2.Remove Pincode\n3.Exit");
							int chh=sc.nextInt();
							switch (chh) {
								case 1:
									System.out.println("Please enter the pincode to be added: ");
									int pin=sc.nextInt();
									currRess.pincode.add(pin);
									System.out.println("Current Pincodes after adding: "+currRess.getPincode());
									break;
								case 2:
									System.out.println("Please enter the pincode to be removed: ");
									int remPin=sc.nextInt();
									currRess.pincode.remove(Integer.valueOf(remPin));
									System.out.println("Current Pincodes after removing: "+currRess.getPincode());
									break;
								case 3:
									System.out.println("Exiting Pincode Updationss");
									looop=false;
								default:
									System.out.println("Invalid Input");
									break;
							}
						}
						break;
					case 3:
						loop=false;
						System.out.println("Press enter to Logout");
						sc.nextLine();sc.nextLine();
						break;
					default:
						System.out.println("Invalid Input");
						break;
				}
			}
			
		}
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
