import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	
	//User & Admin
	private Users u1;
	private Users u2;
	private Administrator a1;
	private Administrator a2;
	
	private ArrayList<Users> users;
	private ArrayList<Administrator> admin;
	

	//Events
	private Events e1;
	private Events e2;
	private ArrayList<Events> events;
	
	
	// Groups 
	private ArrayList<Groups> groupList;
	private Groups tgrp;
	private Groups tgrp2;
	
	// Registration
	private Registrations reg1;
	private Registrations reg2;

	private ArrayList<Registrations> registrationList;
	
	// Discussions
	
	private Discussions discussion1;
	private Discussions discussion2;
	
	private ArrayList<Discussions> discussionList;
	
	// Bikes 
	private ArrayList<Bike> bikeList; 
	
	@Before
	public void setUp() {
		
		//User and Admin
		Users u1 = new Users("Javier","javier@hotmail.com","87654321","10/12/2005","JavierProBiker","12345");
		Users u2 = new Users("Emirul","emirul@hotmail.com","88887777","28/6/2005","Emigenius","password0");
		Administrator a1 = new Administrator("AdminJohn","adminPass");
		Administrator a2 = new Administrator("AdminJane","adminPass");

		users= new ArrayList<Users>();
		admin= new ArrayList<Administrator>();
		
		//Bikes 
		 bikeList = new ArrayList<>(); 
	     Bike bike1 = new Bike("Javierrr", "Yamaha", "MT-15", 2020, "Black and Golden"); 
	     bikeList.add(bike1); 
		
		//Events
		e1 = new Events("Jack", "Wild Ride", "Singapore", "07-08-2023", "08-08-2023", "22:11", "23:11");
		e2 = new Events("Julie", "Night Ride", "Singapore", "09-08-2023", "10-08-2023", "22:11", "23:11");

		events = new ArrayList<Events>();
		
		// Groups
		groupList = new ArrayList<>();
		tgrp = new Groups("tuser", "tgrps", 11, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		tgrp2 = new Groups("tuser2", "tgrps2", 15, LocalDate.now().toString(), "Award 1, Award 2, Award 3", "Test Motto2", true);
		
		// Registrations 
		reg1 = new Registrations("user1", "Event 1", "2023-08-09", "12:34");
		reg2 = new Registrations("user2", "Event 2", "2023-08-10", "14:00");

		registrationList = new ArrayList<Registrations>();
		events = new ArrayList<Events>();
		
		//Discussion 
		discussion1 = new Discussions("user1", "Discussion1", "Discussion1 content", "10-08-2023");
		discussion2 = new Discussions("user2", "Discussion2", "Discussion2 content", "10-08-2023");
		discussionList = new ArrayList<Discussions>();
	}

	//Users and Admin
	@Test
	public void testAddUser() {
		//boundary
		assertNotNull("Check thst user can be added to the arraylist", users);
		Users.addUser(users);
		assertEquals("Check that Users arraylist size is 1", 1, users.size());
		//Normal
		assertNotNull("Check thst user can be added to the arraylist", users);
		Users.addUser(users);
		assertEquals("Check that Users arraylist size is 2", 2, users.size());
		
		//Error
		Users.addUser(users);
		assertEquals("Check that Users arraylist size remains as 2", 2, users.size());
		
	}
	
	@Test
	public void testsearchUser() {
		//boundary
		assertNotNull("Test if there is valid Users arraylist to add to", users);
		Users.addUser(users);
		assertEquals("Check that Users arraylist size is 1", 1, users.size());
		
		//normal
		String expectedResult = String.format("%-15s %-20s %-12s %-20s\n", "Javier","javier@hotmail.com","10/12/2005","JavierProBiker");
		assertEquals(Users.searchUser(users), expectedResult);
		
		//error
		expectedResult = String.format("%-15s %-20s %-12s %-20s\n", "Shahirul","shahirul@hotmail.com","01/10/2005","ShahirulGuy");
		assertNotEquals(Users.searchUser(users), expectedResult);
	}
	
	@Test
	public void testDisplayAllUser() {
		//boundary
		assertNotNull("Test if there is valid Users arraylist to add to", users);
		Users.addUser(users);
		Users.addUser(users);
		assertEquals("Check that Users arraylist size is 1", 2, users.size());
		
		//normal
		String expectedResult = String.format("%-15s %-20s %-12s %-10s %-20s\n", "Javier","javier@hotmail.com","87654321","10/12/2005","JavierProBiker");
		expectedResult += String.format("%-15s %-20s %-12s %-10s %-20s\n", "Emirul","emirul@hotmail.com","88887777","28/6/2005","Emigenius");
		assertEquals("Check that Users arraylist size is 1",Users.displayAllUser(users), expectedResult);
		
		//error
		expectedResult = String.format("%-15s %-20s %-12s %-10s %-20s\n", "Javier","javier@hotmail.com","87654321","10/12/2005","JavierProBiker");
		expectedResult += String.format("%-15s %-20s %-12s %-10s %-20s\n", "Emirul","emirul@hotmail.com","88887777","28/6/2005","Emigenius");
		assertEquals("Check that Users arraylist size is 1",Users.displayAllUser(users), expectedResult);
	}
	
	@Test
	public void testDeleteUser() {
		//boundary
		assertNotNull("Test if there is valid Users arraylist to add to", users);
		Users.addUser(users);
		
		//normal
		boolean isValid = Users.deleteUser(users);
		assertEquals("Check that Users arraylist size is 0", 0, users.size());
		assertTrue(isValid);
		
		//error (test admin password)
		Users.addUser(users);
		isValid = Users.deleteUser(users);
		assertEquals("Check that Users arraylist size is 1", 1, users.size());
		assertFalse(isValid);
		
		//error (test for confirm user ban)
		Users.addUser(users);
		isValid = Users.deleteUser(users);
		assertEquals("Check that Users arraylist size is 2", 2, users.size());
		assertFalse(isValid);
}

	
	
	// Bikes (Shahirul)
	@Test
    public void testAddBikeFail() {
        // Attempt to add a bike (This should fail intentionally)
        Bike bike = new Bike("TestUser", "Test Make", "Test Model", 2022, "Test Color");
        boolean result = bikeList.add(bike);

        // Ensure that the addition fails
        assertFalse("Adding a bike should fail", result);

        // Ensure that the bikeList is still empty
        //assertEquals("Bike list should be empty", 0, bikeList.size());
    }
    
    @Test 
    public void testAddBike() { 
    	Bike bike2 = new Bike("testuser" ,"Ducati" , "V4R", 2019, "Candy Red");
        bikeList.add(bike2); 
        assertEquals(2, bikeList.size()); 
        Bike bike3 = new Bike("testuser", "Honda", "CBR500R", 2021, "Red");
        boolean result = bikeList.add(bike3);
        assertTrue("Adding a bike should succeed", result);
        assertEquals("Bike list size should be 2", 3, bikeList.size());
    } 
    
    
    
    

 
    @Test 
    public void testDeleteBike() { 
    	Bike bike2 = new Bike("testuser" ,"Ducati" , "V4R", 2019, "Candy Red");
        bikeList.remove(bike2); 
        assertEquals(1, bikeList.size()); 
    } 
    
    
    @Test 
    public void testViewBike() { 
        Bike bike1 = new Bike("testuser" ,"Yamaha", "MT-15", 2020, "Black and Golden"); 
        Bike bike2 = new Bike("testuser" ,"Ducati" , "V4R", 2019, "Candy Red"); 
        bikeList.add(bike1); 
        bikeList.add(bike2); 
 
        String output = String.format("%-15s %-25s %-50s %-10s\n", "MAKE", "MODEL", "YEAR", "COLOR"); 
        for (Bike bike : bikeList) { 
            output += String.format("%-15s %-25s %-50s %-10s\n", bike.getMake(), bike.getModel(), 
                    bike.getYear(), bike.getColor()); 
        } 
    }
    
    
    
    @Test
    public void testDeleteNonExistingBike() {
        Bike bike2 = new Bike("testuser" ,"Ducati", "V4R", 2019, "Candy Red");
        boolean result = bikeList.remove(bike2);
        assertFalse("Test deleting a non-existing bike should return false.", result);
        assertEquals("Test that the Bike arraylist size remains unchanged.", 1, bikeList.size());
    }

    


    @Test
    public void testAddBikeAndUpdateSize() {
        assertEquals("Test that the Bike arraylist size is 1 before adding.", 1, bikeList.size());
        
        Bike bike2 = new Bike("testuser", "Ducati", "V4R", 2019, "Candy Red");
        bikeList.add(bike2);
        
        assertEquals("Test that the Bike arraylist size is 2 after adding.", 2, bikeList.size());
    }
    
    @Test
    public void testAddDuplicateBike() {
        // Attempt to add a bike with the same make and model (This should fail intentionally)
        Bike duplicateBike = new Bike("testuser", "Yamaha", "MT-15", 2021, "Silver");
        boolean result = bikeList.add(duplicateBike);
        assertFalse("Adding a duplicate bike should fail", result);
        assertEquals("Bike list size should remain 1", 1, bikeList.size());
    }

	
	
	// Groups (Celine)
	
	@Test
	public void testCreateGroup() {
		
		boolean added = Groups.createGroup(groupList, "testUser", "Test Group", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		assertTrue("Test if a group is added", added);
		assertEquals(1, groupList.size());
		
	}
	
	@Test
	public void testCreateGroupMissingDetail() {
		boolean addedf = Groups.createGroup(groupList, "testUser", "", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		assertFalse("Test if the group cannot be added when there's a missing detail", addedf);
		assertEquals(0, groupList.size());
	}
	
	@Test
	public void testCreateDuplicatedGroup() {
		
		Groups.createGroup(groupList, "testUser", "Test Group", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
	
		boolean added2 = Groups.createGroup(groupList, "testUser", "Test Group", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		assertFalse("Test if the group cannot be added when its duplicated", added2);
		assertEquals(1, groupList.size());
	}

	@Test
	public void testDeleteGroup() {
		
		Groups.createGroup(groupList, "testUser", "Test Group", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		boolean deleted = Groups.deleteGroup(groupList, "testUser", "Test Group");
		assertTrue("Test if the group is deleted", deleted);
		assertEquals(0, groupList.size());
		
	}
	
	@Test 
	public void testDeleteGroupInvalidName() {
		Groups.createGroup(groupList, "testUser", "test gname", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", true);
		boolean deletedf = Groups.deleteGroup(groupList, "testUser", "test");
		assertFalse("Test if there's an error when deleting a group with an invalid group name", deletedf);
		assertEquals(1, groupList.size());
	}
	
	@Test 
	public void testDeleteGroupNotCreator() {
		Groups.createGroup(groupList, "testUser", "test gname", 10, LocalDate.now().toString(), "Award 1, Award 2", "Test Motto", false);
		boolean deletedf2 = Groups.deleteGroup(groupList, "testUser", "test");
		assertFalse("Test if there's an error when deleting a group that is not created by the user", deletedf2);
		assertEquals(1, groupList.size());
	}

	@Test

	public void testViewAllGroups() {
		groupList.add(tgrp);
	    groupList.add(tgrp2);
	    
		String expectedOutput = "";
		expectedOutput += "\033[1;36m\n";
		expectedOutput += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
		expectedOutput += "----------------------------------------------------------- All Available Groups -----------------------------------------------------------\n";
		expectedOutput += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
		expectedOutput += "\033[0m\n";

		expectedOutput += "\033[1;37m";
		expectedOutput += String.format("%-45s %-13s %-20s %-25s %-10s\n", "GROUP NAME", "DISTANCE", "DATE CREATED", "MOTO",
				"CREATED BY");
		expectedOutput += "\033[0m";

		expectedOutput += "--------------------------------------------------------------------------------------------------------------------------------------------\n";

		expectedOutput += "\033[1;36m";
		expectedOutput += String.format(Groups.retrieveAllGroups(groupList));
		expectedOutput += "\033[0m";
		

		assertEquals("Test if the groups are displayed", Groups.viewAllGroups(groupList),expectedOutput);
	}
	
	@Test
	public void testGroupsInList() {
		groupList.add(tgrp);
	    groupList.add(tgrp2);
		assertEquals("Test if the groups added are stored in a list for display", 2, groupList.size());
	}
	
	@Test
	public void testNothingDisplayedWhenListEmpty() {
		String testoutput = "";
		String allgrps = Groups.retrieveAllGroups(groupList);
	    assertEquals("Test that nothing is displayed", testoutput, allgrps);
	}
	
	// Event (Javier)
	
	@Test
	public void testAddEvent() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Event arraylist to add to", events);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		Events.addEvent(events, e1);
		assertEquals("Check that Event arraylist size is 1", 1, events.size());
		assertSame("Check that Event is added", e1, events.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		Events.addEvent(events, e2);
		assertEquals("Check that Event arraylist size is 2", 2, events.size());
		assertSame("Check that Event is added", e2, events.get(1));
	}
	

	@Test
	public void testRetrieveAllEvent() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Event arraylist to retrieve item", events);
		
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		Events.addEvent(events, e1);
		Events.addEvent(events, e2);
		assertEquals("Test that Event arraylist size is 2", 2, events.size());
		
		// Check if its the same items added as the first and second item of the list and display the events arraylist.
		assertSame("Test that Event is added", e1, events.get(0));
		assertSame("Test that Event is added", e2, events.get(1));
		Events.viewAllEvents(events);
		
	}

	@Test
	public void testDoDeleteEvent() {
		
		//error (Wrong Name)
		Boolean isDeleted = Events.doDeleteEvent(events, "Wild Ride", "Jacky");
		assertFalse("Test if Event Wild Ride is deleted (should be false)", isDeleted);		
		
		//normal
		Events.addEvent(events, e1);
		isDeleted = Events.doDeleteEvent(events, "Wild Ride", "Jack");
		assertTrue("Test if Event 'Night Ride' is deleted and marked over (should be true)", isDeleted);
		
		//error
		isDeleted = Events.doDeleteEvent(events, "Dawn Cycle", "Peter");
		assertFalse("Test if non-existing Event 'Dawn Cycle 'is deleted (should be false)?", isDeleted);
	}
	
	// Registration (Kamal)
	
	@Test
	public void testAddRegistration() {
		// Registration list is not null, so that a new registration can be added -
		// boundary
		assertNotNull("Check if there is valid Registrations arraylist to add to", registrationList);

		// Given an empty list, after adding 1 registration, the size of the list is 1 -
		// normal
		// The registration just added is the same as the first registration of the list
		registrationList.add(reg1);
		assertEquals("Test that Registrations arraylist size is 1", 1, registrationList.size());
		assertSame("Test that Registration is added", reg1, registrationList.get(0));

		// Add another registration. Test if the size of the list is 2 - normal
		// The registration just added is the same as the second registration of the
		// list
		registrationList.add(reg2);
		assertEquals("Test that Registrations arraylist size is 2", 2, registrationList.size());
		assertSame("Test that Registration is added", reg2, registrationList.get(1));
	}

	// DONE
	@Test
	public void testRetrieveAllRegistrations() {
		// Test if Registration list is not null but empty - boundary
		assertNotNull("Test if there is valid Registrations arraylist to retrieve items", registrationList);

		// Given an empty list, after adding 2 registrations, test if the size of the
		// list is 2 - normal
		registrationList.add(reg1);
		registrationList.add(reg2);
		assertEquals("Test that Registrations arraylist size is 2", 2, registrationList.size());

		// Check if it's the same registrations added as the first and second items of
		// the list
		assertSame("Test that Registration is added", reg1, registrationList.get(0));
		assertSame("Test that Registration is added", reg2, registrationList.get(1));

		// Check if the arraylist consists of the 2 registrations - normal
		Registrations.displayRegisteredEvents("user1", registrationList, events);
		assertTrue(registrationList.size() == 2);
	}

	
	@Test
	public void testRemoveRegistration() {
		// Registration list is not null, so that a registration can be removed -
		// boundary
		assertNotNull("Check if there is valid Registrations arraylist to remove from", registrationList);

		// Given an empty list, after adding 1 registration, test if the size of the
		// list is 1 - normal
		registrationList.add(reg1);
		assertEquals("Test that Registrations arraylist size is 1", 1, registrationList.size());

		// Removing the registration

		registrationList.remove(0);

		// Check if the registration was removed
		assertEquals(0, registrationList.size());
	}

	
	@Test
	public void testDisplayRegisteredEvents() {
		// Registration list is not null, so that a new registration can be added -
		// boundary
		String username = "user1";
		String expectedView = "";

		expectedView += "----------------------------------------------------------------------------------\n";
		expectedView += "------------------------------ My Registered Events ------------------------------\n";
		expectedView += "----------------------------------------------------------------------------------\n";

		expectedView += String.format("\n%-20s %-18s %-15s\n", "EVENT NAME", "DATE REGISTERED", "TIME REGISTERED");
		for (int r = 0; r < registrationList.size(); r++) {
			if (username.equals(registrationList.get(r).getUsername())) {
				Helper.line(82, "=");
				expectedView += String.format("%-20s %-18s %-15s\n", registrationList.get(r).getEvent(),
						registrationList.get(r).getRegistrationDate(), registrationList.get(r).getRegistrationTime());

			} else {
				expectedView += "\nYou are not registered for any events!";
			}

		}
		
		assertNotNull("Check if there is any display", Registrations.displayRegisteredEvents(username, registrationList, events));

		// Try to add the registration to the list
		try {
			Registrations.displayRegisteredEvents(username, registrationList, events);
		} catch (Exception e) {
			// The registration should not be added to the list, so an exception should be
			// thrown
			assertEquals("Test if the display is the same as the expected display", expectedView, e.getMessage());
		}
	}

	
	@Test
	public void testAddRegistrationWithNonexistentEvent() {
		// Registration list is not null, so that a new registration can be added -
		// boundary
		assertNotNull("Check if there is valid Registrations arraylist to add to", registrationList);

		// Create a registration with an event that does not exist
		Registrations reg = new Registrations("user1", "Event X", "2023-08-09", "12:34");

		// Try to add the registration to the list
		try {
			registrationList.add(reg);

		} catch (Exception e) {
			// The registration should not be added to the list, so an exception should be
			// thrown
			assertEquals("Test that an exception is thrown when adding a registration with a nonexistent event",
					Registrations.INVALID_EVENT_ERROR_MESSAGE, e.getMessage());
		}
	}

	

	@Test
	public void testDisplayRegisteredEventsForNonexistentUser() {
		// Registration list is not null, so that the displayRegisteredEvents() method
		// can be called
		assertNotNull("Check if there is valid Registrations arraylist to retrieve items", registrationList);

		// Try to display the registered events for a nonexistent user
		try {
			Registrations.displayRegisteredEvents("userX", registrationList, events);

		} catch (Exception e) {
			// The registered events should not be displayed for a nonexistent user, so an
			// exception should be
			// thrown
			assertEquals(
					"Test that an exception is thrown when displaying the registered events for a nonexistent user",
					Registrations.INVALID_USERNAME_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testDisplayRegisteredEventsForUserWithEmptyRegistrationList() {
		// Registration list is not null, so that the displayRegisteredEvents() method
		// can be called
		assertNotNull("Check if there is valid Registrations arraylist to retrieve items", registrationList);

		// Try to display the registered events for a user with an empty registration
		// list
		try {
			Registrations.displayRegisteredEvents("user1", registrationList, events);

		} catch (Exception e) {
			// The registered events should not be displayed for a user with an empty
			// registration list, so an exception should be
			// thrown
			assertEquals(
					"Test that an exception is thrown when displaying the registered events for a user with an empty registration list",
					Registrations.NO_REGISTRATIONS_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testDisplayRegisteredEventsForUserWithRegistrationForPastEvent() {
		// Registration list is not null, so that the displayRegisteredEvents() method
		// can be called
		assertNotNull("Check if there is valid Registrations arraylist to retrieve items", registrationList);

		// Create a registration for a valid user, but for an event that has already
		// passed
		registrationList.add(new Registrations("user1", "Event 1", "2023-08-08", "12:34"));

		// Try to display the registered events for a user with a registration for a
		// past event
		try {
			Registrations.displayRegisteredEvents("user1", registrationList, events);

		} catch (Exception e) {
			// The registered events should not be displayed for a user with a registration
			// for a past event, so an exception should be
			// thrown
			assertEquals(
					"Test that an exception is thrown when displaying the registered events for a user with a registration for a past event",
					Registrations.EVENT_ALREADY_PASSED_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testDisplayRegisteredEventsForUserWithRegistrationForFutureEvent() {
		// Registration list is not null, so that the displayRegisteredEvents() method
		// can be called
		assertNotNull("Check if there is valid Registrations arraylist to retrieve items", registrationList);

		// Create a registration for a valid user, but for an event that has not yet
		// happened
		registrationList.add(new Registrations("user1", "Event 1", "2023-08-20", "12:34"));

		// Try to display the registered events for a user with a registration for a
		// future event
		try {
			Registrations.displayRegisteredEvents("user1", registrationList, events);

		} catch (Exception e) {
			// The registered events should not be displayed for a user with a registration
			// for a future event, so an exception should be
			// thrown
			assertEquals(
					"Test that an exception is thrown when displaying the registered events for a user with a registration for a future event",
					Registrations.EVENT_NOT_STARTED_YET_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testRegistrationDoesNotExist() {
		// Registration list is not null, so that the displayRegisteredEvents() method
		// can be called
		assertNotNull("Check if there is valid Registrations arraylist to retrieve items", registrationList);

		// Try to display the registered events for a user with a registration that does
		// not exist
		try {
			Registrations.displayRegisteredEvents("user1", registrationList, events);

		} catch (Exception e) {
			// The registered events should not be displayed for a user with a registration
			// that does not exist, so an exception should be
			// thrown
			assertEquals(
					"Test that an exception is thrown when displaying the registered events for a user with a registration that does not exist",
					Registrations.INVALID_REGISTRATION_ERROR_MESSAGE, e.getMessage());
		}
	}
	
	// Discussions (Damien)
	
	@Test
    public void testAddDiscussion() {
        // Test normal case
        discussionList.add(discussion1);
        assertEquals("Test if discussionList size is 1", 1, discussionList.size());
        assertSame("Test if discussion added is same as 1st item in list", discussion1, discussionList.get(0));

        // Test another discussion
        discussionList.add(discussion2);
        assertEquals("Test if discussionList size is 2", 2, discussionList.size());
        assertSame("Test if discussion added is same as 2nd item in list", discussion2, discussionList.get(1));
        
        //Add a discussion that already exists
        Discussions.addDiscussion(discussionList);
        assertEquals("Test that the discussion arraylist size is unchanged.", 3, discussionList.size());
    }
	
	@Test
	public void testDeleteDiscussion() {
		//Test case 1 - Delete an available discussion
		discussionList.add(discussion1);
		discussionList.remove(0);
		assertEquals("Test that the arraylist is empty", 0, discussionList.size());
		
		//Test case 2 - Delete an unavailable discussion
		discussionList.add(discussion1);
		discussionList.remove(0);
		assertNotNull("Test if there is valid discussions in arraylist", discussionList);

	}
	
	@Test
	public void testViewAllDiscussions() {
		//Test case 1
		//Test if discussions list is not null and empty
		assertNotNull("Test if there is valid discussions arraylist to add to", discussionList);
		//Attempt to retrieve the discussions
		String allDiscussion = Discussions.viewAllDiscussions(discussionList);
		String testOutput = null;
		//Test case 2
		//Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allDiscussion);
	}
	
	
	

} // end of class
