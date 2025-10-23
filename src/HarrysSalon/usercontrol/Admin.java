package HarrysSalon.usercontrol;

import HarrysSalon.MainMenu;

import java.util.Scanner;


public class Admin {
    public static void admin() {
        System.out.print("Admin login: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("hairyharry")) {
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
                0. Exit
                """);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input.toLowerCase()) {
            case "1":
            case "economy":
                printIncome();
            case "0":
            case "exit":
                return;
            default:
                System.out.println("Invalid input, try again.");
                adminMenu();
        }
    }

    public static void printIncome() {
        int total = 0;

        for (int i = 0; i < MainMenu.arrayWithPrice.length; i++) {
            total += MainMenu.arrayWithPrice[i];
        }
        System.out.println("The total income for date " + User.getChosenDate() + ":\n" + total);
        adminMenu();
    }
}
