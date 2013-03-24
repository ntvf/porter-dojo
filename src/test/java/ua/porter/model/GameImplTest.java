package ua.porter.model;


import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameImplTest {
    @Test(expected = IllegalArgumentException.class)
    public void boardInitialization_Decimal() {
        Game ourGame = new GameImpl(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void boardInitialization_Zero() {
        Game ourGame = new GameImpl(0);
    }

    @Test
    public void isRunnigAfterInit() {
        Game ourGame = new GameImpl(3);
        assertFalse("The game is over after initializtion", ourGame.isGameOver());
    }

    @Test
    public void isBoardExistAfter_DefaultInit3() {
        Game ourGame = new GameImpl(3);
        assertEquals("Board is not adequate with size 3", "        ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isPlayerCreatedAfter_DefaultInit() {
        Game ourGame = new GameImpl(4);
        String board = ourGame.getBoardAsString();
        assertEquals("There is no porter at hi default position", "♞", board.substring(board.length() - 1));
    }

    @Test
    public void isPlayerCreatedAfter_PutPorterInit() { //TODO Broken Test
        Game ourGame = new GameImpl(4, 3);
        assertEquals("Porter is not at his position", "    " +
                "    " +
                "    " +
                "   ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorking_Left() {
        Game ourGame = new GameImpl(4);
        ourGame.getJoystick().left();
        assertEquals("Porter is not moving left", "    " +
                "    " +
                "    " +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorking_Right() {
        Game ourGame = new GameImpl(4);
        ourGame.getJoystick().left();
        ourGame.getJoystick().right();
        assertEquals("Porter is not moving right", "    " +
                "    " +
                "    " +
                "   ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorkingRight_InTheEndOfTheLine() {
        Game ourGame = new GameImpl(4);
        ourGame.getJoystick().right();
        assertEquals("Porter is not moving right", "    " +
                "    " +
                "    " +
                "♞   ", ourGame.getBoardAsString());
    }

}
