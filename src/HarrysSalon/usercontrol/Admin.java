package HarrysSalon.usercontrol;

import HarrysSalon.Appointment;
import HarrysSalon.MainMenu;
import HarrysSalon.typeofcuts.TypeOfCuts;

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
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.equalsIgnoreCase("Yes")|| input.equalsIgnoreCase("1"));
        Economy();
    }

    public static void Economy(){
      MainMenu menu = new MainMenu();
        int total = 0;

        for (int i = 0; i < menu.priceThing.length; i++) {
            total =+ menu.priceThing[i];
            System.out.println(menu.priceThing[i]);
        }
        System.out.println("" + total);

        for (TypeOfCuts cut : menu.toc) {
            if (cut != null) {
                total += cut.getPrice();
            }
        }
        System.out.println("The total is:" + total);
    }
}
