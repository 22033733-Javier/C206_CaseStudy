import java.util.ArrayList;

public class Bike {

    private static int nextBikeId = 1000; // To generate unique bike IDs
    private int bikeId;
    private String make;
    private String model;
    private int year;
    private String color;
    private String username;

    // Constructor to create a new Bike object
    public Bike(String username, String make, String model, int year, String color) {
        this.bikeId = generateBikeId();
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.username = username;
    }
    
	// Private method to generate a unique bike ID
    private static int generateBikeId() {
        return nextBikeId++;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static void setNextBikeId(int nextBikeId) {
		Bike.nextBikeId = nextBikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	// Getters and Setters
    public int getBikeId() {
        return bikeId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    // Method to display the bike details
    public void displayBikeDetails() {
        System.out.println("Bike ID: " + bikeId);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
    }


    // Override toString method to provide a string representation of the bike object
    @Override
    public String toString() {
        return "Bike ID: " + bikeId + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Colour: " + color;
    }
    
	
	public static void addBike(String username, ArrayList<Bike> bikesList) {
		Helper.line(73, "-");
		System.out.println("------------------------------ Add My Bike ------------------------------");
		Helper.line(73, "-");
		System.out.println();
		
		for (int b = 0; b < bikesList.size(); b++) {
			if (username.equals(bikesList.get(b).getUsername())) {
				String make = Helper.readString("Enter bike make: ");
		        String model = Helper.readString("Enter bike model: ");
		        int year = Helper.readInt("Enter bike year: ");
		        String color = Helper.readString("Enter bike color: ");
		        
		        bikesList.add(new Bike(bikesList.get(b).getUsername() ,make, model, year, color));
		        System.out.println("*** Bike Successfully Added!!");
		        break;
			}
		}
	}
	
	
	public static void deleteBike(ArrayList<Bike> bikesList) {
		int bikeId = Helper.readInt("Enter the bike ID to delete: ");
        boolean found = false;

        for (Bike bike : bikesList) {
            if (bike.getBikeId() == bikeId) {
                bikesList.remove(bike);
                System.out.println("Bike deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bike not found with the given ID!");
        }

	}
	
	
}