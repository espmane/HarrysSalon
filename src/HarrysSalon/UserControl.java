package HarrysSalon;

import java.util.Scanner;

public class UserControl {

    public static void usermanager() {
        System.out.println("Welcome to Harry Salon usermanagement:");
        System.out.println("1. Admin (Type 1 or Admin)");
        System.out.println("2. User (Type 2 or User)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        if (input.equalsIgnoreCase("Admin") || input.equalsIgnoreCase("1")){
            admin();
        }else if(input.equalsIgnoreCase("User") || input.equalsIgnoreCase("2")){
            OpenHours openHours = new OpenHours();
            openHours.menu();
        }


    }

    public static void admin (){
        System.out.println("Admin login:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("123")) {
            adminmenu();
        }else {
            System.out.println("Wrong password");
            admin();
        }
    }

    public static void adminmenu(){
        System.out.println("U did it");
    }
}

