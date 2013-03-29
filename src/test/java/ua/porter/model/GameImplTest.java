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
        ourGame.newGame();
        assertEquals("Board is not adequate with size 3", "  ¤     ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isPlayerCreatedAfter_DefaultInit() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        String board = ourGame.getBoardAsString();
        assertEquals("There is no porter at hi default position", "♞", board.substring(board.length() - 1));
    }

    @Test
    public void isPlayerCreatedAfter_PutPorterInit() { //TODO Broken Test
        Game ourGame = new GameImpl(4, 3);
        ourGame.newGame();
        assertEquals("Porter is not at his position", "   ¤" +
                "    " +
                "    " +
                "   ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorking_Left() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().left();
        ourGame.tick();
        assertEquals("Porter is not moving left", "    " +
                "   ¤" +
                "    " +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorking_Right() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().left();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not moving right, but it can be if he csn't move left", "    " +
                "   ¤" +
                "    " +
                "   ♞", ourGame.getBoardAsString());
    }

    @Test
    public void isJoystickWorkingRight_InTheEndOfTheLine() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not moving right", "    " +
                "   ¤" +
                "    " +
                "♞   ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterCanJump_Right() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not jumping right", "    " +
                "   ¤" +
                "♞   " +
                "    ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterCanJump_Left() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        assertEquals("Porter is not jumping left", "    " +
                "   ¤" +
                "  ♞ " +
                "    ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingRight_AndFellingToTheGround() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not jumping left and felling to the ground", "    " +
                "    " +
                "   ¤" +
                "♞   ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingLeft_AndFellingToTheGroun() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();

        assertEquals("Porter is not jumping right and felling to the ground", "    " +
                "    " +
                "   ¤" +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingLeft_AndFellingToTheGround_AfterUpInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().up();
        ourGame.tick();
        assertEquals("Porter is not felling down after up in left jump", "    " +
                "    " +
                "   ¤" +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingLeft_AndFellingToTheGround_AfterLeftInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();
        assertEquals("Porter is not felling down after left in left jump", "    " +
                "    " +
                "   ¤" +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingLeft_AndFellingToTheGround_AfterRightInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not felling down after right in left jump", "    " +
                "    " +
                "   ¤" +
                "  ♞ ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingRight_AndFellingToTheGround_AfterUpInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().up();
        ourGame.tick();
        assertEquals("Porter is not felling down after up in right jump", "    " +
                "    " +
                "   ¤" +
                "♞   ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingRight_AndFellingToTheGround_AfterLeftInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();
        assertEquals("Porter is not felling down after left in right jump", "    " +
                "    " +
                "   ¤" +
                "♞   ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingRight_AndFellingToTheGround_AfterRightInJump() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("Porter is not felling down after right in right jump", "    " +
                "    " +
                "   ¤" +
                "♞   ", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingRight_AndFellingToTheGround_AndMovingRight_AndJumpingRight_AndFellingToTheGround() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().up();
        ourGame.getJoystick().right();
        ourGame.tick();
        ourGame.getJoystick().right();
        ourGame.tick();
        assertEquals("   ¤" +
                "    " +
                "    " +
                "  ♞¤", ourGame.getBoardAsString());
    }

    @Test
    public void PorterJumpingLeft_AndFellingToTheGround_AndMovingLeft_AndJumpingLeft_AndFellingToTheGround() {
        Game ourGame = new GameImpl(4);
        ourGame.newGame();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().up();
        ourGame.getJoystick().left();
        ourGame.tick();
        ourGame.getJoystick().left();
        ourGame.tick();
        assertEquals("Porter is not felling down after right in right jump", "   ¤" +
                "    " +
                "    " +
                "♞  ¤", ourGame.getBoardAsString());
    }
}
