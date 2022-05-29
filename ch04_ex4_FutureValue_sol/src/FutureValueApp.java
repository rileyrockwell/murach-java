import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = Double.parseDouble(sc.nextLine());
            System.out.print("Enter number of years:      ");
            int years = Integer.parseInt(sc.nextLine());
            System.out.println();

            // get currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);
            
            // display the header row
            System.out.printf("%-5s", "Year");
            for (double rate = 5.0; rate < 7.0; rate += .5) {
                System.out.printf("%12s", percent.format(rate/100));
            }
            System.out.println();

            // display one row for each year
            for (int year = 1; year <= years; year++) {
                // add year to first column
                System.out.printf("%-5s", year);

                // display one column for each interest rate
                for (double rate = 5.0; rate < 7.0; rate += .5) {
                    int months = year * 12;
                    double monthlyInterestRate = rate/12/100;

                    // calculate the future value
                    double futureValue = 0.0;
                    for (int i = 1; i <= months; i++) {
                        futureValue = (futureValue + monthlyInvestment) *
                                      (1 + monthlyInterestRate);
                    }

                    // add future value to its column
                    System.out.printf("%12s", currency.format(futureValue));
                }
                System.out.println();  // start a new row
            }
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        System.out.println("Bye!");
    }
}
