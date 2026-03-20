import java.io.*;
import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 12: Data Persistence & Recovery
 * @version 12.0
 */

// Reservation (Serializable)
class Reservation implements Serializable {
    String reservationId;
    String roomType;

    Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }
}

public class HotelBookingApp {

    static final String FILE_NAME = "hotel_data.ser";

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v12.0 ===\n");

        Map<String, Integer> inventory;
        List<Reservation> bookings;

        // TRY TO LOAD DATA
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            inventory = (Map<String, Integer>) ois.readObject();
            bookings = (List<Reservation>) ois.readObject();

            System.out.println("Data loaded successfully!\n");

        } catch (Exception e) {

            System.out.println("No previous data found. Initializing new system...\n");

            inventory = new HashMap<>();
            inventory.put("Single", 2);
            inventory.put("Double", 1);

            bookings = new ArrayList<>();
        }

        // Simulate new booking
        Reservation r1 = new Reservation("R101", "Single");
        bookings.add(r1);

        inventory.put("Single", inventory.get("Single") - 1);

        System.out.println("New booking added: " + r1.reservationId);

        // SAVE DATA
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(bookings);

            System.out.println("\nData saved successfully!");

        } catch (Exception e) {
            System.out.println("Error saving data!");
        }

        // DISPLAY CURRENT STATE
        System.out.println("\nCurrent Inventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + ": " + inventory.get(key));
        }

        System.out.println("\nBooking Records:");
        for (Reservation r : bookings) {
            System.out.println(r.reservationId + " - " + r.roomType);
        }
    }
}