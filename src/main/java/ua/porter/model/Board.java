package ua.porter.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tema
 * Date: 3/24/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board implements OnEventListener {
    private BoardCell[][] map;
    private List<GameObject> objectsOnTheBoard;
    private Porter porter;

    public Board(int dimension) {
        this.map = generateEmptyMap(dimension);
        objectsOnTheBoard = new LinkedList<GameObject>();
    }

    //TODO generate map from ready string
    public Board(String lineMap) {
        objectsOnTheBoard = new LinkedList<GameObject>();
    }


    public Joystick getJoyctick() {
        return porter;
    }


    public int getDimensionFromZero() {
        return map.length - 1;
    }

    public String toString() {
        StringBuilder formation = new StringBuilder();
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                formation.append(map[rowIndex][colIndex].toString());

            }
        }
        return formation.toString();
    }

    public BoardCell[][] getMap() {
        return map;
    }

    public void addObject(GameObject entity) {
        objectsOnTheBoard.add(entity);
    }

    public void addPorter(Porter porter) {
        this.porter = porter;
        addObject(porter);
    }

    public void updateBoard() {
        Iterator<GameObject> it = objectsOnTheBoard.iterator();
        while (it.hasNext()) {
            it.next().redraw();
        }

    }

    public BoardCell getCell(int x, int y) {

        return findCell(x, y);
    }

    public void clearCell(int x, int y) {
        findCell(x, y).clear();
    }

    private BoardCell findCell(int x, int y) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if (map[rowIndex][colIndex].equals(new BoardCell(x, y))) {
                    return map[rowIndex][colIndex];
                }
                ;
            }
        }
        throw new IllegalArgumentException();
    }

    private BoardCell[][] generateEmptyMap(int dimension) {
        BoardCell[][] generatedMap = new BoardCell[dimension][dimension];
        int startHelpIndex = dimension - 1;
        for (int rowIndex = 0; rowIndex <= dimension - 1; rowIndex++) {
            for (int colIndex = 0; colIndex <= dimension - 1; colIndex++) {
                generatedMap[rowIndex][colIndex] = new BoardCell(colIndex, startHelpIndex);
            }
            startHelpIndex--;
        }
        return generatedMap;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println(event.getEventCode());
        if (event.getEventCode() == Event.MOVING_RIGHT) {
            event.getTaking().right();
            event.getGenerating().right();
        }

        if (event.getEventCode() == Event.MOVING_LEFT) {
            event.getTaking().left();
            event.getGenerating().left();
        }
    }
}
