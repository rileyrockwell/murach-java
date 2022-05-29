public class EqualsTestApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Equals Tester\n");

        //Both variables refer to different objects that store the same data
        Product product1 = new Product("java", "Murach's Java Programming", 57.5);
        Product product2 = new Product("java", "Murach's Java Programming", 57.5); 
        // test equals() method
        if (product1.equals(product2)) {
            System.out.println("The Product class is comparing data.");
        } else {
            System.out.println("The Product class is comparing references.");
        }
        // test hashCode() method
        if (product1.hashCode() == product2.hashCode()) {
            System.out.println("The Product object hash codes match.");
        } else {
            System.out.println("The Product object hash codes are different.");
        }
        System.out.println();

        //Both variables refer to different objects that store the same data
        LineItem li1 = new LineItem(product1, 1);
        LineItem li2 = new LineItem(product2, 1);
        // test equals() method
        if (li1.equals(li2)) {
            System.out.println("The LineItem class is comparing data.");
        } else {
            System.out.println("The LineItem class is comparing references.");
        }
        // test hashCode() method
        if (li1.hashCode() == li2.hashCode()) {
            System.out.println("The LineItem object hash codes match.");
        } else {
            System.out.println("The LineItem object hash codes are different.");
        }
        System.out.println();        
    }
}