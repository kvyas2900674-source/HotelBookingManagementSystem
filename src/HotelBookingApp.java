import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * @version 10.0
 */

// Reservation class
class Reservation {
    String reservationId;
    String roomType;

    Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v10.0 ===\n");

        // Inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 1);
        inventory.put("Double", 1);

        // Allocated rooms
        Map<String, String> confirmedBookings = new HashMap<>();
        confirmedBookings.put("R101", "Single");
        confirmedBookings.put("R102", "Double");

        // Stack for rollback
        Stack<String> rollbackStack = new Stack<>();

        // Simulate cancellation
        String cancelId = "R102";

        System.out.println("Cancelling Reservation: " + cancelId + "\n");

        if (confirmedBookings.containsKey(cancelId)) {

            String roomType = confirmedBookings.get(cancelId);

            // Push to stack (for rollback tracking)
            rollbackStack.push(cancelId);

            // Restore inventory
            inventory.put(roomType, inventory.get(roomType) + 1);

            // Remove booking
            confirmedBookings.remove(cancelId);

            System.out.println("Cancellation Successful!");
            System.out.println("Room Type Restored: " + roomType);

        } else {
            System.out.println("Cancellation Failed: Reservation not found");
        }

        // Display inventory
        System.out.println("\nUpdated Inventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + ": " + inventory.get(key));
        }

        // Display rollback stack
        System.out.println("\nRollback Stack:");
        System.out.println(rollbackStack);
    }
}