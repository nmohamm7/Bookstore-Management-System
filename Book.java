public class Book extends Product{
  
    private String ISBN;

    public Book (String name, int inventory, double price, String ISBN, String creatorName, int year, String genre) {
        super(name, inventory, price, creatorName, year, genre, 0);
        this.ISBN = ISBN;
        this.ID = Product.counter++;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN (String ISBN) {
        this.ISBN = ISBN;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nISBN: " + ISBN;
    }
}
