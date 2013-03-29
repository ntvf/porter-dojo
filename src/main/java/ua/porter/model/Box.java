package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/29/13
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Box extends GameObject {
    public Box(Board board, int xPosition, int yPosition) {
        this.board = board;
        this.x = xPosition;
        this.y = yPosition;
        this.isFlying = true;
    }

    public String toString() {
        return ObjectsLiterals.box;
    }

    public boolean isFalled() {
        return this.y == 0;
    }

    @Override
    protected boolean canMoveLeft() {
        if (this.x == 0) {
            return board.getCell(board.getDimensionFromZero(), this.y).isEmpty();
        }
        return board.getCell(this.x - 1, this.y).isEmpty();
    }

    @Override
    protected boolean canMoveRight() {
        if (this.x == board.getDimensionFromZero()) {
            return board.getCell(board.getDimensionFromZero(), this.y).isEmpty();
        }
        return board.getCell(this.x + 1, this.y).isEmpty();
    }
}
