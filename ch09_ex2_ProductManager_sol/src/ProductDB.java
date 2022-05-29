import java.io.*;
import java.util.ArrayList;

public class ProductDB {
    private static final String FILENAME = "productsX.txt";
    private static final String COLUMN_SEP = "\t";
    
    public static ArrayList<Product> getAll() {
        var products = new ArrayList<Product>();
        try (BufferedReader in = new BufferedReader(
                                 new FileReader(FILENAME))) {

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split(COLUMN_SEP);
                String code = columns[0];
                String description = columns[1];
                String price = columns[2];

                Product p = new Product(
                        code, description, Double.parseDouble(price));
                products.add(p);

                line = in.readLine();
            }
            return products;
        }
        catch (FileNotFoundException e) {
            System.out.println(FILENAME + " doesn't exist.");
            return null;            
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void saveAll(ArrayList<Product> products) {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(FILENAME)))) {

            // write all products to the file
            for (Product p : products) {
                out.print(p.getCode() + COLUMN_SEP);
                out.print(p.getDescription() + COLUMN_SEP);
                out.println(p.getPrice());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }    
}