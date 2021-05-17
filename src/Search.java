import java.util.ArrayList;

public class Search {
//
//    public Medicine findMedicine(){
//
//    }
//
//

    public int findMedicine(ArrayList<Medicine> medicines, Medicine medicine) {

        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicineNumber = medicines.get(i);
            if (medicineNumber.getNumber().equals(medicine)) {
                return i;
            }
        }
        return -1;
    }

    public int findIndexOfMedicine(ArrayList<Medicine> medicines, Medicine medicine){
        return medicines.indexOf(medicine);
    }
}
