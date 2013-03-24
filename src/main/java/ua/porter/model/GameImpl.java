package ua.porter.model;


/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameImpl implements Game {
    private int dimension;
    private boolean gameIsRunning;
    private Board board;

    public GameImpl() {
    }

    public GameImpl(int dimension) {
        if (dimension <= 1) {
            throw new IllegalArgumentException("Board must be larger than 1");
        }
        this.gameIsRunning = true;
        this.dimension = dimension;
        board = new Board(dimension);
        board.addObject(new Porter(dimension - 1));
    }

    public GameImpl(int dimension, int porterPositionStart) {
        this(dimension);
        board.addObject(new Porter(porterPositionStart));


    }

    @Override
    public Joystick getJoystick() {
        return null;
    }

    @Override
    public int getMaxScore() {
        return 0;
    }

    @Override
    public int getCurrentScore() {
        return 0;
    }

    @Override
    public boolean isGameOver() {
        return !gameIsRunning;
    }

    @Override
    public void newGame() {

    }

    @Override
    public String getBoardAsString() {

        return this.board.toString();
    }

    private String placePorter(Porter ourPorter) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void tick() {

        this.gameIsRunning = false;
    }
}
