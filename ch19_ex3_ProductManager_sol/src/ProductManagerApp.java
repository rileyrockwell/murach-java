import java.util.ArrayList;

public class ProductManagerApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Product Manager\n");
        displayMenu();

        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            action = Console.getString("Enter a command: ");
            System.out.println();
            
            switch (action) {
                case "list" -> displayAll();
                case "add" -> addProduct();
                case "update" -> updateProduct();
                case "del", "delete" -> deleteProduct();
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

    public static void displayAll() {
        System.out.println("PRODUCT LIST");
        
        ArrayList<Product> products = ProductDB.getAll();
        String format = "%-8s%-40s%10s%n";
        for (Product p : products) {
            System.out.printf(format, 
                    p.getCode(), p.getDescription(), p.getPriceFormatted());
        }
        System.out.println();
    }

    public static void addProduct() {
        String code = Console.getString("Enter product code: ");
        String description = Console.getString("Enter product description: ");
        double price = Console.getDouble("Enter price: ");

        Product product = new Product(code, description, price);
        ProductDB.add(product);

        System.out.println(description + " has been added.\n");
    }

    public static void updateProduct() {
        String code = Console.getString("Enter product code to update: ");
        
        Product product = ProductDB.get(code);
        if (product == null) {
            System.out.println("No product matches that code.\n");
            return;
        } 
        
        String description = Console.getString("Enter product description: ");
        double price = Console.getDouble("Enter price: ");

        product.setDescription(description);
        product.setPrice(price);

        boolean success = ProductDB.update(product);
        if (success) {
            System.out.println(code 
                    + " has been updated in the database.\n");
        } else {
            System.out.println("Error! Unable to upldate product.\n");
        }

    }

    public static void deleteProduct() {
        String code = Console.getString("Enter product code: ");

        Product product = ProductDB.get(code);
        if (product == null) {
            System.out.println("No product matches that code.\n");
            return;
        }
        
        ProductDB.delete(product);
        System.out.println(product.getDescription() + " has been added.\n");                
    }
}