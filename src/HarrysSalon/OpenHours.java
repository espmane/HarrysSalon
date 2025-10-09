package HarrysSalon;

import java.time.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenHours {
    private String[] slots; // hver plads i arrayet er et tidsrum eller en booking
    private Scanner scanner = new Scanner(System.in);

    public OpenHours() {
        slots = new String[] {
                "10:00-10:30",
                "10:30-11:00",
                "11:00-11:30",
                "11:30-12:00",
                "12:00-12:30",
                "12:30-13:00",
                "PAUSE",
                "PAUSE",
                "14:00-14:30",
                "14:30-15:00",
                "15:00-15:30",
                "15:30-16:00",
                "16:00-16:30",
                "16:30-17:00",
                "17:00-17:30",
                "17:30-18:00"
        };
    }

    // Vis alle tider
    public void showSlots() {
        System.out.println("\nDagens tider:");
        for (int i = 0; i < slots.length; i++) {
            System.out.println((i + 1) + ") " + slots[i]);
        }
    }

    // Book en tid
    public void bookSlot() {
        showSlots();
        System.out.print("\nVælg en tid (1-16): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice < 0 || choice >= slots.length) {
            System.out.println("Ugyldigt valg.");
            return;
        }

        if (!slots[choice].contains("-")) {
            System.out.println("Denne tid er allerede booket!");
            return;
        }

        System.out.print("Indtast kundens navn: ");
        String name = scanner.nextLine();
        System.out.print("Indtast ydelse: ");
        String service = scanner.nextLine();

        slots[choice] = name + " (" + service + ")";
        System.out.println("Tid booket til " + name);
    }

    // Aflys en tid
    public void cancelSlot() {
        showSlots();
        System.out.print("\nVælg en tid at slette (1-16): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice < 0 || choice >= slots.length) {
            System.out.println("Ugyldigt valg.");
            return;
        }

        // Find tilbage til oprindeligt tidsinterval
        int hour = 10 + (choice / 2);
        int minute = (choice % 2) * 30;
        String start = String.format("%02d:%02d", hour, minute);
        String end = String.format("%02d:%02d", hour + (minute == 30 ? 1 : 0), (minute + 30) % 60);

        slots[choice] = start + "-" + end;
        System.out.println("Tiden er nu ledig igen.");
    }

    public void menu() {
        boolean exit = false;
        while (exit) ;
        System.out.println("""
                valid options:
                1. add a new appointment 'add'
                2. remove a appointment 'remove'
                3. edit appointment  'edit'
                4. addictional buys 'buy'
                5. show all appointments 'show'
                Go back "back"
                """);

        int choice = scanner.nextInt();
        scanner.nextLine();
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
    }
}