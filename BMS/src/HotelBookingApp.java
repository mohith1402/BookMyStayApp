/*
* Use Case 7: Add-On Service Selection
*
* @auther Mohith
* @version 7.0
*
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}


class AddOnServiceManager {
    private Map<String, List<Service>> selections = new HashMap<>();


    public void addService(String reservationId, Service service) {
        selections.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        List<Service> services = selections.get(reservationId);
        double total = 0.0;
        if (services != null) {
            for (Service s : services) {
                total += s.getPrice();
            }
        }
        return total;
    }

    public void displaySelectedServices(String reservationId) {
        List<Service> services = selections.get(reservationId);
        if (services != null) {
            for (Service s : services) {
                System.out.println("- " + s.getName() + " (₹" + s.getPrice() + ")");
            }
            System.out.println("Total Add-On Cost: ₹" + calculateTotalServiceCost(reservationId));
        }
    }
}


public class HotelBookingApp {

    public static void main(String[] args) {
        // Display application header
        System.out.println("Add-On Service Selection");
        System.out.println("---------------------------");

        AddOnServiceManager manager = new AddOnServiceManager();

        // Define available services
        Service wifi = new Service("High-Speed WiFi", 15.0);
        Service breakfast = new Service("Buffet Breakfast", 25.0);

        // Simulation for a specific Reservation ID
        String resId = "Single-1";
        System.out.println("Guest Reservation ID: " + resId);

        // Guest selects services
        manager.addService(resId, wifi);
        manager.addService(resId, breakfast);

        // Display results
        System.out.println("Selected Add-Ons:");
        manager.displaySelectedServices(resId);
        System.out.println("---------------------------");
    }
}