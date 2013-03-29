package ua.porter.model;


/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameImpl implements Game {
    private boolean gameIsRunning;
    private Board board;
    private BoxGenerator boxGenerator;


    public GameImpl() {
    }

    public GameImpl(int dimension) {
        if (dimension <= 1) {
            throw new IllegalArgumentException("Board must be larger than 1");
        }
        this.gameIsRunning = true;
        board = new Board(dimension);
        Porter porter = new Porter(dimension - 1, board);
        porter.setOnEventListener(board);
        board.addPorter(porter);
        this.boxGenerator = new SimpleBoxGenerator(board);

    }

    public GameImpl(int dimension, int porterPositionStart) {   //TODO fix/invent solution for
        this(dimension);                                        // creating game with custom porter
        board.addPorter(new Porter(porterPositionStart, board));


    }

    @Override
    public Joystick getJoystick() {
        return board.getPorter();
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
        board.updateBoard();
    }

    @Override
    public String getBoardAsString() {

        return this.board.toString();
    }

    @Override
    public void tick() {
        boxGenerator.tick();
        board.updateBoard();

    }
}
