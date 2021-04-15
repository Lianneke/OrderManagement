import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store("CZE");

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

        switch (action){
            case 0:
                System.out.println("bye!");
                quit = true;
                break;

            case 1:
                store.printListOfMedicines();
                break;

            case 2:
                addNewMedicine();
                break;

            case 3:
                removeMedicine();
                break;

            case 4:
                addNewChargeToMedicine();
        }
        }



    }

    private static void printOptions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - exit\n" +
                "1  - print medicines\n" +
                "2  - add a new medicine\n" +
                "3  - remove a medicine\n" +
                "4  - add a new charge to a medicine\n" +
                "5  - remove a charge from a medicine\n" +
                "6  - show available options\n");
        System.out.println("Choose your action: ");
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

    private static void removeMedicine(){
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

    private static void addNewChargeToMedicine() {
        store.printListOfMedicines();
        System.out.println("Enter the line number");
        int medicineChoice = scanner.nextInt() -1;
        scanner.nextLine();
        System.out.println("Enter new chargenumber: ");
        String chargeNumber = scanner.nextLine();
        System.out.println("Enter new expiration date: ");
        LocalDate expirationDate = scanner.nextLocalDate;
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        Charge newCharge = Charge.createNewCharge(chargeNumber, expirationDate, quantity);

        if (medicineChoice.addNewCharge(newCharge)) {
            System.out.println("New charge added: chargenumber = " + chargeNumber + ", expirationdate = " + expirationDate + ", quantity = " + quantity);
        } else {
            System.out.println("Cannot add, " + chargeNumber + " already on file");
        }
    }


}
