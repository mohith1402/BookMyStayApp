/*
* Use Case 2: Basic Room Types & Static Availability
*
* @auther Mohith
* @version 2.0
*
 */

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
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        SingleRoom single = new SingleRoom();
        System.out.println("Single Room:");
        single.displayInfo();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\nDouble Room:");
        DoubleRoom doubleRm = new DoubleRoom();
        doubleRm.displayInfo();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\nSuite Room:");
        SuiteRoom suite = new SuiteRoom();
        suite.displayInfo();
        System.out.println("Available: " + suiteAvailable);
    }
}