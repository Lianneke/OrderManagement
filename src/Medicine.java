public class Medicine {

    private String number;
    private String name;
    private double price;

    public Medicine(String number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
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

    public static Medicine createMedicine(String number, String name, double price){
        return new Medicine(number, name, price);
    }
}
