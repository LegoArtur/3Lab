package example.price;
import example.MovieType;

public abstract class Price {
  private MovieType priceCode;
  public abstract double getCharge(int daysRented);
  public int getBonusPointsPerMovieGenre(int daysRented) {
    return 1;
  }
}