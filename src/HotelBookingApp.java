import java.util.*;

/**
 * Hotel Booking Application
 * Use Case 7: Add-On Service Selection
 * @version 7.0
 */

// Reservation
class Reservation {
    String reservationId;
    String guestName;

    Reservation(String reservationId, String guestName) {
        this.reservationId = reservationId;
        this.guestName = guestName;
    }
}

// Service class
class AddOnService {
    String name;
    int cost;

    AddOnService(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Hotel Booking System v7.0 ===\n");

        // Sample reservation
        Reservation r1 = new Reservation("R101", "Sanyam");

        // Services
        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1000);

        // Map reservation → services
        Map<String, List<AddOnService>> serviceMap = new HashMap<>();

        // Assign services
        List<AddOnService> services = new ArrayList<>();
        services.add(wifi);
        services.add(breakfast);

        serviceMap.put(r1.reservationId, services);

        // Display
        int totalCost = 0;

        System.out.println("Services for Reservation: " + r1.reservationId);

        for (AddOnService s : serviceMap.get(r1.reservationId)) {
            System.out.println(s.name + " - ₹" + s.cost);
            totalCost += s.cost;
        }

        System.out.println("Total Add-On Cost: ₹" + totalCost);
    }
}