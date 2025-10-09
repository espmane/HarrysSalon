package HarrysSalon;

import java.util.Scanner;
import java.util.ArrayList;

public class HarrySalon {
    ArrayList<Cuts> appointments = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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
                    addTime();
                    break;
                case "2":
                case "remove":
                    removeTime();
                    break;
                case "3":
                case "edit":
                    editTime();
                    break;
                case "4":
                case "buy":
                    buyAdditional();
                    break;
                case "5":
                case "show":
                    showAppointments();
                    break;
                case "0":
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (exit == false);
    }


    public void addTime() {
        Cuts cuts = new Cuts();
        appointments.add(cuts);
        System.out.println("You've added: " + appointments);
    }

    public void removeTime(){
        System.out.println("Please enter the time appointment you want to remove.");
        String input = scanner.nextLine();

        boolean removed = appointments.removeIf(c ->
                c.getName() != null && c.getName().equalsIgnoreCase(input));

        if (removed)
        {
            System.out.println(input + " has been removed.");
        }else{
            System.out.println(input + " does not exist.");

        }
    }

    public void editTime(){
        System.out.println("times currently scheduled:");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i+1) + ": " +  appointments.get(i));
        }
        System.out.println("-------------------------");
    }

    public void buyAdditional() {

    }

    public void showAppointments() {
        System.out.println(appointments.toString());
        System.out.println();
    }
}
