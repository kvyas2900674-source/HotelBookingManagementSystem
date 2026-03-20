import java.util.HashMap;

/**
 * Hotel Booking Application
 * Use Case 4: Room Search & Availability Check
 * @version 4.0
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" Hotel Booking System v4.0 ");
        System.out.println("===================================\n");

        // Centralized Inventory (same as UC3)
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Room details (domain data)
        HashMap<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Single", 2000);
        priceMap.put("Double", 3500);
        priceMap.put("Suite", 6000);

        HashMap<String, Integer> bedMap = new HashMap<>();
        bedMap.put("Single", 1);
        bedMap.put("Double", 2);
        bedMap.put("Suite", 3);

        System.out.println("Available Rooms:\n");

        // SEARCH LOGIC (READ ONLY)
        for (String type : inventory.keySet()) {

            int available = inventory.get(type);

            // Show only available rooms
            if (available > 0) {
                System.out.println("Room Type: " + type);
                System.out.println("Price: " + priceMap.get(type));
                System.out.println("Beds: " + bedMap.get(type));
                System.out.println("Available Rooms: " + available);
                System.out.println();
            }
        }
    }
}