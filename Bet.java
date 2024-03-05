
import java.util.Objects;
public class Bet {
    private final String game;
    private final double odd;

    public Bet(String game, double odd) {
        this.game = game;
        this.odd = odd;
    }

    // public Bet(String betName, String betType, int stake, String choice) {
    // }

    public String getGame() {
        return this.game;
    }

    public double getOdd() {
        return this.odd;
    }

    public String toString() {
        return "Game: " + game + "and Odd: " + odd;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Double.compare(bet.odd, odd) == 0 && game.equals(bet.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, odd);
    }
}



