import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 11: Concurrent Booking Simulation
 * @version 11.0
 */

// Shared Booking System
class BookingSystem {

    Map<String, Integer> inventory = new HashMap<>();

    BookingSystem() {
        inventory.put("Single", 2);
    }

    // SYNCHRONIZED METHOD (critical section)
    public synchronized void bookRoom(String guestName, String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {

            System.out.println(guestName + " is booking...");

            // simulate delay
            try { Thread.sleep(100); } catch (Exception e) {}

            inventory.put(roomType, available - 1);

            System.out.println("Booking Confirmed for " + guestName +
                    " | Remaining: " + inventory.get(roomType));

        } else {
            System.out.println("Booking Failed for " + guestName +
                    " (No rooms available)");
        }
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v11.0 ===\n");

        BookingSystem system = new BookingSystem();

        // Multiple threads (simulating users)
        Thread t1 = new Thread(() -> system.bookRoom("Sanyam", "Single"));
        Thread t2 = new Thread(() -> system.bookRoom("Rahul", "Single"));
        Thread t3 = new Thread(() -> system.bookRoom("Priya", "Single"));

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}