import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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
		groupList.add(new Groups("Javierrr", "Bikers bike for fun", 6, "2001-12-11", "Bike King,Bike for Life", "This group is casual for cycling and sightseeing",true));
		groupList.add(new Groups("Kamal226","NXC bikers", 2, "2023-03-23", "Bikers of Heaven", "This group try hard in getting awards!! Lets go!!",true));
		groupList.add(new Groups("Javierrr", "Valorant characters going for a ride", 5, "2018-03-12", "Legendary Bikers", "This group is very questionable",true));
		
		
		ArrayList<Events> eventList = new ArrayList<Events>();
        eventList.add(new Events("Javierrr", "Wild Ride", "Marina Bay Sands", "12-02-2020", "12-02-2023", "1015" , "1200"));
        
		ArrayList<Registrations> registrationList = new ArrayList<Registrations>();
		
		
		ArrayList<Discussions> discussionList = new ArrayList<Discussions>();
		discussionList.add(new Discussions("About my ride", shorten("My ride was amazing", 19), "12/02/2023", "Javierrr"));
		
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
				Users.addUser(userList);
				signInMenu();
				
			} 
			
			else if (option == 2) {
				String username = Users.userLogin(userList);
				int choice = -9;
				boolean tru = false;
				for(int i = 0; i < userList.size(); i++) {
					if (username.equals(userList.get(i).getUsername())) {
						tru = true;
					}
				}
				if(tru == false) {
					break;
				}else {
					userMenu();
				}
		
		
		
				while (choice != 0) {					
					
					choice = Helper.readInt("\nEnter your choice or press 0 to logout > \n");
					
					if(choice == 1) {
						pDetail(userList, groupList, bikesList, username, eventList);	
						userMenu();
				 }
					else if (choice == 2) {
						 
						Groups g = Groups.createGroupInput(username);
						Groups.createGroup(groupList, username, g.getgName(),g.getDistance(),g.getdCreated(),g.getAwards(),g.getMoto(), false);
						userMenu();
					}
					else if (choice == 3) {
						Events ee = Events.inputEvent();
						Events.addEvent(eventList, ee);
						userMenu();
					}
					
					else if (choice == 4) {
						Bike.addBike(username, bikesList);
						userMenu();
					}
					
					else if (choice == 5) {
						
						Discussions.addDiscussion(discussionList);
						userMenu();
					}
					
					else if(choice == 6) {
						Registrations.registerEvent(username, registrationList, eventList);
						userMenu();
					}
					
					else if (choice == 7) {
						
						Registrations.displayRegisteredEvents(username, registrationList, eventList);
						userMenu();
					}
					
					else if (choice == 8) {
						Events.viewAllEvents(eventList);
						userMenu();
						
					}
					
					else if (choice == 9) {
						Discussions.viewAllDiscussions(discussionList);
						userMenu();
						
					}
					
					else if (choice == 10) {
						Groups.viewAllGroups(groupList);
						userMenu();
					}
					
					else if (choice == 11) {
						Users.deleteUser(userList);
						userMenu();
						
					}
					
					else if (choice == 12) {
						Discussions.deleteDiscussion(discussionList, username); 
						userMenu();
						
					}
					
					else if (choice == 13) {
						Bike.deleteBike(bikesList);
						userMenu();
					}
					
					else if (choice == 14) {
						Groups.deleteGroup(groupList, username, Groups.deleteGroupInput(groupList, username)); 
						userMenu();
					}
					
					else if (choice == 15) {
						Registrations.removeRegistration(username, registrationList);
						userMenu();
					}
					
					else if (choice == 16) {
						Events.deleteEvent(eventList); 
						userMenu();
						
					}
					else if (choice == 17) {
						Users.searchUser(userList);
						userMenu();
					}
				}
				signInMenu();
				
			} 
			
			else if (option == 3) {
				
					if(Administrator.adminLogin(adminList) == true) {
						int userOption = -99;
						while(userOption != 3) {
							adminMenu();
							userOption = Helper.readInt("\nEnter Option> ");
						//check for  options
							if(userOption == 1) {
								Users.displayAllUser(userList);
							}
							else if(userOption == 2) {
								String username = Helper.readString("Enter username to delete > ");
								Users.deleteUser(userList);
							}
							else {
								System.out.println("Invalid Option!");
							}
						
						}
						System.out.println();
						signInMenu();
				}
			} 
			
			else if (option == 4) {
				System.out.println("Bye Bye");
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
		System.out.println("1. Personal Details\n2. Create New Group\n3. Create New Event\n4. Add Bike\n5. Create Discussion\n6. Register For Events\n7. My Registered Events\n8. View All Events\n9. View All Discussions\n10. View All Groups\n11. Delete Account\n12. Delete Own Discussion\n13. Delete My Bike\n14. Delete My Group\n15. Remove Registration\n16. Delete Event\n17. Search for Users");
	}
	
	public static void adminMenu() {
		Helper.line(50, "=");
		System.out.println("ADMIN MENU");
		Helper.line(50, "=");
		System.out.println("1. Display All Users\n2. Delete a user");
	}
		
// Display function
	
	public static void pDetail(ArrayList<Users> userList, ArrayList<Groups> groupList, ArrayList<Bike> bikesList ,String username, ArrayList<Events> eventList) {
		Helper.line(102, "=");
		System.out.println("======================================== PERSONAL INFORMATION ========================================");
		Helper.line(102, "=");
		System.out.println();;
		

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
		
		for (int e= 0; e < eventList.size(); e++) {
			if (username.equals(eventList.get(e).getUsername())){
				System.out.printf("%-5d %-22s %-20s %-18s %-16s %-16s %-16s\n", eventList.get(e).getEventId(), eventList.get(e).getEventName(), eventList.get(e).getLocation(), eventList.get(e).getStartDate(), eventList.get(e).getEndDate(), eventList.get(e).getStartTime(), eventList.get(e).getEndTime());	
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.print("\033[1;36m"); 
		Helper.line(132, "-");
		System.out.println("------------------------------------------------------------- My Groups ------------------------------------------------------------");
		Helper.line(132, "-");
		System.out.print("\033[0m"); 
		
		System.out.println();
		System.out.print("\033[1m"); 
		System.out.println("JOINED GROUPS");
		Helper.line(40,"-");
		System.out.print("\033[0m");
		
		for (Groups g : groupList) {
			if (username.equals(g.getUsername())){
				
				System.out.println("Group Name: "+shorten(g.getgName(),19));
				System.out.println("Distance: "+g.getDistance());
				System.out.println("Date Created: "+g.getdCreated());
				System.out.println("Group Motto: "+shorten(g.getMoto(), 19));
				System.out.println();

				Helper.line(30, "-");
				System.out.println("       Awards       ");
				Helper.line(30, "-");
				String[] awardsArray = g.getAwards().split(",");
				for (String award : awardsArray) {
				    System.out.println("Award: " + shorten(award.trim(),19)); 
				}
				
				System.out.println();
				System.out.print("\033[1;36m"); 
				Helper.line(121, "=");
				System.out.print("\033[0m"); 

				System.out.println();
			}
		}
		
	}
	
	
	
	
	
	
	


	
	
	
	
	

	

	
} // End of class 



