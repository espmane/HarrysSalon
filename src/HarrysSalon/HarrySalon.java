package HarrysSalon;
import java.util.Scanner;

public class HarrySalon {
    Arraylist<Cuts> Appointments = new Arraylist<>();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        showMenu();
        int choise = 0;
        switch (choise) {
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

        }
    }

    public void showMenu(){
        System.out.println("""
                valid options:
                1. add a new appointment 'add'
                2. remove a appointment 'remove'
                3. edit appointment  'edit'
                4. addictional buys 'buy'
                5. show all appointments 'show'
                Go back "back"
                """);
    }

    public void addTime(){
        Cuts Appointment = new Cuts();
        this.Appointments.add(Appointments);
        System.out.println("You've added: " + Appointments + " ");
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
