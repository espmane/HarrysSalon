package HarrysSalon;

import HarrysSalon.typeofcuts.TypeOfCutsSelect;
import HarrysSalon.typeofcuts.TypeOfCuts;
import HarrysSalon.usercontrol.User;

import java.util.Scanner;

public class MainMenu {
    private final String[] times = {"10:00-10:30", "10:30-11:00", "11:00-11:30", "11:30-12:00",
            "12:00-12:30", "12:30-13:00",
            "BREAK", "BREAK",
            "14:00-14:30", "14:30-15:00", "15:00-15:30", "15:30-16:00",
            "16:00-16:30", "16:30-17:00", "17:00-17:30", "17:30-18:00"
    };
    private String[] slots = times.clone();
    public static int[] priceThing = new int[16];
    private Scanner scanner = new Scanner(System.in);

    public String[] getSlots() {
        return slots;
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Valid options:
                    1. Add a new appointment 'add'
                    2. Remove an appointment 'remove'
                    3. Show all appointments  'show'
                    4. Edit an appointment 'edit'
                    5. Additional purchases 'buy'
                    0. Go back 'back'
                    """);

            String input = scanner.nextLine();
            User u = new User();

            switch (input.toLowerCase()) {
                case "1":
                case "add":
                    bookSlot();
                    menu();
                    break;
                case "2":
                case "remove":
                    cancelSlot();
                    menu();
                    break;
                case "3":
                case "show":
                    showSlots();
                    menu();
                    break;
                case "4":
                case "edit":
                    editTime();
                    menu();
                    break;
                case "5":
                case "buy":
                    addAdditionalChoose();
                    menu();
                    break;
                case "0":
                case "back":
                    u.userManager();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
            System.out.println();
        }
    }

    // Book en tid
    public void bookSlot() {
        showSlots();
        System.out.print("\nChoose a time between 1-" + slots.length + ": ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return;
        }

        if (choice < 0 || choice >= slots.length) {
            System.out.println("Invalid choice.");
            return;
        }

        if (!slots[choice].contains("-")) {
            System.out.println("This time is already in use!");
            return;
        }

        System.out.print("Enter the name of the customer: ");
        String customerName = scanner.nextLine();


        TypeOfCutsSelect selector = new TypeOfCutsSelect();
        TypeOfCuts selectedCut = selector.chooseType();
        String addOns = addAdditional();

        Appointment appointment = new Appointment(customerName, selectedCut);


        System.out.print("Has the customer paid? (Yes/no) ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            appointment.setPaid(true);
        } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
            appointment.setPaid(false);
        }

        // Fjerner alt andet end tal, og sætter ind i "priceThing" på choice's plads
        String numbers = selectedCut.toString().replaceAll("[^0-9]", "");
        priceThing[choice] = Integer.parseInt(numbers);

        slots[choice] = appointment.toString();
        System.out.println("Booked time at " + times[choice] + " for " + slots[choice] + addOns);
        System.out.println();

    }

    // Aflys en tid
    public void cancelSlot() {
        showSlots();
        System.out.print("\nChoose a time to delete: (1-16): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice < 0 || choice >= slots.length) {
            System.out.println("Invalid choice.");
            return;
        }

        if (slots[choice].startsWith("BREAK")) {
            System.out.println("This is a break, and can't be deleted.");
            return;
        }

        slots[choice] = times[choice];
        System.out.println("The time is now available again.");
        System.out.println();
    }

    // Vis alle tider
    public void showSlots() {
        System.out.println("\nTodays appointments:");
        for (int i = 0; i < slots.length; i++) {
            System.out.println((i + 1) + ") " + slots[i]);
        }
        System.out.println();
    }

    public void editTime() {
        cancelSlot();
        bookSlot();
    }

    public void addAdditionalChoose() {
        System.out.println("Do you wanna add extra? (Yes/no");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            addAdditional();
        } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
            menu();
        }
    }

    public String addAdditional() {
        System.out.println("What would you like to add?");
        for (AdditionalBuys a : AdditionalBuys.values()) {
            System.out.println(a);
        }

        System.out.println("Enter you choice:");
        String input = scanner.nextLine();
        AdditionalBuys selected = null;
        for (AdditionalBuys add : AdditionalBuys.values()) {
            if (input.equalsIgnoreCase(add.getLabel())) {
                selected = add;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Invalid choice");
            return "";
        } else {
            System.out.println("You choose: " + selected.getLabel() + " " + selected.getPrice() + "kr.");
            return " + " + selected.getLabel() + " (" + selected.getPrice() + "kr.)";
        }

    }
}
