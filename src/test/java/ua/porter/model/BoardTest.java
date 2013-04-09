package ua.porter.model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest {
    @Test
    public void isTrueGenerated_EmptyMap() {
        Board board = new Board(3);
        BoardCell[][] result = board.getMap();
        BoardCell[][] expected = {{new BoardCell(0, 2), new BoardCell(1, 2), new BoardCell(2, 2)},
                {new BoardCell(0, 1), new BoardCell(1, 1), new BoardCell(2, 1)},
                {new BoardCell(0, 0), new BoardCell(1, 0), new BoardCell(2, 0)}};
        assertArrayEquals("Error when generating empty map", expected, result);
    }

    @Test
    public void isTrueConverting_EmptyMapToString() {
        Board board = new Board(3);
        assertEquals("False to convert empty map to String", "         ", board.toString());
    }

}
