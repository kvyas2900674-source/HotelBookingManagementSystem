/**
 * Hotel Booking Application
 * Use Case 2: Room Modeling with Static Availability
 * @version 2.0
 */

// Abstract Room class
abstract class Room {
    String type;
    int price;
    int beds;

    Room(String type, int price, int beds) {
        this.type = type;
        this.price = price;
        this.beds = beds;
    }

    void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: " + price);
        System.out.println("Beds: " + beds);
    }
}

// Concrete Room Types
class SingleRoom extends Room {
    SingleRoom() {
        super("Single", 2000, 1);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double", 3500, 2);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite", 6000, 3);
    }
}

// Main Application Class
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" Hotel Booking System v2.0 ");
        System.out.println("===================================\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        single.displayDetails();
        System.out.println("Available Rooms: " + singleAvailable + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailable + "\n");

        suite.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
    }
}