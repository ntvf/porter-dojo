package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PorterManipulator implements Joystick {

    private Board board;

    public PorterManipulator(Board board) {
        this.board = board;
    }

    @Override
    public void down() {

    }

    @Override
    public void up() {

    }

    @Override
    public void left() {
        board.movePorterLeft();

    }

    @Override
    public void right() {
        board.movePorterRight();

    }

    @Override
    public void act() {

    }
}
