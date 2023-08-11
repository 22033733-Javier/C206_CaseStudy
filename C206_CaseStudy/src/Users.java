import java.util.ArrayList;

public class Users {
	
	private String name;
	private String email;
	private String dob;
	private String pNum;
	private String username;
	private String password;
	private boolean accountCreator;
	
	public Users(String name, String email, String pNum, String dob, String username, String password) {
		this.name = name;
		this.email = email;
		this.pNum = pNum;
		this.dob = dob;
		this.username = username;
		this.password = password;
		accountCreator = true;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email; 
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public boolean isAccountCreator() {
		return accountCreator;
	}

	public void setAccountCreator(boolean accountCreator) {
		this.accountCreator = accountCreator;
	}


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
	
	public static String userLogin(ArrayList<Users> users) {
		boolean userLogin = false;
		
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		
		for(int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				if (users.get(i).getPassword().equals(password)) {
					System.out.println("Successful log in!");
					userLogin = true;
				}
				}
			}
		if (userLogin == false) {
			System.out.println("Error logging in!");
		}
		
		return username;
	}
		
	
		public static void addUser(ArrayList<Users> userList) {
			boolean passValid = false;
			boolean userValid = true;

			String formatter = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
			String dateFormatter = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
			
			String name = Helper.readString("Enter your name > ");
			String email = Helper.readStringRegEx("Enter your email > ", formatter);
			String dob = Helper.readStringRegEx("Enter your d/o/b > (dd/mm/yyyy)", dateFormatter);
			String phone = "";
			phone = Helper.readString("Enter mobile number > ");
			while(phone.length() != 8) {
				System.out.println("Phone number must be 8 digits!");
				phone = Helper.readString("Enter mobile number > ");
			}
			String user = Helper.readString("Enter your username > ");
			String password = Helper.readString("Enter password > ");
			String password2 = Helper.readString("Enter confirmation password > ");
			
			for(int i = 0; i < userList.size(); i++) {
				if (user.equalsIgnoreCase(userList.get(i).getUsername())) {
					userValid = false;
				}
				}
			if (password.equals(password2) && userValid == true) {
				userList.add(new Users(name, email, dob, phone, user, password));
				passValid = true;
				System.out.println("User successfully added!");
			}
			if (passValid == false) {
				System.out.println("Password does not match!");
			}
			if (userValid == false) {
				System.out.println("Username already in use!!!");
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
		
		for(int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(userDel)) {
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
			if (userList.get(i).getUsername().equals(userSearch)) {
				String output = String.format("%-15s %-20s %-12s %-10s %-20s %-20s\n", userList.get(i).getName(), userList.get(i).getEmail(), userList.get(i).getDob(), userList.get(i).getpNum(), userList.get(i).getUsername(), userList.get(i).getPassword());
				System.out.println(output);
			}
		}
	}
	
	public static boolean deleteOwnAcc(ArrayList<Users> users) {
		String user = Helper.readString("Enter your username");
		String pass = Helper.readString("Enter your password");
		boolean isReturned = false;
		for(int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equalsIgnoreCase(user)) {
				if (users.get(i).getPassword().equals(pass)) {
					char isDelete = Helper.readChar("Do you want to delete your account? > (y/n)");
					if (isDelete == 'y' || isDelete == 'Y') {
						String passConfirm = Helper.readString("Enter password to delete account > ");
						if (passConfirm.equals(pass)) {
							for(int b = 0; b < users.size(); b++) {
								if (user.equalsIgnoreCase(users.get(b).getUsername())) {
									users.remove(b);
									System.out.println("User successfully removed!");
									isReturned = true;
								}
							}
						}
					}
				}
			}
			if(isReturned == false) {
				System.out.println("Error! Please check your password/Username");
			}
		}
		return isReturned;
}
	 
}

