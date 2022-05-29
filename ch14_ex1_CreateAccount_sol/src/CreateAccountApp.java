import java.util.Scanner;

public class CreateAccountApp {
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String fullName = getFullName();
        // String password = getPassword();
        // String email = getEmail();
        String phone = getPhone();
        System.out.println();

        String msg = getSuccessMessage(fullName, phone);
        System.out.println(msg);
    }

    private static String getFullName() {
        while(true) {
            System.out.print("Enter full name: ");
            String name = sc.nextLine().trim();
            if(name.contains(" ")) {
                return name;
            } else {
                System.out.println("You must enter your full name.\n");
            }
        }
    }

    private static String getPassword() {
        while(true) {
            System.out.print("Enter password: ");
            String password = sc.nextLine().trim();
            
            boolean isMinLength = false;
            boolean hasDigit = false;
            boolean hasUppercase = false;           

            if (password.length() >= 8) {
                isMinLength = true;
            }
            
            for (char c: password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                }
            }
            
            if (isMinLength && hasDigit && hasUppercase) {
                return password;
            } else {
                System.out.println("Password must be 8 characters or more\n" 
                    + "with at least one digit and one uppercase letter.\n");
            }
        }
    }
    
    private static String getEmail() {
        while (true) {
            System.out.print("Enter email: ");
            String email = sc.nextLine().trim();
            
            if (email.contains("@") && email.contains(".com")) {
                return email;
            }
            else {
                System.out.println("Please enter a valid email address.");                
            }
        }
    }
        
    private static String getPhone() {
        while (true) {
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine().trim();

            String[] illegalChars = " -().".split("");
            for (String illegalChar : illegalChars) {
                phone = phone.replace(illegalChar, "");
            }
            
            boolean allDigits = true;
            for (char c: phone.toCharArray()) {
                if (!Character.isDigit(c)) {
                    allDigits = false;
                }
            }

            if (phone.length() == 10 && allDigits) {
                phone = phone.substring(0,3) + "." + 
                        phone.substring(3,6) + "." + 
                        phone.substring(6);
                return phone;
            }
            else {
                System.out.println("Please enter a 10-digit phone number.");
            }
        }
    }
        
    private static String getSuccessMessage(String fullName, String phone) {
        int index = fullName.indexOf(" ");
        String firstName = fullName.substring(0,1).toUpperCase() +  
                           fullName.substring(1, index).toLowerCase();        
        return "Hi " + firstName + ", thanks for creating an account!\n" +
               "We'll text your confirmation code to this number: " + phone;
    }
}