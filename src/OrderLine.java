public class OrderLine {

    private Medicine medicine;
    private Charge charge;
    private int quantity;
    private double price;

    public OrderLine(Medicine medicine, Charge charge, int quantity, double price) {
        this.medicine = medicine;
        this.charge = charge;
        this.quantity = quantity;
        this.price = price;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Charge getCharge() {
        return this.charge;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + this.medicine.getName() + " Quantity: " + this.quantity + " Price: " + this.price;
    }

}
