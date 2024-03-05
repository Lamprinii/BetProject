
import java.util.ArrayList;
import java.util.List;

public class Customer implements IGiveBetList {
    private String name;
    private List<CustomerBet> customerBetList = new ArrayList<>();

    public Customer(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void addCustomerBet(CustomerBet customerBet) {
        if (customerBet.getStake() <= this.getMaxStake()) {
            BetOrganization betOrganization = BetOrganization.getInstance();
            if (betOrganization.checkCustomerBetInList(customerBet)) {
                this.customerBetList.add(customerBet);
            }
        }
    }

    public int getMoneyPlayed() {
        return customerBetList.stream()
                .mapToInt(CustomerBet::getStake)
                .sum();
    }

    public int getMaxStake() {
        return 100;
    }

    public List<CustomerBet> getCustomerBetList() {
        return this.customerBetList;
    }

    public List<Bet> getBetList() {
        return customerBetList.stream()
                .map(customerBet -> (Bet) customerBet)
                .toList();
    }
}
