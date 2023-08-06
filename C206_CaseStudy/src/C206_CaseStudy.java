import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

public class C206_CaseStudy {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Administrator> adminList = new ArrayList<Administrator>();
		adminList.add(new Administrator("shukor", "adminPw0"));
		adminList.add(new Administrator("emirul69", "adminPw1"));
		
		ArrayList<Users> userList = new ArrayList<Users>();
		userList.add(new Users("Javier", "Javier123@rp.com", "97856412", "20-02-2003",  "Javierrr", "aaaaaaaa"));
		userList.add(new Users("Kamal", "Kamal123@rp.com", "87649523", "25-06-2000",  "Kamal266", "123Abcde"));
		userList.add(new Users("Zi Jian", "ZiJian123@rp.com","94653125", "27-03-2001",  "zijiann", "54321abC"));
		userList.add(new Users("Yu Heng","YuHeng123@rp.com", "87546134", "08-07-1965",  "Yuhengggs", "qwErtyuiop"));
		userList.add(new Users("user","user@rp.com", "877665544", "07-03-2003",  "userrr", "user"));
		

		ArrayList<Groups> groupList = new ArrayList<Groups>();
		groupList.add(new Groups("Javierrr", "Bikers bike for fun", 6, LocalDate.of(2011, 11, 12), 1, "This group is casual for cycling and sightseeing",6));
		groupList.add(new Groups("Kamal226","NXC bikers", 2, LocalDate.of(2023, 1, 12), 1, "This group try hard in getting awards!! Lets go!!",5));
		groupList.add(new Groups("Javierrr", "Valorant characters going for a ride", 5, LocalDate.of(2018, 4, 22), 2, "This group is very questionable",3));
		
		
		ArrayList<Events> eventList = new ArrayList<Events>();
        eventList.add(new Events("Javierrr", "Wild Ride", "Marina Bay Sands", "12/02/2022", "12/03/2022", "10:15" , "12:00", true));
        
		ArrayList<Registrations> registrationList = new ArrayList<Registrations>();
		
		ArrayList<Discussions> discussionList = new ArrayList<Discussions>();
		
		ArrayList<Bike> bikesList = new ArrayList<Bike>();
		bikesList.add(new Bike("Javierrr", "Yamaha", "MT-15", 2020, "Black and Golden"));
		bikesList.add(new Bike("Kamal266", "Ducati" , "V4R", 2019, "Candy Red"));
		
		
		
	// loop
		
		int option = -99;
		signInMenu();
		while(option != 4) {
			
			option = Helper.readInt("\nEnter option or press 4 to exit > ");
			
			if(option == 0) {
				signInMenu();
			}

			else if (option == 1) {
				addUser(userList);
				
			} 
			
			else if (option == 2) {
				String username = userLogin(userList);
				int choice = -9;
				while (choice != 0) {
					choice = Helper.readInt("\nEnter your choice or press 0 to logout > \n");
					
					if(choice == 1) {
						pDetail(userList, groupList, bikesList, discussionList, username, eventList);	
						userMenu();
				 }
					else if (choice == 2) {
						createGroup(userList, groupList, username);
						
						userMenu();
					}
					else if (choice == 3) {
						createEvent(userList, eventList, username);
						
						userMenu();
					}
				}
				signInMenu();
				
			} 
			
			else if (option == 3) {
				
			} 
			
			else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}
			
		}
	}  // End of main 
	
	public static final String shorten(String text, int length) {
	    if (text.length() >= length) {
	      return text.substring(0, length) + "...";
	    }
	    return text;
	  }
	
	public static void signInMenu() {
		Helper.line(80, "-");
		System.out.println("WELCOME TO BIKERS COMMUNITY PORTAL!");
		Helper.line(80, "-");
		System.out.println("LOGIN: ");
		System.out.println("1. Create New Account\n2. User Login\n3. Administrator Login\n4. Exit");
			
		}
	
	public static void userMenu() {
		System.out.println();
		System.out.println("What would you like to do today: \n");
		System.out.println("1. Personal Details\n2. Create New Group\n3. Create New Event\n4. Add Bike\n5. My Resgistered Events\n6. View All Events\n7. View All Discussions\n8. Search For Other Users\n9. Register For Events\n10. Delete Own Account");
	}
	
	public static String userLogin(ArrayList<Users> userList)	{
		Helper.line(92, "=");
		System.out.println("======================================== USER LOGIN ========================================");
		Helper.line(92, "=");
		System.out.println("WELCOME!! Good to see you again!!");
		boolean userfound = false;
		
		String username = Helper.readString("\nUsername: ");
		String password = Helper.readString("Password: ");
		
		while (!userfound) {
			for (Users u : userList ) {
				if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
					userfound = true;
					System.out.println();
					Helper.line(60, "-");
					System.out.println("WELCOME TO THE PORTAL " + u.getName()+ "!");
					Helper.line(60, "-");
					System.out.println("What would you like to do today: \n");
					System.out.println("1. Personal Details\n2. Create New Group\n3. Create New Event\n4. Add Bike\n5. My Resgistered Events\n6. View All Events\n7. View All Discussions\n8. Search For Other Users\n9. Register For Events\n10. Delete Own Account");
					
				}
			}
			
			if (!userfound) {
				System.out.println("Invalid Username or Password!\n");
				System.out.println("Please Re-enter");
				 username = Helper.readString("\nUsername: ");
				 password = Helper.readString("Password: ");
			}
		}	
		return username;
	}
	
	
	// User Functions 
	private static final String E = "[A-Za-z0-9]+@[a-z]+.com";
	private static final String M = "[89][0-9]{7}";
	

	public static void addUser(ArrayList<Users> userList) {
		Helper.line(66, "-");
		System.out.println("------------------------- Create Account -------------------------");
		Helper.line(66, "-");
		System.out.println("Sign up as a member now!!! Fill in your details below: ");
		System.out.println();
	
	
		
		String name = Helper.readString("Enter your name > ");
		name = name.trim();
		String email = Helper.readStringRegExEmail("Enter your email > ", E);
		String dob = Helper.readString("Enter your dob (dd/mm/yyyy) > ");
		String phone = Helper.readStringRegExNumber("Enter mobile number > ", M);
		boolean usernameValid = false;
		boolean passwordValid = false;
		String username = Helper.readString("Enter your username > ");
					
		while(!usernameValid) {
			for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(username)) {
				System.out.println("Username already in use!!! Please enter another username!");
				username = Helper.readString("Please re-enter username > ");
				break;
			}
			
			else {
				usernameValid = true;
			}  
		}
	}
					
		while(!passwordValid) {
			String password = Helper.readString("Enter password > ");
			String password2 = Helper.readString("Enter confirmation password > ");
			if (password.equals(password2) && password.length() == 8) {
				passwordValid = true;
				userList.add(new Users(name, email, dob, phone, username, password));
				System.out.println();
				System.out.println("User successfully added!");
		            }
						
			else if (password.length() < 8) {
				System.out.println("Password length has to be at least 8 characters long!");
			}
						
		    else {
		        System.out.println("Password does not match!");
		       }
		  }
	}


	public static void displayAllUser(ArrayList<Users> userList) {
		for(int i = 0; i < userList.size(); i++) {
			String output = String.format("%-15s %-20s %-12s %-10s %-20s %-20s\n", "Name","Email","DOB","Phone Number","Username","Password");
			output += String.format("%-15s %-20s %-12s %-10s %-20s %-20s\n", userList.get(i).getName(), userList.get(i).getEmail(), userList.get(i).getDob(), userList.get(i).getpNum(), userList.get(i).getUsername(), userList.get(i).getPassword());
			System.out.println(output);
		}
	}		
	
	public static void deleteUser(ArrayList<Users> userList) {
		String userDel = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		
		for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equalsIgnoreCase(userDel)) {
				String output = String.format("%-15s %-20s %-12s %-10s %-20s %-20s\n", userList.get(i).getName(), userList.get(i).getEmail(), userList.get(i).getDob(), userList.get(i).getpNum(), userList.get(i).getUsername(), userList.get(i).getPassword());
				System.out.println(output);
				char isDelete = Helper.readChar("Do you sure you want to delete: > (y/n)");
				if (isDelete == 'y' || isDelete == 'Y') {
					userList.remove(i);
					System.out.println("User successfully removed!");
				}
			}
			else {
				System.out.println("User is safe for now!");
			}
		}
		
	}
	
	public static void searchUser(ArrayList<Users> userList) {
		String userSearch = Helper.readString("Enter username to search > ");
		
		for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equalsIgnoreCase(userSearch)) {
				String output = String.format("%-15s %-20s %-12s %-10s %-20s %-20s\n", userList.get(i).getName(), userList.get(i).getEmail(), userList.get(i).getDob(), userList.get(i).getpNum(), userList.get(i).getUsername(), userList.get(i).getPassword());
				System.out.println(output);
			}
		}
	}

	public static void deleteOwnAcc() {
	
}

	public static void pDetail(ArrayList<Users> userList, ArrayList<Groups> groupList, ArrayList<Bike> bikesList, ArrayList<Discussions> discussionList,String username, ArrayList<Events> eventList) {
		Helper.line(102, "=");
		System.out.println("======================================== PERSONAL INFORMATION ========================================");
		Helper.line(102, "=");
		System.out.println();;
		
		
		System.out.println("General Information");
		Helper.line(60, "-");
		for (Users u : userList ) {
			if(username.equals(u.getUsername())) {
			
				System.out.printf("%4s %-24s %-3s %-5s\n" , "Name: ", u.getName(), "DOB:", u.getDob());
				System.out.printf("%-4s %-24s %-5s %-5s\n", "Email:", u.getEmail(), "Contact Number:", u.getpNum());
				System.out.println();
				}
			}
		
		System.out.println("My Bikes");
		Helper.line(60, "-");
		
		for (Bike b : bikesList) {
			if (username.equals(b.getUsername())) {
				b.displayBikeDetails();
				System.out.println();
			}
		}
		
		Helper.line(121, "-");
		System.out.println("------------------------------------------------------- My Events -------------------------------------------------------");
		Helper.line(121, "-");
		System.out.println();
		System.out.printf("%-5s %-22s %-20s %-18s %-16s %-16s %-16s\n" , "ID", "EVENT NAME", "LOCATION", "START DATE", "END DATE", "START TIME", "END TIME");
		Helper.line(121, "=");
		
		for (Events e : eventList) {
			if (username.equals(e.getUsername())){
				System.out.printf("%-5d %-22s %-20s %-18s %-16s %-16s %-16s\n", e.getEventId(), e.getEventName(), e.getLocation(), e.getStartDate(), e.getEndDate(), e.getStartTime(), e.getEndTime());	
			}
		}
		
		System.out.println();
		System.out.println();
		Helper.line(132, "-");
		System.out.println("------------------------------------------------------------- My Groups ------------------------------------------------------------");
		Helper.line(132, "-");
		System.out.println();
		System.out.printf("%-40s %-12s  %-15s %-30s %-10s\n" , "GROUP NAME", "DISTANCE(KM)", "DATE CREATED", "MOTO", "RECIEVED AWARDS");
		Helper.line(132, "=");
		
		for (Groups g : groupList) {
			if (username.equals(g.getUsername())){
				System.out.printf("%-40s %-12d  %-15s %-30s %-10d\n", g.getgName(), g.getDistance(), g.getdCreated(), shorten(g.getMoto(), 19 ), g.getAwards());
			}
		}
		
	}
	
	public static void createGroup(ArrayList<Users> userList, ArrayList<Groups> groupList, String username) {
		Helper.line(74, "-");
		System.out.println("------------------------------ CREATE GROUP ------------------------------");
		Helper.line(74, "-");
		System.out.println("Create Your Own Group!");
		System.out.println();
		for (int g = 0; g < groupList.size(); g++) {
			if (username.equals(groupList.get(g).getUsername())) {
					String groupN = Helper.readString("Enter Group Name > ");
					groupN = groupN.trim();
					int dist = Helper.readInt("Enter distance in km > ");
					LocalDate dCreated = LocalDate.now();
					String gMoto = Helper.readString("Enter your group moto > ");
					int awards = Helper.readInt("Enter number of awards gotten > ");
					
					groupList.add(new Groups(groupList.get(g).getUsername() ,groupN, dist, dCreated, awards, gMoto));
					groupList.get(g).setCreator(true);
					System.out.println("*** Group Created!!");
					break;
			}
		}
		}
	
	public static void createEvent(ArrayList<Users> userList, ArrayList<Events> eventList, String username) {
		Helper.line(74, "-");
		System.out.println("------------------------------ CREATE EVENT ------------------------------");
		Helper.line(74, "-");
		System.out.println("Create Your Own Event!");
		System.out.println();
		
		for (int e = 0; e < eventList.size(); e++) {
			if (username.equals(eventList.get(e).getUsername())){
				String name = Helper.readString("Enter Event Name > ");
				String location = Helper.readString("Enter Event Location > ");
				Date startDate = Helper.readDate("Enter Event Start Date (dd/mm/yyyy) > ");
				Date endDate = Helper.readDate("Enter Event End Date (dd/mm/yyyy) > ");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    String sDate = dateFormat.format(startDate);
			    String eDate = dateFormat.format(endDate);
				String sTime = Helper.readString("Enter Event Start Time (HH:MM) > ");
				String eTime = Helper.readString("Enter Event End Time (HH:MM) > ");
				
				eventList.add(new Events(name, location, sDate, eDate, sTime, eTime));
				eventList.get(e).setCreator(true);
				System.out.println("*** Event Successfully Created!!");
				break;
			}
		}
	}
	
} // End of class 



