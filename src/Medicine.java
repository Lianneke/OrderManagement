import java.util.ArrayList;

public class Medicine {

    private String number;
    private String name;
    private double price;
    private ArrayList<Charge> charges;

    public Medicine(String number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.charges = new ArrayList<Charge>();
    }

    public boolean addNewCharge(Charge charge){
        if(findCharge(charge.getChargeNumber()) >= 0){
            System.out.println("Charge already exists");
            return false;
        }
        charges.add(charge);
        return true;
    }

    public boolean removeCharge(Charge charge){
        int foundPosition = findCharge(charge);
        if(foundPosition <0){
            System.out.println(charge.getChargeNumber() + ", was  not found");
            return false;
        }
        this.charges.remove(foundPosition);
        System.out.println(charge.getChargeNumber() + ", was deleted");
        return true;
    }

    private int findCharge(Charge charge) {
        return this.charges.indexOf(charge);
    }

    private int findCharge(String chargeNumber) {
        for(int i=0; i<this.charges.size(); i++) {
            Charge charge = this.charges.get(i);
            if(charge.getChargeNumber().equals(chargeNumber)) {
                return i;
            }
        }
        return -1;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public ArrayList<Charge> getCharges() {
        return charges;
    }

    public static Medicine createMedicine(String number, String name, double price){
        return new Medicine(number, name, price);
    }
}
