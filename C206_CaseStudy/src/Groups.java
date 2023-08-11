import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Groups {
	
	private String gName;
	private int distance;
	private String dCreated;
	private String awards;
	private String moto;
	private String username;
	private boolean creator; 

	
	public Groups(String username, String gName, int distance, String dCreated, String awards, String moto, boolean creator) {
		this.gName = gName;
		this.distance = distance;
		this.dCreated = dCreated;
		this.awards = awards;
		this.moto = moto;
		this.username = username;
		this.creator = creator;
	}
	
	public Groups(String username, String gName, int distance, String dCreated, String awards, String moto) {
		this.gName = gName;
		this.distance = distance;
		this.dCreated = dCreated;
		this.awards = awards;
		this.moto = moto;
		this.username = username;
		creator = false;
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

	public String getdCreated() {
		return dCreated;
	}

	public void setdCreated(String dCreated) {
		this.dCreated = dCreated;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}
	
	public static final String shorten(String text, int length) {
	    if (text.length() >= length) {
	      return text.substring(0, length) + "...";
	    }
	    return text;
	  }
	
	public static Groups createGroupInput(String username) {
		System.out.print("\033[1;32m"); 
		Helper.line(74, "-");
		System.out.println("------------------------------ CREATE GROUP ------------------------------");
		Helper.line(74, "-");
		System.out.print("\033[0m"); 

		System.out.print("\033[1;36m"); 
		System.out.println("Create Your Own Group!");
		System.out.println();
		System.out.print("\033[0m"); 

		
		String awardInput = "";
		LocalDate dNow = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dCreated = dNow.format(dateFormatter);
		
		String gName = Helper.readString("Enter Group Name > ");
		int distance = Helper.readInt("Enter Distance > ");
		String moto = Helper.readString("Enter Group Motto > ");
		boolean awardNoIsValid = false;
		int awardNo = 0;
		while(!awardNoIsValid) {
            awardNo = Helper.readInt("Enter no of award received > ");
            if(awardNo >= 0) {
              awardNoIsValid = true;
            }else {
              System.out.println("*** Please enter valid no of award ***");
            }
		}
		ArrayList<String> awardList = new ArrayList<>();
		if(awardNoIsValid) {
			for(int i = 1;i <= awardNo;i++) {
				String award =  Helper.readString("Enter Award "+i+" Name > ");
				awardList.add(award);
			}
		}
		for(String a : awardList) {
			awardInput += a+",";
		}
		
		Groups grps= new Groups(username, gName, distance, dCreated, awardInput, moto);
		return grps;
		
	}

	
	public static boolean createGroup(ArrayList<Groups> groupList, String username, String groupN, int dist, String dCreated, String awardListInput, String gMoto, boolean creator) {
		boolean groupNValid = true;
		boolean distValid = false;
		boolean gMotoValid = false;
		boolean awardValid = true;
		boolean created = false;
		
		if(!groupN.isBlank()) {
			groupN = groupN.trim();
			boolean grpNexist = false;
			for (Groups g : groupList) {
				if(groupN.equalsIgnoreCase(g.getgName())) {
					System.out.println("*** Group Name already exist! ***");
					grpNexist = true;
					break;
				}
			}
			
			groupNValid = !grpNexist;
		}else {
			groupNValid = false;
		}
		
		
		if(dist >= 0) {
			distValid = true;
		}
		
		
		if(!gMoto.isBlank()) {
			gMoto = gMoto.trim();
			gMotoValid = true;
		}
		
		String[] awardsArray = awardListInput.split(",");
		for (String award : awardsArray) {
		    if (award.isBlank()) {
		        awardValid = false; 
		        break; 
		    }
		}
		
		if(gMotoValid && groupNValid && distValid && awardValid) {
			groupList.add(new Groups(username ,groupN, dist, dCreated, awardListInput, gMoto, creator));
			System.out.println("*** Group successfully created ***");
			created = true;
			
			for (Groups g : groupList) {
				g.setCreator(true);
			}
	
			
		} 
		
		else {
			created = false;
			System.out.print("\033[1;31m"); 
			System.out.println("*** Error ***");
			System.out.print("\033[0m");
		}
		return created;
	}
	
	public static String deleteGroupInput(ArrayList<Groups> groupList, String username) {
		System.out.print("\033[1;36m"); 
		Helper.line(121, "-");
		System.out.println("---------------------------------------------------- DELETE MY GROUP ----------------------------------------------------");
		Helper.line(121, "-");
		System.out.print("\033[0m");

		System.out.println();
		System.out.println("Groups Available To Delete:");
		System.out.println();
		System.out.printf("%-40s %-15s %-15s %-10s\n", "GROUP NAME", "DISTANCE(KM)", "DATE CREATED", "MOTO");
		Helper.line(121, "-");


		for (Groups g : groupList) {
			if (username.equals(g.getUsername()) && g.creator == true) {
				System.out.print("\033[1;35m"); 
				System.out.printf("%-40s %-15d %-15s %-10s\n", g.getgName(), g.getDistance(), g.getdCreated(), shorten(g.getMoto(), 19));
				System.out.print("\033[0m"); 
			}
			
		}
		
		System.out.println();
		String groupName = Helper.readString("Enter Group Name > ");
		
		return groupName;
	
	}
	
	
	public static boolean deleteGroup(ArrayList<Groups> groupList, String username, String groupName) {
		boolean delete = false;
		if (!groupName.isBlank()) {
			groupName = groupName.trim();
			for (Groups g : groupList) {
				if(groupName.equalsIgnoreCase(g.getgName()) && g.isCreator() == true) {
						groupList.remove(g);
						delete = true; 
						System.out.println("*** Group Deleted ***");
						break;
					}
					
				else if (groupName.equalsIgnoreCase(g.getgName()) &&g.isCreator() == false){
						System.out.println("*** You are not the creator of this group ***");
						break;
					}
				
				else {
					System.out.println("*** Group Not deleted ***");
				}
				}	
		}
		else {
			System.out.print("\033[1;31m"); 
			System.out.println("Please enter a valid group name!");
			System.out.print("\033[0m"); 

		}
	
		return delete;
	}
	
	
	public static String retrieveAllGroups(ArrayList<Groups> groupList) {
		String output = "";
		
		if (!groupList.isEmpty()) {
			for (Groups g : groupList) {	
				output += String.format("%-45s %-13d %-20s %-25s %-10s\n", g.getgName(), g.getDistance(), g.getdCreated(), shorten(g.getMoto(), 19), g.getUsername());
				
			}
			
		}
		return output;
		
	}
	
	public static String viewAllGroups(ArrayList<Groups> groupList) { 
		String output = "";
		output += "\033[1;36m\n"; 
		output += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
		output += "----------------------------------------------------------- All Available Groups -----------------------------------------------------------\n";
		output += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
		output += "\033[0m\n"; 

		output += "\033[1;37m"; 
		output += String.format("%-45s %-13s %-20s %-25s %-10s\n", "GROUP NAME", "DISTANCE", "DATE CREATED", "MOTO", "CREATED BY");
		output += "\033[0m";

		output += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
	 
		output += "\033[1;36m"; 
		output += String.format(retrieveAllGroups(groupList));
		output += "\033[0m"; 
		
		System.out.println(output);
		
		return output;
	} 
	
	
	
	
	
} // End of class 
	
	