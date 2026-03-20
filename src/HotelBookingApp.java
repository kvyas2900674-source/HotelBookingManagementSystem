import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */

// Custom Exception
class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

// Reservation class
class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class HotelBookingApp {

    // Validation method
    static void validateBooking(Reservation r, Map<String, Integer> inventory)
            throws InvalidBookingException {

        if (!inventory.containsKey(r.roomType)) {
            throw new InvalidBookingException("Invalid Room Type: " + r.roomType);
        }

        if (inventory.get(r.roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for: " + r.roomType);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v9.0 ===\n");

        // Inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 1);
        inventory.put("Double", 0); // No availability
        inventory.put("Suite", 1);

        // Test cases
        Reservation r1 = new Reservation("Sanyam", "Single");
        Reservation r2 = new Reservation("Rahul", "Double"); // should fail
        Reservation r3 = new Reservation("Priya", "Deluxe"); // invalid

        List<Reservation> requests = Arrays.asList(r1, r2, r3);

        for (Reservation r : requests) {
            try {
                validateBooking(r, inventory);
                System.out.println("Booking Valid: " + r.guestName + " (" + r.roomType + ")");
            } catch (InvalidBookingException e) {
                System.out.println("Booking Failed: " + e.getMessage());
            }
        }
    }
}