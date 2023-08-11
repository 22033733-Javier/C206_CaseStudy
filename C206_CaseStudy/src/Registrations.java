
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Registrations {

  public static final Object INVALID_USERNAME_ERROR_MESSAGE = null;
  public static final String INVALID_EVENT_ERROR_MESSAGE = "Invalid event";
  public static final Object INVALID_REGISTRATION_ERROR_MESSAGE = "Event already registered";
  public static final Object NO_REGISTRATIONS_ERROR_MESSAGE = null;
  public static final Object EVENT_ALREADY_PASSED_ERROR_MESSAGE = null;
  public static final Object EVENT_NOT_STARTED_YET_ERROR_MESSAGE = null;
  private String username;
  private String registrationDate;
  private String registrationTime;
  private String event;

  public Registrations(String username, String event, String registrationDate, String registrationTime) {
    this.username = username;
    this.registrationDate = registrationDate;
    this.registrationTime = registrationTime;
    this.event = event;

  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(String registrationDate) {
    this.registrationDate = registrationDate;
  }

  public String getRegistrationTime() {
    return registrationTime;
  }

  public void setRegistrationTime(String registrationTime) {
    this.registrationTime = registrationTime;
  }

  public static void removeRegistration(String username, ArrayList<Registrations> registrationList) {

    ArrayList<Integer> removeList = new ArrayList<>();

    System.out.println();
    System.out.printf(" %-3s %-20s %-18s %-15s\n", "ID", "EVENT NAME", "DATE REGISTERED", "TIME REGISTERED");
    for (int r = 0; r < registrationList.size(); r++) {
      if (username.equals(registrationList.get(r).getUsername())) {
        Helper.line(82, "=");
        System.out.printf("%-3d %-20s %-18s %-15s\n", removeList.size() + 1, registrationList.get(r).getEvent(),
            registrationList.get(r).getRegistrationDate(), registrationList.get(r).getRegistrationTime());
        removeList.add(r);

      }
    }
    System.out.println();
    int rEvent = Helper.readInt("Enter Event ID to unregister > ");

    if (rEvent > 0 && rEvent <= removeList.size()) {
      String unR = Helper.readString("Unregister? (Y/N) > ");
      if (unR.equalsIgnoreCase("y")) {
        int removed = removeList.get(rEvent - 1);
        registrationList.remove(removed);
        System.out.println("Unregistered successfully!");
      }

      else {
        System.out.println("Failed to unregister from event");
      }
    }

    else {
      System.out.println("Please enter valid Event ID");
    }
    removeList.clear();

    for (int r = 0; r < registrationList.size(); r++) {
      if (username.equals(registrationList.get(r).getUsername())) {
        Helper.line(82, "=");
        System.out.printf("%-3d %-20s %-18s %-15s\n", removeList.size() + 1, registrationList.get(r).getEvent(),
            registrationList.get(r).getRegistrationDate(), registrationList.get(r).getRegistrationTime());
        removeList.add(r);

      }
    }

  }

  public static String displayRegisteredEvents(String username, ArrayList<Registrations> registrationList,
      ArrayList<Events> eventList) {

    String output = "";
    boolean listEmpty = false;

    for (int r = 0; r < registrationList.size(); r++) {
      if (username.equals(registrationList.get(r).getUsername())) {
        listEmpty = false;
      } else {
        output = "\nYou are not registered for any events!";
        listEmpty = true;
      }
    }


if (!listEmpty) {
      Helper.line(82, "-");
      output += "----------------------------------------------------------------------------------\n";
      output += "------------------------------ My Registered Events ------------------------------\n";
      output += "----------------------------------------------------------------------------------\n";

      output += String.format("\n%-20s %-18s %-15s\n", "EVENT NAME", "DATE REGISTERED", "TIME REGISTERED");
      for (int r = 0; r < registrationList.size(); r++) {
        if (username.equals(registrationList.get(r).getUsername())) {

          Helper.line(82, "=");
          output += String.format("%-20s %-18s %-15s\n", registrationList.get(r).getEvent(),
              registrationList.get(r).getRegistrationDate(),
              registrationList.get(r).getRegistrationTime());

        }
      }
      System.out.println(output);
    }
    return output;
  }

  public static String registerEvent(String username, ArrayList<Registrations> registrationList,
      ArrayList<Events> eventList) {

    boolean eventValid = false;
    boolean alreadyRegistered = false;
    String errorMsg = "";

    System.out.println();
    System.out.println("Which event do you want to register today? ");
    System.out.println();
    Helper.line(120, "-");
    System.out.println(
        "------------------------------ AVAILABLE EVENTS FOR REGISTRATION ------------------------------");
    Helper.line(120, "-");

    for (Events event : eventList) {
      System.out.printf(
          "Event ID: %-5d | Event Name: %-30s | Location: %-20s | Start Date: %-15s | Start Time: %-10s%n",
          event.getEventId(), event.getEventName(), event.getLocation(), event.getStartDate(),
          event.getStartTime());

    }

    System.out.println();
    int eventId = Helper.readInt("Enter Event ID > ");

    for (int e = 0; e < eventList.size(); e++) {
      if (eventId == eventList.get(e).getEventId()) {
        eventValid = true;
        for (Registrations registration : registrationList) {
          if (registration.getEvent().equals(eventList.get(e).getEventName())
              && registration.getUsername().equals(username)) {
            alreadyRegistered = true;
            break;
          }
        }

        if (!alreadyRegistered) {
          LocalDate dNow = LocalDate.now();
          LocalTime tNow = LocalTime.now();
          DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
          String dCreated = dNow.format(dateFormatter);
          String tCreated = tNow.format(timeFormatter);

          registrationList
              .add(new Registrations(username, eventList.get(e).getEventName(), dCreated, tCreated));

          System.out.println();
          System.out.println("*** Registered Successfully!");
          System.out.println();
          System.out.println("The Event You Have Registered For");
          Helper.line(60, "-");
          eventList.get(e).display();
          System.out.println();
        } else {
          System.out.println("You are already registered for this event.");
        }
      }
    }

    if (!eventValid) {
      errorMsg = "Invalid event";
    } else if (alreadyRegistered) {
      errorMsg = "Event already registered";
    } else {
      errorMsg = "Event registered";
    }

    return errorMsg;
  }

}