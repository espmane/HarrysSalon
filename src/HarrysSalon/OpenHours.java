package HarrysSalon;

import java.time.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenHours {
        private String[] slots; // hver plads i arrayet er et tidsrum eller en booking
        private Scanner scanner = new Scanner(System.in);

public OpenHours() {
            slots = new String[16]; // 8 timer åbent * 2 slots pr. time = 16 slots
            int hour = 10; //Starter klokken 10
            int minute = 0;
            for (int i = 0; i < slots.length; i++) {
                String start = String.format("%02d:%02d", hour, minute); //% = betyder helt tal - 02 = mindst 2 cifre, fylder med 0'er hvis der ingen tal er før)
                minute += 30; //Ligger 30 minutter til
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
                String end = String.format("%02d:%02d", hour, minute);
                slots[i] = start + "-" + end; // default = tidsinterval

                if ((start.equals("13:00") && end.equals("13:30")) ||
                        (start.equals("13:30") && end.equals("14:00"))) {
                    slots[i] = "PAUSE";
                } else {
                    slots[i] = start + "-" + end;
                }
            }
        }

        // Vis alle tider
        public void showSlots () {
            System.out.println("\nDagens tider:");
            for (int i = 0; i < slots.length; i++) {
                System.out.println((i + 1) + ") " + slots[i]);
            }
        }

        // Book en tid
        public void bookSlot () {
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
        public void cancelSlot () {
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

        public void menu () {
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