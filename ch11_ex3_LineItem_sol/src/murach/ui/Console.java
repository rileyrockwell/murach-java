package murach.ui;

import java.util.Scanner;

/**
 * The <code>Console</code> class provides methods that can be used to get
 * input from a console application.
 */
public class Console {
    
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Displays the specified prompt to the console and gets
     * a <code>String</code> from the user.
     *
     * @param prompt A <code>String</code> prompt to the user.
     * @return       A <code>String</code> entered by the user.
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();  
    }

    /**
     * Displays the specified prompt to the console and 
     * gets an <code>int</code> value from the user.
     *
     * @param prompt A <code>String</code> prompt to the user.
     * @return       An <code>int</code> value entered by the user.
     */
    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Error! Invalid integer value.");
            }
        }
    }

    /**
     * Displays the specified prompt to the console and 
     * gets an <code>int</code> value from the user 
     * that's within the specified range.
     *
     * @param prompt A <code>String</code> prompt to the user.
     * @param min    The minimum <code>int</code> value.
     * @param max    The maximum <code>int</code> value.
     * @return       An <code>int</code> value entered by the user.
     */
    public static int getInt(String prompt, int min, int max) {
        while (true) {
            int value = getInt(prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " 
                        + min + " and less than " + max + ".");
            } 
        }
    }

    /**
     * Displays the specified prompt to the console and 
     * gets a <code>double</code> value from the user.
     *
     * @param prompt A <code>String</code> prompt to the user.
     * @return       A <code>double</code> value entered by the user.
     */
    public static double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Error! Invalid integer value.");
            }
        }
    }

    /**
     * Displays the specified prompt to the console and 
     * gets a <code>double</code> value from the user 
     * that's within the specified range.
     *
     * @param prompt A <code>String</code> prompt to the user.
     * @param min    The minimum <code>double</code> value.
     * @param max    The maximum <code>double</code> value.
     * @return       A <code>double</code> value entered by the user.
     */
    public static double getDouble(String prompt, double min, double max) {
        while (true) {
            double value = getDouble(prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " 
                        + min + " and less than " + max + ".");
            } 
        }
    }
}