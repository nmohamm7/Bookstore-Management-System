public class CD extends Product {
    
    public CD (String name, int inventory, double price, String creatorName, int year, String genre) {
        super(name, inventory, price, creatorName, year, genre, 0);
        this.ID = Product.counter++;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
