import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BetOrganization {
    private static final BetOrganization instance = new BetOrganization();
    private final List<Customer> cList = new ArrayList();
    private final List<Bet> betList = new ArrayList();

    private BetOrganization() {
    }

    public static BetOrganization getInstance() {
        return instance;
    }

    public boolean checkCustomerBetInList(CustomerBet customerBet) {
        for (Bet bet : betList) {
            if (bet.getGame().equals(customerBet.getBetName())) {
                return true;
            }
        }
        return false;
    }

    public List<Bet> getBetList() {
        return betList;
    }

    public void addCustomer(Customer customer) {
        cList.add(customer);
    }

    public void addBet(Bet bet) {
        betList.add(bet);
    }

    private double calculateGainsPerCustomer(IGiveBetList customer) {
        double gains = 0.0;
        for (CustomerBet customerBet : customer.getCustomerBetList()) {
            for (Bet bet : betList) {
                if (bet.getGame().equals(customerBet.getBetName()) &&
                        GameEmulator.getInstance().getEmulatedGamesResults().get(bet.getGame()).equals(customerBet.getChoice())) {
                    gains += (double) customerBet.getStake() * bet.getOdd();
                }
            }
        }
        return gains;
    }

    public void showCustomersResults() {
        System.out.println("------------------Results-------------------");
        for (Customer customer : cList) {
            System.out.println("####################################");
            System.out.println("Customer name: " + customer.getName());
            System.out.println("Customer money paid: " + customer.getMoneyPlayed());
            double customerGains = calculateGainsPerCustomer(customer);
            System.out.println("Customer gains: " + customerGains);
        }
        System.out.println("--------------End-of-Results----------------");
    }

    public void printCustomersResultsToTextFile() {
        try (FileWriter writer = new FileWriter("bet-results.txt")) {
            writer.write("------------------Results-------------------\n");
            for (Customer customer : cList) {
                writer.write("####################################\n");
                writer.write("Customer name: " + customer.getName() + "\n");
                writer.write("Customer money paid: " + customer.getMoneyPlayed() + "\n");
                double customerGains = calculateGainsPerCustomer(customer);
                writer.write("Customer gains: " + String.valueOf(customerGains) + "\n");
            }
            writer.write("--------------End-of-Results----------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
