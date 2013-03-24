package ua.porter.model;




import org.junit.Test;
import ua.porter.model.Game;
import ua.porter.model.GameImpl;
import java.lang.NegativeArraySizeException;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameImplTest {
    @Test
    public void isRunnigAfterInit() {
        Game ourGame = new GameImpl(3);
        assertFalse("Game is not over",ourGame.isGameOver());
    }

    @Test
    public void isBoardExistAfterInit3() {
        Game ourGame = new GameImpl(3);
        assertEquals("         ",ourGame.getBoardAsString());
    }

    @Test
    public void isBoardExistAfterInit4() {
        Game ourGame = new GameImpl(4);
        assertEquals("                ",ourGame.getBoardAsString());
    }

    @Test
    public void isPlayerCreated() {
        Game ourGame = new GameImpl(4);
        assertEquals("               ♞",ourGame.getBoardAsString());
    }
}
