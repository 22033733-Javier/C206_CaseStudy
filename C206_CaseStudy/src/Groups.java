import java.time.LocalDate;


public class Groups {
	
	private String gName;
	private int distance;
	private LocalDate dCreated;
	private int awards;
	private String moto;
	private String cDate;
	private String username;
	private boolean creator; 
	private int members;
	
	public Groups(String username, String gName, int distance, LocalDate dCreated, int awards, String moto) {
		this.gName = gName;
		this.distance = distance;
		this.dCreated = dCreated;
		this.awards = awards;
		this.moto = moto;
		this.username = username;
		creator = false;
		members = 0;
	}
	
	public Groups(String username, String gName, int distance, LocalDate dCreated, int awards, String moto, int members) {
		this.gName = gName;
		this.distance = distance;
		this.dCreated = dCreated;
		this.awards = awards;
		this.moto = moto;
		this.username = username;
		creator = false;
		this.members = members;
	}
	

	public int getMembers() {
		return members;
	}


	public void setMembers(int members) {
		this.members = members;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public boolean isCreator() {
		return creator;
	}

	public void setCreator(boolean creator) {
		this.creator = creator;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LocalDate getdCreated() {
		return dCreated;
	}

	public void setdCreated(LocalDate dCreated) {
		this.dCreated = dCreated;
	}

	public int getAwards() {
		return awards;
	}

	public void setAwards(int awards) {
		this.awards = awards;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	
	
	
}
