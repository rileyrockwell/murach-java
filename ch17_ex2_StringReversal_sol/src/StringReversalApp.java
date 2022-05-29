

import java.util.Scanner;

public class StringReversalApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string to reverse: ");
        String input = sc.next();

        System.out.println("Iterative string reversal...");
        String result = iterReverse(input);
        System.out.println(result);

        System.out.println("Recursive string reversal...");
        result = recReverse(input);
        System.out.println(result);
        System.out.println();
    }    

    // iterative
    public static String iterReverse(String str) {
        String reverseStr = "";        
        for(int i = str.length()-1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    // recursive
    public static String recReverse(String str) {
        if(str.length() <= 1) {
            return str;
        }
        else {
            return str.charAt(str.length()-1) + recReverse(str.substring(0, str.length()-1));
        }
    }
}
