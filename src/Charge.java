import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Charge {

    private String chargeNumber;
    private LocalDate expirationDate;
    private int quantity;
    private boolean discountPrice = false;

    public Charge(String chargeNumber,  LocalDate expirationDate, int quantity) {
        this.chargeNumber = chargeNumber;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public boolean discountAllowedON(Charge charge){
        long daysBetween = DAYS.between(LocalDate.now(), charge.getExpirationDate());
        if(daysBetween <= 30){
        this.discountPrice = true;
            return true;
        }else{
            return false;
        }
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

    public boolean isDiscountPrice() {
        return discountPrice;
    }

    public static Charge createNewCharge(String chargenumber, LocalDate expirationDate, int quantity){
        return new Charge(chargenumber, expirationDate, quantity);
    }
}
