package HarrysSalon.usercontrol;

import HarrysSalon.MainMenu;

import java.util.Scanner;

public class User {
    public void userManager() {
        chooseDate();
        System.out.println("Welcome to Harry Salon user management:");
        System.out.println("1. Admin (Type 1 or Admin)");
        System.out.println("2. User (Type 2 or User)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Admin") || input.equalsIgnoreCase("1")) {
            Admin.admin();
        } else if (input.equalsIgnoreCase("User") || input.equalsIgnoreCase("2")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.menu();
        }
    }

public static String getChosenDate(){return chosenDate;}
    public static String chosenDate; //
    private void chooseDate(){
        System.out.print("Enter date (DD-MM-YYYY): ");
        Scanner scanner = new Scanner(System.in);
        String d = scanner.nextLine().trim();
        if (d.isEmpty()){
            System.out.println("Not date entered. Keeping previous date " + (chosenDate == null ? "(none)" : chosenDate));
            return;
        }
        chosenDate = d;
        System.out.println("Date set to: " + chosenDate);
    }
}
