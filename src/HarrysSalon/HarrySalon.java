/*
package HarrysSalon;
import HarrysSalon.typeofcuts.TypeOfCutsSelect;

import java.util.Scanner;
import java.util.ArrayList;

public class HarrySalon {
    ArrayList<TypeOfCutsSelect> appointments = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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
                    addTime();
                    menu();
                    break;
                case 2:
                    removeTime();
                    menu();
                    break;
                case 3:
                    editTime();
                    menu();
                    break;
                case 4:
                    buyAddictional();
                    break;
                case 5:
                    showAppointments();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
    }


    public void addTime(){
        TypeOfCutsSelect typeOfCutsSelect = new TypeOfCutsSelect();
        appointments.add(typeOfCutsSelect);
        System.out.println("You've added: " + appointments);
    }

    public void removeTime(){
        System.out.println("Please enter the time appointment you want to remove.");
        String input = scanner.nextLine();

        boolean removed = appointments.removeIf(c ->
                c.getCustomerName() != null && c.getName().equalsIgnoreCase(input));

        if (removed)
         {
            System.out.println(input + " has been removed.");
        }else{
            System.out.println(input + " does not exist.");

        }
    }

    public void editTime(){
            System.out.println("times currently scheduled:");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i+1) + ": " +  appointments.get(i));
            }
            System.out.println("-------------------------");
    }

    public void buyAddictional(){

    }

    public void showAppointments(){

    }
}
*/