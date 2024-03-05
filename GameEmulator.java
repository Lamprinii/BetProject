import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GameEmulator {
    private final Random random = new Random();
    private final Map<String, String> emulatedGamesResults = new HashMap<>();
    private final List<String> footballChoices = FootballBet.getChoices();
    private final List<String> basketballChoices = BasketballBet.getChoices();
    private static final GameEmulator instance = new GameEmulator();

    private GameEmulator() {
    }

    public static GameEmulator getInstance() {
        return instance;
    }

    public void doGameEmulation() {
        BetOrganization bo = BetOrganization.getInstance();
        List<Bet> betList = bo.getBetList();

        betList.forEach(bet -> {
            if (bet instanceof FootballBet) {
                emulatedGamesResults.put(bet.getGame(), footballChoices.get(random.nextInt(footballChoices.size())));
            } else if (bet instanceof BasketballBet) {
                emulatedGamesResults.put(bet.getGame(), basketballChoices.get(random.nextInt(basketballChoices.size())));
            }
        });
    }

    public Map<String, String> getEmulatedGamesResults() {
        return emulatedGamesResults;
    }
}
