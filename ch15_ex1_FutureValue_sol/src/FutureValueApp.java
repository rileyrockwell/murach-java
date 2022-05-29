import java.util.Collections;
import java.util.LinkedList;

public class FutureValueApp {

    public static void main(String[] args) {
        
        LinkedList<FutureValue> calculations = new LinkedList<>();
        
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        // perform 1 or more calculations
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Console.getDouble(
                "Enter monthly investment: ", 0, 1000);
            double interestRate = Console.getDouble(
                "Enter yearly interest rate: ", 0, 30);
            int years = Console.getInt(
                "Enter number of years: ", 0, 100);
            System.out.println();

            // create FutureValue object
            FutureValue fv = new FutureValue(
                    monthlyInvestment, interestRate, years);
            
            // add to calculations collection
            calculations.add(fv);

            // print the results
            System.out.println("\nFORMATTED RESULTS\n" 
              + "Monthly investment:   " + fv.getMonthlyInvestmentFormatted() + "\n"
              + "Yearly interest rate: " + fv.getInterestRateFormatted() + "\n"
              + "Number of years:      " + fv.getYears() + "\n"
              + "Future value:         " + fv.getFutureValueFormatted() + "\n");

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }

        // sort the calcuations
        Collections.sort(calculations);
        // this works too, but only after you've implemented the Comparable interface
        /*
        Collections.sort(calculations, (c1, c2) -> {
            if (c1.getFutureValue()< c2.getFutureValue()) return -1;
            else if (c1.getFutureValue()> c2.getFutureValue()) return 1;
            else return 0;
        });
        */

        // print the results for all calculations
        System.out.println("ALL CALCULATIONS (SORTED)");
        System.out.println();
        System.out.println("Inv/Mo.       Rate  Years  Future Value");
        for (FutureValue calc : calculations) {
             System.out.printf("%-12s%6s%7d%14s\n", 
                     calc.getMonthlyInvestmentFormatted(), 
                     calc.getInterestRateFormatted(), 
                     calc.getYears(), 
                     calc.getFutureValueFormatted());            
        }
    }
}
