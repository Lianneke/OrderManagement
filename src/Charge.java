

public class Charge {

    private String chargeNumber;
    //private LocalDate expirationDate;
    private int quantity;

    public Charge(String chargeNumber,  int quantity) {
        this.chargeNumber = chargeNumber;
       // this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    //public LocalDate getExpirationDate() {
    //    return expirationDate;
    //}

    public int getQuantity() {
        return quantity;
    }

    public static Charge createNewCharge(String chargenumber, int quantity){
        return new Charge(chargenumber, quantity);
    }
}
