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

    public boolean addNewCharge(Charge charge) {
        charges.add(charge);
        return true;
    }
// sout line nog eruit halen
    public void printListOfCharges() {
        for (int i = 0; i < this.charges.size(); i++) {
            System.out.println(i + 1 + "." +
                    this.charges.get(i).getChargeNumber() + " - " +
                    this.charges.get(i).getExpirationDate() + " - " +
                    this.charges.get(i).getQuantity() + " - "
            );
        }
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

    public String queryCharge(Charge charge) {
        if(findCharge(charge) >=0){
            return charge.getChargeNumber();
        }
        return null;
    }

    public Charge queryCharge(String chargeNumber){
        int position = findCharge(chargeNumber);
        if(position >=0){
            return this.charges.get(position);
        }
        return null;
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
}
