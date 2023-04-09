public class DVD extends Product {
    
    private String DVDRating;
    private String movieRating;
    
    public DVD (String name, int inventory, double price, String creatorName, int year, String genre, String DVDRating, String movieRating) {
        super(name, inventory, price, creatorName, year, genre, 0);
        this.DVDRating = DVDRating;
        this.movieRating = movieRating;
        this.ID = Product.counter++;
    }
    
    public String getDVDRating() {
        return this.DVDRating;
    }

    public void setDVDRating (String DVDRating) {
        this.DVDRating = DVDRating;
    }

    public String getMovieRating() {
        return this.movieRating;
    }

    public void setMovieRating (String movieRating) {
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + movieRating + "\nIMDb Rating: " + DVDRating;
    }
}
