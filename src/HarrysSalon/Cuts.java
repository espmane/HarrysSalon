package HarrysSalon;

import java.util.Scanner;

public class Cuts {
    private String typeOfCut;
    private int price;
    private String customerName;
    private String date;

    Scanner scanner = new Scanner(System.in);


    public Cuts() {
        System.out.println("Please input the date for the cut");
        this.date = scanner.nextLine();
        System.out.println("Please enter a name for the customer");
        this.customerName=scanner.nextLine();
        System.out.println("""
                Please add type of cut:
                Mens cut
                Woman cut
                Beard trim
                Hair coloring
                """);
        this.typeOfCut = validateCut();
    }

    public Cuts(String typeOfCut, int price, String customerName, String date) {
        this.typeOfCut = typeOfCut;
        this.price = price;
        this.customerName = scanner.nextLine();
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName(){
        return customerName;
    }

    public void setName(String customerName){
        this.customerName=customerName;
    }

    private boolean contains(String test) {
        for (DCuts dcuts : DCuts.values()) {
            if (dcuts.name().equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    private String validateCut() {
        String input = scanner.nextLine().toUpperCase();
        boolean isDone = false;

        while (!isDone) {
            if (contains(input)) {
                isDone = true;

            } else {
                System.out.println("You've input an invalid cut. ");
                input = scanner.nextLine().toUpperCase();
            }
        }
        return input;
    }

    @Override
    public String toString(){
        return customerName + " - " + date + " - "+ typeOfCut + " - "+ price;
    }
}
