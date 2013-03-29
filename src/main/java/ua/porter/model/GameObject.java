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

    protected abstract boolean canMoveLeft();

    protected abstract boolean canMoveRight();


    public void down() {
        if (shouldFell()) {
            clearContainingCell();
            this.y -= 1;
            redraw();
        } else {
            isFlying = shouldFell();
        }
    }

    public void up() {
        clearContainingCell();
        if (this.y < board.getDimensionFromZero()) {
            this.y += 1;
        }
        redraw();
    }

    public void left() {
        clearContainingCell();
        if (this.x == 0) {
            this.x = board.getDimensionFromZero();
        } else {
            this.x -= 1;
        }
        redraw();

    }

    public void right() {
        clearContainingCell();
        if (this.x == board.getDimensionFromZero()) {
            this.x = 0;
        } else {
            this.x += 1;
        }
        redraw();
    }


    private void clearContainingCell() {
        board.clearCell(this.x, this.y);
    }

    @Override
    public void act() {
        //No action Stub
    }
}
