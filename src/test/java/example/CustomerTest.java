package example;

import org.junit.Test;

import java.util.List;

import static example.Movie.MovieType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
  @Test
  public void testNewReleaseType(){
    Customer customer = new Customer("John Doe", List.of(new Rental(new Movie("Rambo", REGULAR), 1)));

    assertTrue(customer.statement().contains("Amount owed is 2.0"));
    assertTrue(customer.statement().contains("You earned 1 frequent renter points"));
  }
  @Test
  public void testRegularType(){
    Customer customer = new Customer("John Doe", List.of(new Rental(new Movie("Lord of the Rings", NEW_RELEASE), 4)));

    assertTrue(customer.statement().contains("Amount owed is 12.0"));
    assertTrue(customer.statement().contains("You earned 2 frequent renter points"));
  }
  @Test
  public void testChildrenType(){
    Customer customer = new Customer("John Doe", List.of(new Rental(new Movie("Harry Potter", CHILDRENS), 5)));

    assertTrue(customer.statement().contains("Amount owed is 4.5"));
    assertTrue(customer.statement().contains("You earned 1 frequent renter points"));
  }
  @Test
  public void testThreeTypes(){
    Customer customer = new Customer("John Doe", List.of(new Rental(new Movie("Rambo", REGULAR), 1),
            new Rental(new Movie("Lord of the Rings", NEW_RELEASE), 4),
            new Rental(new Movie("Harry Potter", CHILDRENS), 5)));

    assertEquals("Rental Record for John Doe\n" +
            "\tRambo\t2.0\n" +
            "\tLord of the Rings\t12.0\n" +
            "\tHarry Potter\t4.5\n" +
            "Amount owed is 18.5\n" +
            "You earned 4 frequent renter points", customer.statement());
  }
}
