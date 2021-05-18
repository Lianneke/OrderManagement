import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store("CZE");
    private static Pharmacy pharmacy = new Pharmacy("CZE");
    private static Search search = new Search();


    public static void main(String[] args) {

        LinkedList<OrderLine> orderLines = new LinkedList<OrderLine>();

        //Voorgecodeerde medicijnen
        Medicine medicine = new Medicine("158269", "Paracetamol 500mg", 1.99);
        Medicine medicine1 = new Medicine("8547963", "Bupivacaine 1,25mg", 2.98);
        store.addNewMedicine(medicine);
        store.addNewMedicine(medicine1);


        //voorgecodeerde klanten
        Customer customer = new Customer("1", "ETZ", "Teststraat 6", "06test", "test@testmail.com");
        pharmacy.addNewCustomer(customer);

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("bye!");
                    quit = true;
                    break;

                case 1:
                    System.out.println("ARTICLE OVERVIEW");
                    store.printListOfMedicines();
                    break;

                case 2:
                    collectNewMedicineData();
                    break;

                case 4:
                    store.printListOfMedicines();
                    collectDataToSearchForMedicine();
                    break;

                case 5:
                    printOptions();
                    break;

                case 6:
                    collectCustomerData();
                    break;

                case 7:
                    addNewCustomer();

                case 8:
                    store.printListOfMedicines();
                    collectDataToSearchForMedicine();

            }
        }


    }

    private static void printOptions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - exit\n" +
                "1  - print medicines\n" +
                "2  - add a new medicine\n" +
                "4  - add a new charge to a medicine\n" +
                "5  - show available options\n" +
                "6  - start to order\n" +
                "7  - add a new customer\n" +
                "8  - medication Adjustments\n");
        System.out.println("Choose your action: ");
    }

    private static void printOptionsEmployee() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - exit\n" +
                "1  - remove a medicine\n" +
                "2  - add a new charge to a medicine");
        System.out.println("Choose your action: ");
    }


    private static void collectNewMedicineData() {
        System.out.println("Enter new medicine number: ");
        String number = scanner.nextLine();
        System.out.println("Enter new medicine name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new medicine price: ");
        double price = scanner.nextDouble();

        createNewMedicine(number, name, price);
    }

    private static void createNewMedicine(String number, String name, double price) {
        Medicine newMedicine = new Medicine(number, name, price);
        addMedicineToStore(newMedicine);
    }

    private static void addMedicineToStore(Medicine medicine) {
        if (store.addNewMedicine(medicine)) {
            System.out.println("New medicine added: number = " + medicine.getNumber() + ", name = " + medicine.getName() + ", price = " + medicine.getPrice());
        } else {
            System.out.println("Cannot add, " + medicine.getNumber() + " already on file");
        }
    }

    private static void collectDataToSearchForMedicine() {
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        searchMedicine(number);
    }

    private static void searchMedicine(String number) {
        Medicine existingMedicineRecord = search.queryMedicine(number);
        if (existingMedicineRecord == null) {
            System.out.println("Medicine not found");
            return;
        } else {
            choiceBetweenRemoveMedicineAndAddingANewCharge(existingMedicineRecord);
        }
    }

    private static void choiceBetweenRemoveMedicineAndAddingANewCharge(Medicine existingMedicineRecord) {
        printOptionsEmployee();

        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {

            case 1:
                removeMedicineFromStore(existingMedicineRecord);
                break;

            case 2:
                collectNewChargeData(existingMedicineRecord);
                break;

        }
    }

    private static void removeMedicineFromStore(Medicine existingMedicineRecord) {
        if (store.removeMedicine(existingMedicineRecord)) {
            System.out.println("Medicine: " + existingMedicineRecord.getNumber() + " - " + existingMedicineRecord.getName() +
                    "\nSuccessfully deleted");
        } else {
            System.out.println("Error");
        }
    }

    private static void collectNewChargeData(Medicine existingMedicineRecord) {
        System.out.println("Enter new chargenumber: ");
        String chargeNumber = scanner.nextLine();
        System.out.println("Enter expiration date\n" +
                "Please use the following format: yyyy-mm-dd");
        String date = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(date);
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        createNewCharge(chargeNumber, expirationDate, quantity, existingMedicineRecord);
    }

    private static void createNewCharge(String chargeNumber, LocalDate expirationDate, int quantity, Medicine existingMedicineRecord) {
        Charge newCharge = new Charge(chargeNumber, expirationDate, quantity);
        addNewChargeToMedicine(newCharge, existingMedicineRecord);
    }


    private static void addNewChargeToMedicine(Charge newCharge, Medicine existingMedicineRecord) {
        if (existingMedicineRecord.addNewCharge(newCharge)) {
            System.out.println("New charge added: chargenumber = " + newCharge.getChargeNumber() + ", expirationDate = " + newCharge.getExpirationDate() + ", quantity = " + newCharge.getQuantity());
        } else {
            System.out.println("Cannot add, " + newCharge.getChargeNumber() + "already on file");
        }
    }

    public static void collectCustomerData() {
        pharmacy.printListOfCustomers();
        System.out.println("Enter you customerID");
        String customerID = scanner.nextLine();
        searchCustomer(customerID);
    }

    private static void searchCustomer(String customerID) {
        Customer existingCustomerRecord = pharmacy.queryCustomer(customerID);
        if (existingCustomerRecord == null) {
            System.out.println("Customer not found");
            return;
        }
        System.out.println("You are " + existingCustomerRecord.getName());
        searchMedicineToStartOrder(existingCustomerRecord);
    }

    private static void searchMedicineToStartOrder(Customer existingCustomerRecord){
        store.printListOfMedicines();
        System.out.println("Enter existing medicinenumber");
        String medicineNumber = scanner.nextLine();
        Medicine existingMedicineRecord = search.queryMedicine(medicineNumber);
        if(existingMedicineRecord == null){
            System.out.println("Medicine not found.");
            return;
        }else{
            continueOrderChargeChoice(existingCustomerRecord, existingMedicineRecord);
        }
    }

    private static void continueOrderChargeChoice(Customer existingCustomerRecord, Medicine existingMedicineRecord) {
        existingMedicineRecord.printListOfCharges();

        System.out.println("Enter existing chargenumber");
        String chargeNumber = scanner.nextLine();
        searchCharge(existingCustomerRecord, existingMedicineRecord, chargeNumber);
    }

    private static void searchCharge(Customer existingCustomerRecord, Medicine existingMedicineRecord, String chargeNumber) {
        Charge existingChargeNumber = existingMedicineRecord.queryCharge(chargeNumber);
        if (existingChargeNumber == null) {
            System.out.println("Charge not found");
            return;
        }
        verifingChargeChoice(existingChargeNumber, existingMedicineRecord, existingCustomerRecord);
    }

//    private static void checkIfDiscountIsAllowed(Charge existingChargeNumber, Medicine existingMedicineRecord, Customer existingCustomerRecord) {
//        double exitPrice = calculateDiscount.calculateIfChargeNeedsADiscount(existingChargeNumber, existingMedicineRecord);
//
//
//
//        //double Price = existingMedicineRecord.discountAllowed(existingChargeNumber);
//        ///System.out.println(Price);
//        verifingChargeChoice(existingChargeNumber, existingMedicineRecord, existingCustomerRecord, exitPrice);
//    }

    private static void verifingChargeChoice(Charge existingChargeNumber, Medicine existingMedicineRecord, Customer existingCustomerRecord) {
        System.out.println("Do you wanna order from this charge?\n" +
                "1. Yes\n" +
                "2. No\n");
        String orderAnswer = scanner.nextLine();

        switch (orderAnswer) {
            case "1":
                setHowManyPieces(existingChargeNumber, existingMedicineRecord, existingCustomerRecord);
                break;
            case "2":
                continueOrderChargeChoice(existingCustomerRecord, existingMedicineRecord);
            default:
                continueOrderChargeChoice(existingCustomerRecord, existingMedicineRecord);
        }
    }

    private static void setHowManyPieces(Charge existingChargeNumber, Medicine existingMedicineRecord, Customer existingCustomerRecord) {
        System.out.println("how many pieces do you want to order?");
        int pieces = scanner.nextInt();
        createNewOrderLine(existingChargeNumber, existingMedicineRecord, existingCustomerRecord, pieces);
    }

    private static void createNewOrderLine(Charge existingChargeNumber, Medicine existingMedicineRecord, Customer existingCustomerRecord, int pieces) {
        OrderLine newOrderLine = new OrderLine(existingMedicineRecord, existingChargeNumber, pieces);
        createNewOrder(existingCustomerRecord, newOrderLine);
    }

    //oplossen dat ordernummer automatisch wordt gegenereerd
    private static void createNewOrder(Customer existingCustomerRecord, OrderLine newOrderLine) {
        System.out.println("Enter date+time. Example: 202105101529");
        long orderNumber = scanner.nextLong();
        Order newOrder = new Order(existingCustomerRecord, orderNumber);
        addOrderLineToOrder(newOrder, newOrderLine);
        System.out.println("Thank you for your order");
//        continueOrdering(existingCustomerRecord, newOrder);
    }

//    private static void continueOrdering(Customer existingCustomerRecord, Order orderNumber){
//        System.out.println("Do you wish to continue ordering?\n" +
//                "1. Yes\n" +
//                "2. No\n");
//        String answer = scanner.nextLine();
//
//        switch (answer){
//            case "1":
//
//        }
//    }



    private static void addOrderLineToOrder(Order newOrder, OrderLine newOrderLine) {
        newOrder.addNewOrderLine(newOrderLine);
        printListOfOrderLines(newOrder);
    }

    public static void printListOfOrderLines(Order newOrder){
        System.out.println(newOrder.toString());
    }

    public static void addNewCustomer() {
        System.out.println("Enter new customerID");
        String customerID = scanner.nextLine();
        System.out.println("Enter new customername: ");
        String name = scanner.nextLine();
        System.out.println("Enter new customeraddress ");
        String address = scanner.nextLine();
        System.out.println("Enter new telephonenumber: ");
        String telephonenumber = scanner.nextLine();
        System.out.println("Enter new emailaddress: ");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(customerID, name, address, telephonenumber, email);
        if (pharmacy.addNewCustomer(newCustomer)) {
            System.out.println("New customer added: customerID = " + customerID + ", name = " + name + ", address = " + address + ", telephonenumber = " + telephonenumber + ", email = " + email);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }


}




