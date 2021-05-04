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
    return false;
    }
    medicines.add(medicine);
    return true;
    }

    public void printListOfMedicines(){
        for(int i=0; i<this.medicines.size(); i++){
            System.out.println(i+1 + "." +
                    this.medicines.get(i).getNumber() + " - " +
                    this.medicines.get(i).getName() + " - " +
                    this.medicines.get(i).getPrice());
        }
    }

    public boolean removeMedicine(Medicine medicine){
        int foundPosition = findMedicine(medicine);
        if(foundPosition <0){
            return false;
        }
        this.medicines.remove(foundPosition);
        return true;
    }

    public boolean printListOfCharges(Medicine medicine){
        if(findMedicine(medicine.getNumber()) <0){
            return false;
        }
        System.out.println(medicine.getCharges());
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

    public String queryMedicine(Medicine medicine) {
        if(findMedicine(medicine) >=0){
            return medicine.getNumber();
        }
        return null;
    }

    public Medicine queryMedicine(String number){
        int position = findMedicine(number);
        if(position >=0){
            return this.medicines.get(position);
        }
        return null;
    }

}
