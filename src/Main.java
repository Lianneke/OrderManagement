import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store("CZE");


    public static void main(String[] args) {

        //Voorgecodeerde medicijnen
        Medicine medicine = new Medicine("158269", "Paracetamol 500mg", 1.99);
        Medicine medicine1 = new Medicine("8547963", "Bupivacaine 1,25mg", 2.98);
        store.addNewMedicine(medicine);
        store.addNewMedicine(medicine1);

        boolean quit = false;
        printOptions();

        while (!quit){
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

        switch (action){
            case 0:
                System.out.println("bye!");
                quit = true;
                break;

            case 1:
                System.out.println("ARTICLE OVERVIEW");
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
                break;

            case 5:
                printOptions();
                break;

            case 6:
                order();
                break;

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
                "5  - show available options\n" +
                "6  - start to order\n");
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
        System.out.println("Enter existing medicinenumber");
        String medicineNumber = scanner.nextLine();
        Medicine existingMedicineRecord = store.queryMedicine(medicineNumber);
        if(existingMedicineRecord == null){
            System.out.println("Medicine not found. ");
            return;
        }

        System.out.println("Enter new chargenumber: ");
        String chargeNumber = scanner.nextLine();
        System.out.println("Enter expiration date\n" +
                "Please use the following format: yyyy-mm-dd");
        String date = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(date);
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Charge newCharge = Charge.createNewCharge(chargeNumber, expirationDate, quantity);
        if(existingMedicineRecord.addNewCharge(newCharge)){
            System.out.println("New charge added: chargenumber = " + chargeNumber + " expirationDate = " + expirationDate + " quantity = " + quantity);
        }else{
            System.out.println("Cannot add, " + chargeNumber + "already on file");
        }

    }

    public static void order(){
        store.printListOfMedicines();
        System.out.println("Enter existing medicinenumber");
        String medicineNumber = scanner.nextLine();
        Medicine existingMedicineRecord = store.queryMedicine(medicineNumber);
        if(existingMedicineRecord == null){
            System.out.println("Medicine not found.");
            return;
        }
        existingMedicineRecord.printListOfCharges();
        System.out.println("Enter existing chargenumber");
        String chargeNumber = scanner.nextLine();
        Charge existingChargeNumber = existingMedicineRecord.queryCharge(chargeNumber);
        if(existingChargeNumber == null){
            System.out.println("Charge not found");
            return;
        }
        System.out.println(existingMedicineRecord.discountAllowed(existingChargeNumber));

    }

//    public static void removeCharge(){
//        store.printListOfMedicines();
//        System.out.println("Enter existing medicinenumber");
//        String medicineNumber = scanner.nextLine();
//        Medicine existingMedicineRecord = store.queryMedicine(medicineNumber);
//        if(existingMedicineRecord == null){
//            System.out.println("Medicine not found. ");
//            return;
//        }

//        System.out.println("Enter existing chargenumber");
//        String chargeNumber = scanner.nextLine();
//        Charge existingChargeRecord = existingMedicineRecord.queryCharge(chargeNumber);
//    }


}
