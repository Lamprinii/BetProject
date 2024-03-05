public class GoldCustomer extends Customer {
    public GoldCustomer(String n) {
        super(n);
    }

    public int getMaxStake() {
        return 1000;
    }
}
