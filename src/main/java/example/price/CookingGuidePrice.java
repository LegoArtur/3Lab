package example.price;

public class CookingGuidePrice extends Price{
  @Override
  public double getCharge(int daysRented) {
    int charge = 2;

    if (daysRented > 2)
      charge += 1.4* (daysRented - 1) ;

    return charge;
  }
}