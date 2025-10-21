package HarrysSalon.usercontrol;

import HarrysSalon.Appointment;

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
    }

    public static void Economy(){
        MainMenu menu = new MainMenu();
        int sum = 0;
        int i;

        //Getter for slots haha
        for (i=0; i<slots.length; i++){
            sum+= slots[i];
        }
        System.out.println("The total is:");
    }
}
