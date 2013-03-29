package ua.porter.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/29/13
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class RandomBoxGenerator implements BoxGenerator {
    private Box currentBox;
    private Board board;

    public RandomBoxGenerator(Board board) {
        this.board = board;
        currentBox = randomXPositionBox(board.getDimensionFromZero());
        addCurrentBoxToBoard();

    }

    private Box randomXPositionBox(int xRange) {
        return new Box(board, (int) (Math.random() * xRange), xRange);
    }

    private void addCurrentBoxToBoard() {
        board.addObject(currentBox);
    }

    public void tick() {
        if (currentBox.isFlying) {
            currentBox.down();
        } else {
            currentBox = randomXPositionBox(board.getDimensionFromZero());
            addCurrentBoxToBoard();
        }

    }
}
