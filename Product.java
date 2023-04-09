public abstract class Product implements Comparable<Product> {
    
    private String name;
    private int inventory;
    private double price;
    private String creatorName;
    private int year;
    private String genre;
    public int ID;
    public static int counter = 1;
    
    public Product (String name, int inventory, double price, String creatorName, int year, String genre, int ID) {
        this.name = name;
        this.inventory = inventory;
        this.price = price;
        this.creatorName = creatorName;
        this.year = year;
        this.genre = genre;
        this.ID = Product.counter++;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getInventory() {
        return this.inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public void setCreatorName (String creatorName) {
        this.creatorName = creatorName;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre (String genre) {
        this.genre = genre;
    }

    public int getId() {
        return this.ID;
    }
    
    public void removeInventory(int sold) {
        this.inventory = this.inventory - sold;
    }
    
    @Override
    public String toString() {
    return name + ": " + "\n" + inventory + " Available, $" + price + "\n" + creatorName + ", " + year + ", " + genre;
    }

    // compareTo method to compare objects in the inventory array and used to sort them based on price
    @Override
    public int compareTo (Product o) {
            Product p = (Product) o;
            if (this.getPrice() == p.getPrice()) {
                return 0;
            }
            else {
                return (int) (this.getPrice() - p.getPrice());
            }
    }   
}
