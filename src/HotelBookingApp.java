import java.util.HashMap;

/**
 * Hotel Booking Application
 * Use Case 3: Centralized Room Inventory Management
 * @version 3.0
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" Hotel Booking System v3.0 ");
        System.out.println("===================================\n");

        // Centralized Inventory
        HashMap<String, Integer> inventory = new HashMap<>();

        // Initialize inventory
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Display inventory
        System.out.println("Current Room Availability:\n");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " Rooms Available: " + inventory.get(roomType));
        }
    }
}