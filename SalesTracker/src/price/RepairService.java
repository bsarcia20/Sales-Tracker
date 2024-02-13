package price;

public class RepairService extends Product implements Sellable {
    private int hours;

    public RepairService(String name, double price, int hours) {
        super(name, price);
        this.hours = hours;
    }

    @Override
    public double calculateTotalSales() {
        return getPrice() * hours;
    }
}