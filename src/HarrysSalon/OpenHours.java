package HarrysSalon;

import java.time.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenHours {
    private Scanner scanner = new Scanner(System.in);
    private final String[] times = { "10:00-10:30","10:30-11:00","11:00-11:30","11:30-12:00",
            "12:00-12:30","12:30-13:00",
            "PAUSE 13:00-13:30","PAUSE 13:30-14:00",
            "14:00-14:30","14:30-15:00","15:00-15:30","15:30-16:00",
            "16:00-16:30","16:30-17:00","17:00-17:30","17:30-18:00"
    };
    private String[] slots = times.clone();

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

        // vi kan ikke “nulstille” til tiden automatisk, fordi vi skrev tiderne manuelt
        // derfor kunne vi vælge at sætte den tilbage til "LEDIG"
        if (slots[choice].startsWith("PAUSE")) {
            System.out.println("Dette er en pause og kan ikke slettes.");
            return;
        }

        slots[choice] = times[choice];
        System.out.println("Tiden er nu ledig igen.");;
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