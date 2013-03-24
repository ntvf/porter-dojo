package ua.porter.model;

import java.util.Arrays;

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
    private String board = null;
    public GameImpl() {
    }
    public  GameImpl(int dimension) {
        this.gameIsRunning = true;
        this.dimension = dimension;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dimension *dimension; i++) {
            sb.append(" ");
        }
        board = sb.toString();
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
        return this.board;
    }

    @Override
    public void tick() {

        this.gameIsRunning = false;
    }
}
