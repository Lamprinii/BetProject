public class PlatinumCustomer extends Customer {
    public PlatinumCustomer(String n) {
        super(n);
    }

    public int getMaxStake() {
        return 2000;
    }
}
