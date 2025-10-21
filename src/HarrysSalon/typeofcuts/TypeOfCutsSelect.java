package HarrysSalon.typeofcuts;

import java.util.Scanner;

public class TypeOfCutsSelect {
    private final Scanner scanner = new Scanner(System.in);

    public TypeOfCuts chooseType() {
        while (true) {
            System.out.println("""
                    Please add type of cut:
                    1. Mens cut
                    2. Woman cut
                    3. Beard trim
                    4. Hair coloring
                    """);
            System.out.println("Choose between 1-4");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice");
                continue;
            }

            switch (choice) {
                case 1:
                    return new MensCut();
                case 2:
                    return new WomanCut();
                case 3:
                    return new BeardTrim();
                case 4:
                    return new HairColoring();
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
}