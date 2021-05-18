import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiscountExpirationDate implements IPriceCalculator {


    // deze klasse gaat loopen door de lijst van bestelregels en moet controleren
    //of er een charge tussen zit met een kortere houdbaarheidsdatum


    // private Order order;
    private double amount;
    private double discountDouble = 0.75;
    private int discountDays = 30;

    public double searchForChargesInOrder(Order order) {
        for (OrderLine o : order.getOrderLines()) {
            long daysBeteen = DAYS.between(LocalDate.now(), o.getCharge().getExpirationDate());
            if (daysBeteen <= discountDays) {
                calculateDiscount(o.getMedicine());
                return amount;
            } else {
                this.amount = o.getMedicine().getPrice();
                return amount;
            }
        }
        return amount;
    }


    private double calculateDiscount(Medicine medicine){
        double discountPrice = medicine.getPrice() * discountDouble;
        this.amount = discountPrice;
        return amount;
    }

}
