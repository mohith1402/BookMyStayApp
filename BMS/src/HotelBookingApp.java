/*
* Use Case 3: Centralized Room Inventory Management
*
* @auther Mohith
* @version 3.0
*
 */

import java.util.HashMap;
import java.util.Map;

abstract class Room {
    private int beds;
    private int size;
    private double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        // Centralized Inventory using HashMap
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);

        System.out.println("Hotel Room Inventory Status\n");

        // Displaying Single Room Info
        SingleRoom single = new SingleRoom();
        System.out.println("Single Room:");
        single.displayInfo();
        System.out.println("Available Rooms: " + inventory.get("Single Room"));

        // Displaying Double Room Info
        System.out.println("\nDouble Room:");
        DoubleRoom doubleRm = new DoubleRoom();
        doubleRm.displayInfo();
        System.out.println("Available Rooms: " + inventory.get("Double Room"));

        // Displaying Suite Room Info
        System.out.println("\nSuite Room:");
        SuiteRoom suite = new SuiteRoom();
        suite.displayInfo();
        System.out.println("Available Rooms: " + inventory.get("Suite Room"));
    }
}