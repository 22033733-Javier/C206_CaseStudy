import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Events {
 
 private String eventName;
 private static int nextEventId = 1;
 private int eventId;
 private String location;
 private String startDate;
 private String endDate;
 private Boolean creator;
 private String username;
 private String startTime;
 private String endTime;
 private boolean over;
 
 public Events(String username, String eventName, String location, String startDate, String endDate, String startTime, String endTime) {
	 	this.eventId = generateEventId();
	 	this.username = username;
        this.eventName = eventName;
        this.location = location; 
        this.startDate = startDate;
        this.endDate = endDate; 
        this.startTime = startTime;
        this.endTime = endTime;
        this.over = false;
    }


 
 private static int generateEventId() {
        return nextEventId++;
    }
 
 public void setEventId(int EventId) {
  this.eventId = EventId;
 }
 public int getEventId() {
  return eventId;
 }

 public static void setNextEventId(int nextEventId) {
  Events.nextEventId = nextEventId;
 }

 public Boolean getCreator() {
  return creator;
 }

 public void setCreator(Boolean creator) {
  this.creator = creator;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }

 public String getStartDate() {
  return startDate;
 }

 public void setStartDate(String startDate) {
  this.startDate = startDate;
 }

 public String getEndDate() {
  return endDate;
 }

 public void setEndDate(String endDate) {
  this.endDate = endDate;
 }

 public String getEventName() {
  return eventName;
 }

 public void setEventName(String eventName) {
  this.eventName = eventName;
 }


 public String getStartTime() {
  return startTime;
 }

 public void setStartTime(String startTime) {
  this.startTime = startTime;
 }

 public String getEndTime() {
  return endTime;
 }

 public void setEndTime(String endTime) {
  this.endTime = endTime;
 }

 
 public boolean isOver() {
	return over;
}



public void setOver(boolean over) {
	this.over = over;
}



@Override
 public String toString() {
     return String.format("%-15s %-25s %-12s %-12s %-12s %-12s",
                          getEventName(), getLocation(), getStartDate(),
                          getEndDate(), getStartTime(), getEndTime());
 }
 
 public void display() {
  System.out.println("Event Name: " + eventName);
  System.out.println("Location: " + location);
  System.out.println("Start Date: " + startDate);
  System.out.println("End Date: " + endDate);
  System.out.println("Start Time: " + startTime);
  System.out.println("End Time: " + endTime);
 }
 
 
 // View Events 
 public static String retrieveAllEvents(ArrayList<Events> events) {
	 String output = "";
	    for (Events event : events) {
	        output += String.format("%s\n", event.toString());
	    }
	    return output;
	}
	
	public static void viewAllEvents(ArrayList<Events> events) {
		Helper.line(40, "-");
		System.out.println("ALL EVENTS");
		Helper.line(40, "-");
		
		String output = String.format("%-15s %-25s %-12s %-12s %-12s %-12s\n", "EVENT NAME", "LOCATION",
				"START DATE", "END DATE","START TIME", "END TIME");
		 output += retrieveAllEvents(events);	
		System.out.println(output);
	}
 
 // Add Events
	public static Events inputEvent() {
		Helper.line(70, "-");
		String userName = Helper.readString("Enter Your UserName > ");
		String eventName = Helper.readString("Enter Event Name > ");
		String location = Helper.readString("Enter Event Location > ");

		String startDate = Helper.readString("Enter Event Start Date (dd-MM-yyyy) > ");
		String endDate = Helper.readString("Enter Event End Date (dd-MM-yyyy) > ");

		String startTime = Helper.readString("Enter Event Start Time (HH:mm) > ");
		String endTime = Helper.readString("Enter Event End Time (HH:mm) > ");

		Events ee= new Events(userName, eventName, location, startDate, endDate, startTime, endTime);
		return ee;
		
	}
	
	public static void addEvent(ArrayList<Events> events, Events ee) {
		Events item;
		for(int i = 0; i < events.size(); i++) {
			item = events.get(i);
			if (item.getEventName().equalsIgnoreCase(ee.getEventName()) )
				return;
		}
		if ((ee.getEventName().isEmpty()) || (ee.getUsername().isEmpty()) ) {
			return;
		}
		events.add(ee);
	}
	
	
	// Delete Event
	public static boolean doDeleteEvent(ArrayList<Events> events, String eName, String uName) {
		boolean eventDeleted = false;

		if (eName.isEmpty() || uName.isEmpty())
			return false;
		
		for (int i = 0; i < events.size(); i++) {
					
			if (eName.equalsIgnoreCase(events.get(i).getEventName()) && uName.equalsIgnoreCase(events.get(i).getUsername()) && events.get(i).isOver() == false ) {
				events.get(i).setOver(true);
				eventDeleted = true;
			}
	}
		return eventDeleted;
	}
	public static void deleteEvent(ArrayList<Events> events) {
		Events.viewAllEvents(events);
		String eName = Helper.readString("Enter Event name to be deleted > ");
		String uName = Helper.readString("Enter Your Username > ");
		Boolean isDeleted = doDeleteEvent(events, eName, uName);
		for  (int i = 0; i < events.size(); i++) {
			if (isDeleted == false) {
				System.out.println("Invalid Event Name");
			} else {
				char confirmation = Helper.readChar("Confirm deletion (y/n) > ");
				if (confirmation == 'y' || confirmation == 'Y') {
					events.remove(i);
					System.out.println("*** Event has been deleted ***"); 
				}
				break;
			}
		}
	}
 
}