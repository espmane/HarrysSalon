package HarrysSalon.usercontrol;

import HarrysSalon.MainMenu;

import java.util.Scanner;

public class User {
    public static void usermanager() {
        System.out.println("Welcome to Harry Salon usermanagement:");
        System.out.println("1. Admin (Type 1 or Admin)");
        System.out.println("2. User (Type 2 or User)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        if (input.equalsIgnoreCase("Admin") || input.equalsIgnoreCase("1")) {
            Admin a = new Admin();
            a.admin();
        } else if (input.equalsIgnoreCase("User") || input.equalsIgnoreCase("2")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.menu();
        }


    }
}
