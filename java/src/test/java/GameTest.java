import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.Play(Symbol.O, 0, 0));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.X, 1, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.O, 0, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.O, 1, 0);
            game.Play(Symbol.X, 0, 0);
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInFirstColumn() throws Exception
    {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 1, 0);
        game.Play(Symbol.X, 0, 1);
        game.Play(Symbol.O, 1, 1);
        game.Play(Symbol.X, 0, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInFirstColumn() throws Exception
    {
        game.Play(Symbol.X, 2, 2);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 0, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleColumn() throws Exception
    {
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 1, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleColumn() throws Exception
    {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 1, 0);
        game.Play(Symbol.X, 2, 0);
        game.Play(Symbol.O, 1, 1);
        game.Play(Symbol.X, 2, 1);
        game.Play(Symbol.O, 1, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInThirdColumn() throws Exception
    {
        game.Play(Symbol.X, 2, 0);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 2, 1);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 2, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInThirdColumn() throws Exception
    {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 2, 0);
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 2, 1);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 2, 2);

        Symbol winner = game.getWinnerSymbol();

        assertEquals(Symbol.O, winner);
    }
}
