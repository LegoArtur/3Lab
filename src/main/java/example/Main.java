package example;

import example.price.ChildrenPrice;
import example.price.NewReleasePrice;
import example.price.RegularPrice;

import java.util.List;

public class Main {
    public static final Movie REMBO = new Movie("Rembo", new RegularPrice());
    public static final Movie LOTR = new Movie("Lord of the Rings", new NewReleasePrice());
    public static final Movie HARRY_POTTER = new Movie("Harry Potter", new ChildrenPrice());
    public static final Movie COOKING_GUIDE = new Movie("Cooking guide", new ChildrenPrice());

    public static void main(String[] args) {
        List<Rental> rentals = List.of(new Rental(REMBO, 1),
                new Rental(LOTR, 4),
                new Rental(HARRY_POTTER, 5),
                new Rental(COOKING_GUIDE, 4));

        String statement = new Customer("John Doe", rentals).getStatement();

        System.out.println(statement);
    }
}
