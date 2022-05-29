import java.util.Scanner;
import java.text.NumberFormat;

public class MPGApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Miles Per Gallon calculator");
        System.out.println();  // print a blank line
        
        Scanner sc = new Scanner(System.in);
        String input;
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            input = sc.nextLine();
            double miles = Double.parseDouble(input);
            
            System.out.print("Enter gallons of gas used: ");
            input = sc.nextLine();
            double gallons = Double.parseDouble(input);
            
            double mpg = miles/gallons;
            //mpg = (double) Math.round(mpg * 100) / 100; 
            //System.out.println("Miles per gallon is " + mpg + ".");
            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMaximumFractionDigits(2);
            System.out.println("Miles per gallon is " + number.format(mpg) + ".");
            System.out.println(); 
            
            System.out.print("Calculate another MPG? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
    
}