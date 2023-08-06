
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
	
	
}
 