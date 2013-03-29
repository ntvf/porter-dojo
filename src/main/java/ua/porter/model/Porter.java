package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Porter extends GameObject {
    private boolean movedInJump;

    public Porter(int startPosition, Board board) {
        this.board = board;
        this.x = startPosition;
        this.y = 0;
    }

    public String toString() {
        return ObjectsLiterals.porter;
    }

    @Override
    protected boolean canMoveLeft() {
        GameObject neighbour;
        if (this.x == 0) {
            neighbour = board.getCell(board.getDimensionFromZero(), this.y).getObject();
            if (neighbour == null) {
                return true;
            }
            return neighbour.canMoveLeft();
        }
        neighbour = board.getCell(this.x - 1, this.y).getObject();
        if (neighbour == null) {
            return true;
        }
        return neighbour.canMoveLeft();
    }

    @Override
    protected boolean canMoveRight() {
        GameObject neighbour;
        if (this.x == board.getDimensionFromZero()) {
            neighbour = board.getCell(0, this.y).getObject();
            if (neighbour == null) {
                return true;
            }
            return neighbour.canMoveRight();
        }
        neighbour = board.getCell(this.x + 1, this.y).getObject();
        if (neighbour == null) {
            return true;
        }
        return neighbour.canMoveRight();
    }

    @Override
    public void up() {
        if (isFlying) {
            super.down();
            isFlying = shouldFell();
        } else {
            super.up();
            isFlying = true;
            return;
        }


    }

    @Override
    public void left() {
        if (isFlying) {
            if (!movedInJump && canMoveLeft()) {
                super.left();
                movedInJump = true;
                return;
            } else {
                super.down();
                isFlying = shouldFell();
                movedInJump = isFlying;
                return;
            }

        }
        if (canMoveLeft()) {
            super.left();
        }
    }

    @Override
    public void right() {
        if (isFlying) {
            if (!movedInJump && canMoveRight()) {
                super.right();
                movedInJump = true;
                return;
            } else {
                super.down();
                isFlying = shouldFell();
                movedInJump = isFlying;
                return;
            }

        }
        if (canMoveRight()) {
            super.right();
        }
    }
}
