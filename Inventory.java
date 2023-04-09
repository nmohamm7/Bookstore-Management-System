import java.util.*;

public class Inventory extends BookStore implements BookStoreSpecification {
    
    public static ArrayList<Product> Inventory = new ArrayList<>();

    // Creating product objects and adding them to inventory arraylist
    public Inventory() {
        Book book1 = new Book("The Giver", 25, 12.99, "978-0-544-44220-7", "Lois Lowry", 1993, "Dystopian");
        Book book2 = new Book("The Great Gatsby", 25, 12.99, "978-1-982-14948-2", "F. Scott Fitzgerald", 1953, "Tragedy");
        Book book3 = new Book("Forrest Gump", 25, 12.99, "978-0-307-94739-0", "Winston Groom", 1986, "Fiction");
        Book book4 = new Book("Wonder", 25, 12.99, "978-0-141-37824-4", "R. J. Palacio", 2012, "Fiction");
        Book book5 = new Book("Charlotte's Web", 25, 12.99, "978-0-062-65875-3", "E. B. White", 1952, "Children's Fiction");

        CD CD1 = new CD("DAMN", 20, 9.99, "Kendrick Lamar", 2017, "Rap");
        CD CD2 = new CD("Astroworld", 20, 9.99, "Travis Scott", 2018, "Rap");
        CD CD3 = new CD("If You're Reading This It's Too Late", 20, 9.99, "Drake", 2015, "Rap");
        CD CD4 = new CD("My Beautiful Dark Twisted Fantasy", 20, 9.99, "Kanye West", 2010, "Rap");
        CD CD5 = new CD("2014 Forest Hills Drive", 20, 9.99, "J. Cole", 2014, "Rap");

        DVD DVD1 = new DVD("To the Forest of Firefly Lights", 25, 14.99, "Takahiro Omori", 2011, "Fantasy Anime", "7.8/10", "PG");
        DVD DVD2 = new DVD("Spirited Away", 25, 14.99, "Hayao Miyazaki", 2001, "Adventure Anime", "8.6/10", "PG");
        DVD DVD3 = new DVD("Cars 2", 25, 14.99, "John Lasseter", 2011, "Kids and Family", "6.2/10", "G");
        DVD DVD4 = new DVD("The Dark Knight", 25, 14.99, "Christopher Nolan", 2008, "Action", "9.0/10", "PG-13");
        DVD DVD5 = new DVD("Inception", 25, 14.99, "Christopher Nolan", 2010, "Action", "8.8/10", "PG-13");

        Inventory.add(0, book1);
        Inventory.add(1, book2);
        Inventory.add(2, book3);
        Inventory.add(3, book4);
        Inventory.add(4, book5);
        Inventory.add(5, CD1);
        Inventory.add(6, CD2);
        Inventory.add(7, CD3);
        Inventory.add(8, CD4);
        Inventory.add(9, CD5);
        Inventory.add(10, DVD1);
        Inventory.add(11, DVD2);
        Inventory.add(12, DVD3);
        Inventory.add(13, DVD4);
        Inventory.add(14, DVD5);
    }

    public ArrayList<Product> getInventory() {
        return Inventory;
    }

    //method to find a product based on its id number
    public Product getProductByID(int id) {
        for (Product product : Inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    //method to update inventory and subtract the amount of each product purchased from the total inventory
    public void updateInventory() {

        ArrayList<Integer> purchasedproductsIndex = new ArrayList<>();
        for (int j = 0; j < shoppingCart.size(); j++) { //iterate through array of purchased products
            for (int i = 0; i < Inventory.size(); i++) { //iterate through array of all products
                String nameToFind = BookStore.shoppingCart.get(j).getName(); //name of product in cart array being compared

                if (Inventory.get(i).getName().equals(nameToFind)) {
                    purchasedproductsIndex.add(i); //add the index of the product to array
                }
            }
        }
        for (int k = 0; k < purchasedproductsIndex.size(); k++) {
            Inventory.get(purchasedproductsIndex.get(k)).setInventory(Inventory.get(purchasedproductsIndex.get(k)).getInventory() - 1); // subtract 1 from inventory of each product purchased
        }
    }

    //implementation of methods from interface
    @Override
    public void restockProduct (int id, int amount) {
        Product p = getProductByID(id);
        if (p == null) {
            System.out.println("\nInvalid product ID");
            return;
        }
        p.setInventory(p.getInventory() + amount); // add amount to inventory
        System.out.println("\nProduct restocked successfully!\n");

    }

    @Override
    public double inventoryValue() {
        double totalValue = 0.0;
        for (Product product : Inventory) { //iterate through array and calculate price of each product and its total inventory
            totalValue += (product.getPrice() * product.getInventory());
        }
        return totalValue;
    }
}
