package HarrysSalon.usercontrol;

import java.util.Scanner;

public class Admin {
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
