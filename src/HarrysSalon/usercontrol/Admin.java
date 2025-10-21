package HarrysSalon.usercontrol;

import HarrysSalon.MainMenu;
import HarrysSalon.typeofcuts.TypeOfCuts;

import java.util.Scanner;


public class Admin {
    public static void admin() {
        System.out.print("Admin login: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("123")) {
            adminMenu();
        } else {
            System.out.println("Wrong password");
            admin();
        }
    }

    public static void adminMenu() {
        System.out.println("""
                Welcome Admin!
                
                Valid options are:
                1. Economy
                0. Explode
                """);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input.toLowerCase()) {
            case "1":
            case "economy":
                economy();
            case "0":
            case "explode":
                return;
            default:
                System.out.println("Invalid input, try again.");
                adminMenu();
        }
    }

    public static void economy() {
        int total = 0;

        for (int i = 0; i < MainMenu.priceThing.length; i++) {
            total += MainMenu.priceThing[i];
        }
        System.out.println("The total is:" + total);
    }
}
