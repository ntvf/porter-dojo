package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GameObject {
    protected int x;
    protected int y;

    public Event redraw(Board board) {

        board.getCell(this.x, this.y).setObject(this);
        return new Event();
    }

    public void moveLeft(Board board) {
        board.clearCell(this.x, this.y);
        if (this.x == 0) {
            this.x = board.getDimensionFromZero();
        } else {
            this.x -= 1;
        }
    }

    public void moveRight(Board board) {
        board.clearCell(this.x, this.y);
        if (this.x == board.getDimensionFromZero()) {
            this.x = 0;
        } else {
            this.x += 1;
        }
    }
}
