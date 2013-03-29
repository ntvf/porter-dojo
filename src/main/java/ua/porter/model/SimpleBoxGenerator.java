package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/29/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleBoxGenerator implements BoxGenerator {
    private Box currentBox;
    private Board board;

    public SimpleBoxGenerator(Board board) {
        this.board = board;
        currentBox = new Box(board, board.getDimensionFromZero(), board.getDimensionFromZero());
        addCurrentBoxToBoard();

    }

    private void addCurrentBoxToBoard() {
        board.addObject(currentBox);
    }

    public void tick() {
        if (currentBox.isFlying) {
            currentBox.down();
        } else {
            currentBox = new Box(board, board.getDimensionFromZero(), board.getDimensionFromZero());
            addCurrentBoxToBoard();
        }

    }
}
