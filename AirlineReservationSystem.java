/**
 * The AirlineReservationSystem class is a Java program that allows users to view available flights,
 * reserve seats on a flight, and display current reservations.
 */
import java.util.Scanner;

public class AirlineReservationSystem {
    private static final int MAX_FLIGHTS = 5;
    private static String[] flights = new String[MAX_FLIGHTS];
    private static boolean[] seatsAvailable = new boolean[MAX_FLIGHTS * 10]; // Assume each flight has 10 seats

    public static void main(String[] args) {
        initializeFlights();

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayAvailableFlights();
                    break;
                case 2:
                    reserveSeat();
                    break;
                case 3:
                    displayReservations();
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeFlights() {
        flights[0] = "Flight 101";
        flights[1] = "Flight 202";
        flights[2] = "Flight 303";
        flights[3] = "Flight 404";
        flights[4] = "Flight 505";
    }

    private static void displayMenu() {
        System.out.println("\n===== Airline Reservation System =====");
        System.out.println("1. Display Available Flights");
        System.out.println("2. Reserve a Seat");
        System.out.println("3. Display Reservations");
        System.out.println("4. Exit");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void displayAvailableFlights() {
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < MAX_FLIGHTS; i++) {
            System.out.println((i + 1) + ". " + flights[i]);
        }
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the flight number to reserve a seat: ");
        int flightNumber = scanner.nextInt();

        if (flightNumber < 1 || flightNumber > MAX_FLIGHTS) {
            System.out.println("Invalid flight number. Please try again.");
            return;
        }

        int seatNumber;
        do {
            System.out.print("Enter the seat number (1-10): ");
            seatNumber = scanner.nextInt();
        } while (seatNumber < 1 || seatNumber > 10);

        int seatIndex = (flightNumber - 1) * 10 + (seatNumber - 1);

        if (seatsAvailable[seatIndex]) {
            System.out.println("Seat already reserved. Please choose another seat.");
        } else {
            seatsAvailable[seatIndex] = true;
            System.out.println("Seat reserved successfully.");
        }
    }

    private static void displayReservations() {
        System.out.println("\nCurrent Reservations:");
        for (int i = 0; i < MAX_FLIGHTS; i++) {
            System.out.println("Flight " + flights[i] + ":");
            for (int j = 0; j < 10; j++) {
                int seatIndex = i * 10 + j;
                if (seatsAvailable[seatIndex]) {
                    System.out.println("  Seat " + (j + 1) + " - Reserved");
                } else {
                    System.out.println("  Seat " + (j + 1) + " - Available");
                }
            }
        }
    }
}
