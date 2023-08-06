
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
	

	 
}


