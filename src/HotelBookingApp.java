import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 5: Booking Request Queue (FIFO)
 * @version 5.0
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
        System.out.println(" Hotel Booking System v5.0 ");
        System.out.println("===================================\n");

        // Queue for booking requests
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding requests (FIFO order)
        bookingQueue.add(new Reservation("Sanyam", "Single"));
        bookingQueue.add(new Reservation("Rahul", "Double"));
        bookingQueue.add(new Reservation("Priya", "Suite"));

        System.out.println("Booking Requests in Queue:\n");

        // Display queue without removing
        for (Reservation r : bookingQueue) {
            System.out.println("Guest: " + r.guestName + " | Room Type: " + r.roomType);
        }

        System.out.println("\nTotal Requests in Queue: " + bookingQueue.size());
    }
}