package HarrysSalon;
import java.util.Scanner;
import java.util.ArrayList;

public class HarrySalon {
    ArrayList<Cuts> appointments = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean exit = false;
        System.out.println("""
                    valid options:
                    1. add a new appointment 'add'
                    2. remove a appointment 'remove'
                    3. edit appointment  'edit'
                    4. addictional buys 'buy'
                    5. show all appointments 'show'
                    Go back "back"
                    """);
        while (exit) ;
        {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTime();
                    break;
                case 2:
                    removeTime();
                    break;
                case 3:
                    editTime();
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
    }


    public void addTime(){
        Cuts cuts = new Cuts();
        appointments.add(cuts);
        System.out.println("You've added: " + appointments + " ");
    }

    public void removeTime(){

    }

    public void editTime(){

    }

    public void buyAddictional(){

    }

    public void showAppointments(){

    }
}
