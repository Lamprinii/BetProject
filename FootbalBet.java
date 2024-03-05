
import java.util.List;
public class FootballBet extends Bet {
    private static final List<String> choices = List.of("1", "X", "2");
    private String outcome;

    public FootballBet(String game, double odd) {
        super(game, odd);
        this.outcome = choices.get((int) (Math.random() * choices.size()));
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public static List<String> getChoices() {

        return choices;
    }
    /*  public String getType() {
        return "Football";
    } */
}
