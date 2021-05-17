import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalculateDiscount {

    private double amount;
    private double discountDouble = 0.75;


    public double calculateIfChargeNeedsADiscount(Charge charge, Medicine medicine){
        long daysBetween = DAYS.between(LocalDate.now(), charge.getExpirationDate());
        if(daysBetween <= 30){
            calculateDiscount(medicine);
            return amount;
        }else{
            return medicine.getPrice();
        }
    }

    private double calculateDiscount(Medicine medicine){
        double discountPrice = medicine.getPrice() * discountDouble;
        this.amount = discountPrice;
        return amount;
    }
}
