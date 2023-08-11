import java.util.ArrayList;

public class Administrator {
	
	private String username;
	private String password;
	private String email;
	private String oNum;
	
	
	public Administrator(String username, String password) {
		this.username = username;
		this.password = password;
		email = "administrator@bikersPortal.com";
		oNum = "81234568";
	}

	public String getEmail() {
		return email;
	}

	public String getoNum() {
		return oNum;
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
	
	public static boolean adminLogin(ArrayList <Administrator> adminList) {
		boolean aLogin = false;
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		
		for(int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getUsername().equals(username)) {
				if (adminList.get(i).getPassword().equals(password)) {
					aLogin = true;
					System.out.println("Successful log in!");
				}
				else {
					System.out.println("Error!");
				}
			}
		}
		return aLogin;
	}
}
 