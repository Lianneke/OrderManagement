import java.util.ArrayList;

public class Store {

    private String storeName;
    private ArrayList<Medicine> medicines;

    public Store(String storeName) {
        this.storeName = storeName;
        this.medicines = new ArrayList<Medicine>();
    }

    public boolean addNewMedicine(Medicine medicine){
    if(findMedicine(medicine.getNumber()) >= 0){
        System.out.println("Medicine is already in store");
    return false;
    }
    medicines.add(medicine);
    return true;
    }


    private int findMedicine(Medicine medicine) {
        return this.medicines.indexOf(medicine);
    }

    private int findMedicine(String medicineNumber) {
        for(int i=0; i<this.medicines.size(); i++) {
            Medicine medicine = this.medicines.get(i);
            if(medicine.getNumber().equals(medicineNumber)) {
                return i;
            }
        }
        return -1;
    }
}
