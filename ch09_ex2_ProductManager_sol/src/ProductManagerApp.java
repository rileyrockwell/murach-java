import java.util.ArrayList;

public class ProductManagerApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Product Manager\n");
        displayMenu();

        // read list of products from file
        var products = ProductDB.getAll();
        
        // check if read was successful
        if (products == null) {
            System.out.println("Unable to read data.");
            System.out.println("Exiting application.");
            return;  // exit main() method
        }

        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            action = Console.getString("Enter a command: ");
            System.out.println();
            
            switch (action) {
                case "list" -> displayAll(products);
                case "add" -> addProduct(products);
                case "del", "delete" -> deleteProduct(products);
                case "help", "menu" -> displayMenu();
                case "exit" -> System.out.println("Bye.\n");
                default -> System.out.println("Error! Command not valid.\n");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all products");
        System.out.println("add     - Add a product");
        System.out.println("del     - Delete a product");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAll(ArrayList<Product> products) {
        System.out.println("PRODUCT LIST");

        String format = "%-8s%-40s%10s%n";
        for (Product p : products) {
            System.out.printf(format, 
                    p.getCode(), p.getDescription(), p.getPriceFormatted());
        }
        System.out.println();
    }

    public static void addProduct(ArrayList<Product> products) {
        String code = Console.getString("Enter product code: ");
        String description = Console.getString("Enter product description: ");
        double price = Console.getDouble("Enter price: ");

        Product p = new Product(code, description, price);
        products.add(p);
        ProductDB.saveAll(products);  // save product list to file

        System.out.println(description + " has been added.\n");
    }

    public static void deleteProduct(ArrayList<Product> products) {
        String code = Console.getString("Enter product code: ");

        for (Product p : products) {
            if (p.getCode().equals(code)) {
                products.remove(p);
                ProductDB.saveAll(products);  // save product list to file
                System.out.println(p.getDescription() 
                        + " has been deleted.\n");
                return;
            }
        }        
        
        System.out.println("No product matches that code.\n");
    }
}