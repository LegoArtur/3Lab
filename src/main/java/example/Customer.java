package example;

import java.util.List;


@SuppressWarnings("StringConcatenationInLoop")
class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }


    public String getName() {
        return name;
    }

    public String getStatement() {
        String statement = String.format("Rental Record for %s\n", getName());
        statement = getString(statement);
        statement += String.format("Amount owed is %s\n", getTotalCharge());
        statement += String.format("You earned %d frequent renter points", getTotalBonusPoints());
        return statement;
    }
    private String getString(String result) {
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + '\n';
        }

        return result;
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalBonusPoints() {
        return rentals.stream().mapToInt(Rental::getBonusPoint).sum();
    }
}
