import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store("CZE");

    public static void main(String[] args) {

        addNewMedicine();
        store.printListOfMedicines();
    }
    private static void addNewMedicine() {
        System.out.println("Enter new medicine number: ");
        String number = scanner.nextLine();
        System.out.println("Enter new medicine name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new medicine price: ");
        double price = scanner.nextDouble();
        Medicine newMedicine = Medicine.createMedicine(number, name, price);
        if (store.addNewMedicine(newMedicine)) {
            System.out.println("New medicine added: number = " + number + ", name = " + name + ", price = " + price);
        } else {
            System.out.println("Cannot add, " + number + " already on file");
        }
    }

    private static void removeContact(){
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        Medicine existingMedicineRecord = store.queryMedicine(number);
        if (existingMedicineRecord == null){
            System.out.println("Medicine not found");
            return;
        }

        if(store.removeMedicine(existingMedicineRecord)){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Error");
        }
    }
}
