package HarrysSalon;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cuts {
    private String typeOfCut;
    private int price;
    private String customerName;
    private String date;

    Scanner scanner = new Scanner(System.in);

    Cuts(String typeOfCut, int price, String customerName, String date) {
        this.typeOfCut = typeOfCut;
        this.price = price;
        this.customerName = customerName;
        this.date = date;
    }
    public String getDate() {return date;}
    public String getName() {return customerName;}

    public Cuts() {

        while (true) {
            System.out.print("Please input the date for the cut in the format dd/mm/yy: ");
            this.date = scanner.nextLine();
            if (validateDate(date)) {
                break;
            }
        }

        while (true) {
            System.out.println("""
                    
                    Please add which type of cut:
                    Man
                    Woman
                    Beard
                    Hair coloring.
                    """);
            String cutType = scanner.nextLine();

            // validating cut type
            if (validateCut(cutType)) {
                break;
            } else {
                System.out.println("You've input an invalid cut, try again. ");
            }
        }

        while (true) {
            System.out.println("What is their name?: ");
            customerName = scanner.nextLine();

            // checking for numbers in customerName using regex
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(customerName);
            boolean matchFound = matcher.find();
            if (matchFound) {
                System.out.println("Names cannot contain numbers. Please try again.");
            } else  {
                break;
            }
        }
    }

    private boolean validateDate(String date) {
        // split "date" into 3 based on "/"
        String[] parts = date.split("/");
        if (parts.length == 3) {
            // change to int
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // check if they're valid dates
            if (month <= 12 && day <= 31 && month >= 1 && day >= 1 && year <= 99 && year >= 0) {
                return true;
            } else {
                System.out.println("Invalid date format. Please try again.\n");
                return false;
            }
        } else {
            System.out.println("Invalid date format. Please try again.\n");
            return false;
        }
    }

    private boolean validateCut(String cutType) {
        switch (cutType.toLowerCase()) {
            case "man":
            case "woman":
            case "beard":
            case "hair coloring":
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        String output = date + " " + customerName + " is getting " + typeOfCut + " haircut for " + price + "Kr";
        return output;
    }
}
