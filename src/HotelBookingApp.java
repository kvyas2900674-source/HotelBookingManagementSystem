import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */

// Reservation class
class Reservation {
    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v8.0 ===\n");

        // Booking History (List → ordered)
        List<Reservation> bookingHistory = new ArrayList<>();

        // Simulated confirmed bookings
        bookingHistory.add(new Reservation("R101", "Sanyam", "Single"));
        bookingHistory.add(new Reservation("R102", "Rahul", "Double"));
        bookingHistory.add(new Reservation("R103", "Priya", "Suite"));

        // Display booking history
        System.out.println("Booking History:\n");

        for (Reservation r : bookingHistory) {
            System.out.println("Reservation ID: " + r.reservationId);
            System.out.println("Guest: " + r.guestName);
            System.out.println("Room Type: " + r.roomType);
            System.out.println();
        }

        // Simple Report
        System.out.println("=== Summary Report ===");
        System.out.println("Total Bookings: " + bookingHistory.size());
    }
}