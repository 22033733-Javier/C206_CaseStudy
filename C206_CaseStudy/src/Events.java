
import java.time.LocalDate;
import java.util.Date;
public class Events {
	private String eventName;
	private int EventId;
	private String location;
	private String startDate;
	private String endDate;
	private Boolean creator;
	private String username;
	private String startTime;
	private String endTime;
	
	
	public Events(String username, String eventName, String location, String startDate, String endDate, String startTime, String endTime, boolean creator) {
		EventId = EventId++;
		this.username = username;
        this.eventName = eventName;
        this.location = location; 
        this.startDate = startDate;
        this.endDate = endDate; 
        this.startTime = startTime;
        this.endTime = endTime;
        creator = false;
    }
	public Events(String eventName, String location, String startDate, String endDate, String startTime, String endTime) {
		EventId = EventId++;
        this.eventName = eventName;
        this.location = location; 
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        creator = false;
    }

	public int getEventId() {
		return EventId;
	}

	public void setEventId(int eventId) {
		EventId = eventId;
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

	public void display() {
		System.out.println("Event Name: " + eventName);
		System.out.println("Location: " + location);
		System.out.println("Start Time: " + startDate);
		System.out.println("End Time: " + endDate);
	}
	
}
