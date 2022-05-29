import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (!choice.equalsIgnoreCase("n")) {
            // get the input from the user
            System.out.print("Enter customer type (r/c/t): ");
            String customerType = sc.nextLine();
            
            System.out.print("Enter subtotal:   ");
            double subtotal = Double.parseDouble(sc.nextLine());
            
            // get the discount percent
            double discountPercent = .1;  // default discount
            if (customerType.equalsIgnoreCase("r")) {
                if (subtotal >= 500) {
                    discountPercent = .3;
                } else if (subtotal >= 250) {
                    discountPercent = .25;
                } else if (subtotal >= 100) {
                    discountPercent = .1;
                } else {  
                    discountPercent = 0.0;
                }
            }
            else if (customerType.equalsIgnoreCase("c")) {
                discountPercent = .2;
            }
            else if (customerType.equalsIgnoreCase("t")) {
                if (subtotal < 500) {
                    discountPercent = .4;
                } else {
                    discountPercent = .5;
                }
            }

            // calculate the discount amount and round to 2 decimals
            double discountAmount = subtotal * discountPercent;
            discountAmount = Math.ceil(discountAmount * 100) / 100;

            // calculate the total
            double total = subtotal - discountAmount;

            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                "Discount percent: " + percent.format(discountPercent) + "\n"
              + "Discount amount:  " + currency.format(discountAmount) + "\n"
              + "Total:            " + currency.format(total) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}