import java.util.ArrayList;

public class Store {

    private Search search = new Search();

    private String storeName;
    private ArrayList<Medicine> medicines;

    public Store(String storeName) {
        this.storeName = storeName;
        this.medicines = new ArrayList<Medicine>();
    }

    public boolean addNewMedicine(Medicine medicine) {
        if (search.findMedicine(medicine).equals(medicine)) {
        return false;
    }else{
            medicines.add(medicine);
            return true;
        }
    }

    public boolean removeMedicine(Medicine medicine){
        if(search.findMedicine(medicine).equals(medicine)){
            this.medicines.remove(medicine);
            return true;
        }else{
            return false;
        }
    }


    public void printListOfMedicines(){
        for(int i=0; i<this.medicines.size(); i++){
            System.out.println(i+1 + "." +
                    this.medicines.get(i).getNumber() + " - " +
                    this.medicines.get(i).getName() + " - " +
                    this.medicines.get(i).getPrice());
        }
    }

    public boolean printListOfCharges(Medicine medicine){
        if(search.findMedicine(medicine).equals(medicine)){
            medicine.getCharges();
            return true;
        }else {
            return false;
        }
    }



//    private int findMedicine(Medicine medicine) {
//        return this.medicines.indexOf(medicine);
//    }

//    private int findMedicine(String medicineNumber) {
//        for(int i=0; i<this.medicines.size(); i++) {
//            Medicine medicine = this.medicines.get(i);
//            if(medicine.getNumber().equals(medicineNumber)) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public String queryMedicine(Medicine medicine) {
//        if(search.findIndexOfMedicine(medicines, medicine) >=0){
//            return medicine.getNumber();
//        }
//        return null;
//    }
//
//    public Medicine queryMedicine(String number){
//        int position = search.findIndexOfMedicine(medicines, number);
//        if(position >=0){
//            return this.medicines.get(position);
//        }
//        return null;
//    }

}
