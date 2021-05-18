public class OrderLine {

    private Medicine medicine;
    private Charge charge;
    private int quantity;


    public OrderLine(Medicine medicine, Charge charge, int quantity) {
        this.medicine = medicine;
        this.charge = charge;
        this.quantity = quantity;
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


    @Override
    public String toString() {
        return "Name: " + this.medicine.getName() + " Quantity: " + this.quantity;
    }

}
