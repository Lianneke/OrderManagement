import java.util.ArrayList;

public class Search {

    private ArrayList<Medicine>medicines;

    public Medicine findMedicine(Medicine medicine){
        for(int i = 0; i < medicines.size(); i++){
            Medicine medicineNumber = medicines.get(i);
            if(medicineNumber.getNumber().equals(medicine)){
                return medicine;
            }
        }
        return medicine;
    }

    public int findIndexOfMedicine(String medicineNumber){
       return medicines.indexOf(medicineNumber);
    }

    public Medicine queryMedicine(String number){
        int position = findIndexOfMedicine( number);
        if(position >=0){
            return this.medicines.get(position);
        }
        return null;
    }
}

//    public String queryMedicine(ArrayList<Medicine> medicines, Medicine medicine) {
//        if(findIndexOfMedicine(medicines, medicine) >=0){
//            return medicine.getNumber();
//        }
//        return null;
//    }


