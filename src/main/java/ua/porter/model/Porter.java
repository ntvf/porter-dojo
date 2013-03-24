package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Porter extends GameObject {

    public Porter(int startPosition, Board board) {
        this.board = board;
        this.x = startPosition;
        this.y = 0;
    }

    public String toString() {
        return ObjectsLiterals.porter;
    }


    @Override
    public void down() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void up() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void act() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
