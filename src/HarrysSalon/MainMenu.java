package HarrysSalon;

import HarrysSalon.typeofcuts.TypeOfCutsSelect;
import HarrysSalon.typeofcuts.TypeOfCuts;

import java.util.Scanner;

public class MainMenu {
    private final String[] times = {"10:00-10:30", "10:30-11:00", "11:00-11:30", "11:30-12:00",
            "12:00-12:30", "12:30-13:00",
            "BREAK", "BREAK",
            "14:00-14:30", "14:30-15:00", "15:00-15:30", "15:30-16:00",
            "16:00-16:30", "16:30-17:00", "17:00-17:30", "17:30-18:00"
    };
    private String[] slots = times.clone();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    valid options:
                    1. add a new appointment 'add'
                    2. remove an appointment 'remove'
                    3. show all appointments  'show'
                    4. edit an appointment 'edit'
                    5. addictional buys 'buy'
                    Go back "back"
                    """);

            String input = scanner.nextLine();
            int choice = -1;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice");
                continue;
            }

            switch (choice) {
                case 1:
                    bookSlot();
                    menu();
                    break;
                case 2:
                    cancelSlot();
                    menu();
                    break;
                case 3:
                    showSlots();
                    menu();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
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
            choice=Integer.parseInt(scanner.nextLine()) - 1;
        }catch (NumberFormatException e){
            System.out.println("Please enter a number");
            return;
        }

        if (choice < 0 || choice >= slots.length) {
            System.out.println("Invalid choise.");
            return;
        }

        if (!slots[choice].contains("-")) {
            System.out.println("This time is already in use!");
            return;
        }

        System.out.print("Enter the name of the Customer: ");
        String customerName = scanner.nextLine();

        TypeOfCutsSelect selector = new TypeOfCutsSelect();
        TypeOfCuts selectedCut = selector.chooseType();

        Appointment appointment = new Appointment(customerName, selectedCut);



        System.out.print("Has the customer paid? (Yes/no) ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            appointment.setPaid(true);
        }else if (input.equalsIgnoreCase("no")) {
            appointment.setPaid(false);
        }

        slots[choice] = appointment.toString();
        System.out.println("Booked time for " + slots[choice] + " at " + times[choice] + " - " + appointment.isPaid() + ".");
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
        TypeOfCutsSelect typeOfCutsSelect = new TypeOfCutsSelect();
        showSlots();

    }
}
