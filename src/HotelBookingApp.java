import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 6: Room Allocation & Reservation Confirmation
 * @version 6.0
 */

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

    public static void main(String[] args) {

        System.out.println("===================================");
        System.out.println(" Hotel Booking System v6.0 ");
        System.out.println("===================================\n");

        // Inventory (from UC3)
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);

        // Queue (from UC5)
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Sanyam", "Single"));
        bookingQueue.add(new Reservation("Rahul", "Double"));
        bookingQueue.add(new Reservation("Priya", "Suite"));
        bookingQueue.add(new Reservation("Amit", "Single")); // extra request

        // Allocation tracking
        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
        int roomCounter = 1;

        System.out.println("Processing Bookings:\n");

        // PROCESS QUEUE (FIFO)
        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();
            String type = r.roomType;

            int available = inventory.getOrDefault(type, 0);

            if (available > 0) {

                // Generate unique room ID
                String roomId = type + "-" + roomCounter++;

                // Ensure Set exists
                allocatedRooms.putIfAbsent(type, new HashSet<>());

                // Check uniqueness (safety)
                if (!allocatedRooms.get(type).contains(roomId)) {

                    allocatedRooms.get(type).add(roomId);

                    // Update inventory immediately
                    inventory.put(type, available - 1);

                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + r.guestName);
                    System.out.println("Room Type: " + type);
                    System.out.println("Room ID: " + roomId + "\n");

                }

            } else {
                System.out.println("Booking Failed (No Availability): "
                        + r.guestName + " for " + type + "\n");
            }
        }

        // Final Inventory State
        System.out.println("Final Inventory:\n");
        for (String key : inventory.keySet()) {
            System.out.println(key + " Remaining: " + inventory.get(key));
        }
    }
}