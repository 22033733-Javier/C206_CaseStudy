
import java.time.LocalDateTime;

public class Registrations {

	private String event;
	private LocalDateTime registrationDateTime;
	private int eventRegisteredID;

	public Registrations(String event) {

		this.event = event;

	}

	public String getEvent() {
		return event;
	}

	public LocalDateTime getRegistrationDateTime() {
		return registrationDateTime;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void display() {
		System.out.println("Events Registered: " + event);
	}
	
	
	public int getEventRegisteredID() {
		return eventRegisteredID;
		
	}
	
	
	
}
