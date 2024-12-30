package Chapter10;

public class PieceWorker extends Employee{

    private double wage;
    private int pieces;
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, int year, int month, int day, double wage, int pieces) {
        super(firstName, lastName, socialSecurityNumber, year, month, day);
        this.wage = wage;
        this.pieces = pieces;
    }

    @Override
    public double getPaymentAmount() {
        return wage * pieces;
    }

    @Override
    public String toString() {
        return String.format("piece worker: %s%n%s: $%,.2f; %s: %d",
                super.toString(), "wage per piece", wage,
                "number of pieces", pieces);
    }
}
