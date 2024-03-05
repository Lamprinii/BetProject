

class BetMain {
    public BetMain() {
    }

    public static void main(String[] args) {
        BetOrganization bo = BetOrganization.getInstance();
        bo.addBet(new FootballBet("AEK-PAOK", 1.2));
        bo.addBet(new FootballBet("PAO-OSFP", 1.3));
        bo.addBet(new FootballBet("PAO-PAOK", 1.4));
        bo.addBet(new BasketballBet("ARIS-OFI", 1.5));
        bo.addBet(new BasketballBet("LAMIA-PAO", 1.6));
        bo.addBet(new BasketballBet("OSFP-AEK", 1.1));
        Customer c1 = new Customer("Giannis Skampakakis");
        Customer c2 = new PlatinumCustomer("Nikos Pileos");
        c1.addCustomerBet(new CustomerBet("PAO-OSFP", "Football", 80, "X"));
        c1.addCustomerBet(new CustomerBet("OSFP-AEK", "Basketball", 50, "1"));
        c2.addCustomerBet(new CustomerBet("PAO-OSFP", "Football", 500, "2"));
        c2.addCustomerBet(new CustomerBet("AEK-PAOK", "Football", 50, "2"));
        c2.addCustomerBet(new CustomerBet("ARIS-OFI", "Basketball", 1500, "1"));
        bo.addCustomer(c1);
        bo.addCustomer(c2);
        GameEmulator.getInstance().doGameEmulation();
        BetOrganization.getInstance().showCustomersResults();
        BetOrganization.getInstance().printCustomersResultsToTextFile();
    }
}

