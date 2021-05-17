import java.time.LocalDate;

public class Charge {

    private String chargeNumber;
    private LocalDate expirationDate;
    private int quantity;
    private boolean discountPrice = false;
    private double discountPriceActive;

    public Charge(String chargeNumber,  LocalDate expirationDate, int quantity) {
        this.chargeNumber = chargeNumber;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public void setDiscountPriceActive(double discountPriceActive) {
        this.discountPriceActive = discountPriceActive;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountPriceActive() {
        return discountPriceActive;
    }

    public boolean isDiscountPrice() {
        return discountPrice;
    }

}
