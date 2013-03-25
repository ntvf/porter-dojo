package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GameObject implements Joystick {
    protected boolean isFlying;
    protected int x;
    protected int y;
    protected Board board;

    public Event redraw() {

        board.getCell(this.x, this.y).setObject(this);
        return new Event();
    }

    protected boolean shouldFell() {
        return (this.y > 0 && board.getCell(this.x, this.y - 1).isEmpty());

    }

    protected boolean canMoveLeft() { //TODO canMoveLeft
        return true;
    }

    protected boolean canMoveRight() { //TODO canMoveRight
        return true;
    }

    public void down() {
        board.clearCell(this.x, this.y);
        this.y -= 1;

        redraw();

    }

    public void up() {
        board.clearCell(this.x, this.y);
        if (this.y < board.getDimensionFromZero()) {
            this.y += 1;
        }

        redraw();
    }

    public void left() {
        board.clearCell(this.x, this.y);
        if (this.x == 0) {
            this.x = board.getDimensionFromZero();
        } else {
            this.x -= 1;
        }
        redraw();

    }

    public void right() {
        board.clearCell(this.x, this.y);
        if (this.x == board.getDimensionFromZero()) {
            this.x = 0;
        } else {
            this.x += 1;
        }
        redraw();
    }
}
