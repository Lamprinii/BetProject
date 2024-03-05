
import java.util.List;

public class CustomerBet {
    private final List<String> availableBetTypes = List.of("Football", "Basketball");
    private String betName;
    private String betType;
    private int stake;
    private String choice;

    public CustomerBet(String betName, String betType, int stake, String choice) {
        if (this.availableBetTypes.get(0) == betType && FootballBet.getChoices().contains(choice) || this.availableBetTypes.get(1) == betType && BasketballBet.getChoices().contains(choice)) {
            this.betName = betName;
            this.betType = betType;
            this.stake = stake;
            this.choice = choice;
        }

    }

    public String getBetName() {
        return this.betName;
    }

    public int getStake() {
        return this.stake;
    }

    public String getChoice() {
        return this.choice;
    }

    public String getBetType() {
        return this.betType;
    }
}
