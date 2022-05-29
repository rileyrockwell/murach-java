import java.util.Scanner;

public class Console {
    public static double getDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal value.");
            }
        }
    }

    public static double getDouble(Scanner sc, String prompt,
            double min, double max) {
        while (true) {
            double value = getDouble(sc, prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " + 
                        min + " and less than " + max + ".");
            }
        }
    }
    
    public static int getInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer value.");
            }
        }
    }
    
    public static int getInt(Scanner sc, String prompt,
            int min, int max) {
        while (true) {
            int value = getInt(sc, prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " + 
                        min + " and less than " + max + ".");
            }
        }
    }
}
