package HarrysSalon;

import java.util.*;

public class OpenHours {
    private Scanner scanner = new Scanner(System.in);
    private final String[] times = { "10:00-10:30","10:30-11:00","11:00-11:30","11:30-12:00",
            "12:00-12:30","12:30-13:00",
            "PAUSE 13:00-13:30","PAUSE 13:30-14:00",
            "14:00-14:30","14:30-15:00","15:00-15:30","15:30-16:00",
            "16:00-16:30","16:30-17:00","17:00-17:30","17:30-18:00"
    };
    private final String[] slots = times.clone();
    private String service;
    private String name;

    public void menu() {
        boolean exit = false;
        do {
            System.out.println("""
                    
                    Menu options:
                    
                    1. Add a new appointment 'add'
                    2. Remove a appointment 'remove'
                    3. Edit appointment  'edit'
                    4. Additional buys 'buy'
                    5. Show all appointments 'show'
                    0. Exit the program 'exit'
                    """);

            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "1":
                case "add":
                    bookSlot();
                    break;
                case "2":
                case "remove":
                    cancelSlot();
                    break;
                case "3":
                case "edit":
                    editSlot();
                    break;
                case "4":
                case "buy":
                    buyAdditional();
                    break;
                case "5":
                case "show":
                    showSlots();
                    break;
                case "0":
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (!exit);
    }

    // Book a time slot
    public void bookSlot() {
        int choice = getValidChoice();
        if (choice < 0) {
            return;
        }

        do {
            System.out.print("What is the name of the customer?: ");
            name = scanner.nextLine();
        } while (Cuts.hasNumber(name));

        do {
            System.out.printf("""
                    Which type of cut does %s want?
                    Man
                    Woman
                    Beard
                    Hair coloring.\n""", name);
            service = scanner.nextLine();
        } while (Cuts.validateCut(service));

        slots[choice] = name + " (" + service + ")";
        System.out.println("Time booked for " + name);
    }

    // Cancel a time slot
    public void cancelSlot() {
        int choice = getValidChoice();
        if (choice < 0) {
            return;
        }

        slots[choice] = times[choice];
        System.out.println("This time slot is now available again.");
    }

    // Edit a time slot
    public void editSlot() {
        int choice = getValidChoice();
        if (choice < 0) {
            return;
        }

        System.out.println("What do you want to edit?");
        System.out.println("""
                1. Name
                2. Service
                """);
        String edit = scanner.nextLine();

        switch (edit.toLowerCase()) {
            case "1":
            case "name":
                System.out.println("Please enter the new name:");
                name = scanner.nextLine();
                break;
            case "2":
            case "service":
                do {
                    System.out.printf("""
                            Which type of cut would %s like instead?:
                            Man
                            Woman
                            Beard
                            Hair coloring.\n""", name);
                    service = scanner.nextLine();
                } while (Cuts.validateCut(service));
                break;
            default:
                System.out.println("Invalid input, try again.");
                break;
        }

        slots[choice] = name + " (" + service + ")";
        System.out.println(slots[choice]);
    }

    // Add additional things
    public void buyAdditional() {

    }

    // Show all times slots
    public void showSlots() {
        System.out.println("\nTodays times:");
        for (int i = 0; i < slots.length; i++) {
            System.out.println((i + 1) + ") " + slots[i]);
        }
        System.out.println();
    }

    // Does something
    public int getValidChoice() {
        showSlots();
        System.out.println("Choose a time (1-16): ");
        String choice = scanner.nextLine();

        if (Cuts.hasLetter(choice)) {
            System.out.println("Please only use numbers.");
            return -1;
        }
        int intIndex = Integer.parseInt(choice) - 1;


        if (intIndex < 0 || intIndex >= slots.length  || slots[intIndex].startsWith("PAUSE")) {
            System.out.println("Invalid option, try again.");
            return -1;
        }
        if (!slots[intIndex].equals(times[intIndex])) {
            System.out.println("Time slot is already booked.");
            return -1;
        }

        return Integer.parseInt(choice) - 1;
    }
}